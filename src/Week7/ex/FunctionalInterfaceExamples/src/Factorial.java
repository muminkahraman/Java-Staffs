
import java.util.function.Function;

/**
 *
 * @author gdm1
 */
public class Factorial implements Function<Integer, Integer>
{

    @Override
    public Integer apply(Integer t)
    {
        if (t < 0)
        {
            throw new IllegalArgumentException("Factorial cannot be calculated for negative integers");
        }
        
        int sum = 1;
        for (int i = 2; i <= t; i++)
        {
            sum *= i;
        }
        return sum;
    }

}
