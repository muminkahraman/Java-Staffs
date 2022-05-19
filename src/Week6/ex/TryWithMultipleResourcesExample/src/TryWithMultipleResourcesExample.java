/**
 *
 * @author gdm1
 */
public class TryWithMultipleResourcesExample
{

    public static void main(String[] args)
    {
        try (SomeClass sc = new SomeClass(); SomeOtherClass soc = new SomeOtherClass())
        {
            System.out.println("main() try block");
//            sc.doSomethingWrong();
        }
        catch (Exception e)
        {
            System.out.println("main() catch block: " + e.getMessage());
        }
        finally
        {
            System.out.println("main() finally block");
        }
    }
}
