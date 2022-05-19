
import java.util.function.Supplier;

/**
 *
 * @author gdm1
 */
public class IntegerArraySupplier implements Supplier<Integer[]>
{
    private int minLength;
    private int maxLength;
    private int minValue;
    private int maxValue;

    public IntegerArraySupplier()
    {
        this(1, 10, 2, 6);
    }
    
    public IntegerArraySupplier(int minLength, int maxLength, int minValue, int maxValue)
    {
        if (minLength < 0)
        {
            throw new IllegalArgumentException("Array length cannot be less than zero");
        }
        
        if (maxLength < minLength || maxValue < minValue)
        {
            throw new IllegalArgumentException("The maximum cannot be less than the minimum");
        }
        
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public Integer[] get()
    {
        int arrayLength = (int) (Math.random() * (maxLength - minLength + 1) + minLength);
        Integer[] array = new Integer[arrayLength];
        for (int i = 0; i < arrayLength; i++)
        {
            array[i] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        }
        return array;
    }

}
