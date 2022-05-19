package Week11.Week11A.designpatternsexample.util;

/**
 *
 * @author gdm1
 */
public class StringInputter extends Inputter<String>
{

    public StringInputter()
    {
        super();
    }

    @Override
    public String input(String prompt)
    {
        System.out.println(prompt);
        return kybd.nextLine();
    }
}
