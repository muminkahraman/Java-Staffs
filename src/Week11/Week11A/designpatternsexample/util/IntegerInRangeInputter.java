package Week11.Week11A.designpatternsexample.util;

/**
 *
 * @author gdm1
 */
public class IntegerInRangeInputter extends Inputter<Integer>
{

    private final int min;
    private final int max;
    
    public IntegerInRangeInputter(int min, int max)
    {
        super();
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer input(String prompt)
    {
        final IntegerInputter inputter = new IntegerInputter();
        
        int num = inputter.input(prompt);

        while (num > max || num < min)
        {
            System.out.println("\nERROR: Please enter an integer in the range " + min + "-" + max);
            num = inputter.input(prompt);
        }

        return num;
    }
}
