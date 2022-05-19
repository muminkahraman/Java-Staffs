/**
 *
 * @author gdm1
 */
public class CustomExceptionExamples
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
        catch (CustomCheckedException e)
        {
            System.out.println("\n\tThe custom checked exception was caught in method1() because it has a try-catch statement");
        }
        
        try
        {
            System.out.println("\n\tmethod1() is about to call method4()");
            method4();
            System.out.println(
                    "\n\tmethod4() has completed and control returned to method1(), "
                    + "\n\tbut this statement in method1() is never executed because of the exception");
        }
        catch (CustomUncheckedException e)
        {
            System.out.println("\n\tThe custom unchecked exception was caught in method1() because it has a try-catch statement");
        }
    }
    
    private static void method2() throws CustomCheckedException
    {
        System.out.println("\n\t\tmethod2() is about to call method3()");
        System.out.println(
                "\t\tBecause method2() does not have a try-catch statement to handle "
                + "\n\t\tthe custom checked exception thrown by method3(), it must declare (on line 31) "
                + "\n\t\tthat it throws the exception");
        method3();
        System.out.println("\t\tThis statement in method2() is never executed because of the exception");
    }
    
    private static void method3() throws CustomCheckedException
    {
        System.out.println("\n\t\t\tmethod3() is about to throw a custom checked exception");
        System.out.println(
                "\t\t\tBecause it does not have a try-catch statement to handle the "
                + "\n\t\t\tcustom checked exception, it must declare (on line 42) that it "
                + "\n\t\t\tthrows the exception");
        throw new CustomCheckedException("An error message");
    }
    
    private static void method4()
    {
        System.out.println("\n\t\tmethod4() is about to call method5()");
        System.out.println(
                "\t\tAlthough method4() does not have a try-catch statement to "
                + "\n\t\thandle the custom unchecked exception thrown by method5(), "
                + "\n\t\tbecause it is an unchecked exception, method4() does not "
                + "\n\t\thave to declare that it throws the exception");
        method5();
        System.out.println("\t\tThis statement in method4() is never executed because of the exception");
    }
    
    private static void method5()
    {
        System.out.println("\n\t\t\tmethod5() is about to throw a custom unchecked exception");
        System.out.println(
                "\t\t\tBecause it is an unchecked exception, it does not "
                + "\n\t\t\thave to declare that it throws the exception");
        throw new CustomUncheckedException("An error message");
    }
}
