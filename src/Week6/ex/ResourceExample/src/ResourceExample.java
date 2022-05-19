/**
 *
 * @author gdm1
 */
public class ResourceExample
{

    public static void main(String[] args)
    {
        try
        {
            System.out.println("main() try block");
            SomeClass sc = new SomeClass();
//            sc.doSomethingWrong();
            sc.close();
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
