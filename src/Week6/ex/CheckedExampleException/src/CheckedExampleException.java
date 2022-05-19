/**
 *
 * @author gdm1
 */
public class CheckedExampleException
{

    public static void main(String[] args)
    {
        System.out.println("main() is about to call method1()");
        method1();
        System.out.println("\nmethod1() completed and control returned to main()");
    }
    
    private static void method1()
    {
        try
        {
            System.out.println("\n\tmethod1() is about to call method2()");
            method2();
            System.out.println(
                    "\n\tmethod2() has completed and control returned to method1(), "
                    + "\n\tbut this statement in method1() is never executed because of the exception");
        }
        catch (Exception e)
        {
            System.out.println("\n\tThe exception was caught in method1() because it has a try-catch statement");
        }
    }
    
    private static void method2() throws Exception
    {
        System.out.println("\n\t\tmethod2() is about to call method3()");
        System.out.println(
                "\t\tBecause method2() does not have a try-catch statement to handle "
                + "\n\t\tthe exception thrown by method3(), it must declare (on line 31) "
                + "\n\t\tthat it throws the exception");
        method3();
        System.out.println("\t\tThis statement in method2() is never executed because of the exception");
    }
    
    private static void method3() throws Exception
    {
        System.out.println("\n\t\t\tmethod3() is about to throw a checked exception");
        System.out.println(
                "\t\t\tBecause it does not have a try-catch statement to handle the "
                + "\n\t\t\tchecked exception, it must declare (on line 42) that it "
                + "\n\t\t\tthrows the exception");
        throw new Exception("An error message");
    }
}
