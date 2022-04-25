package Week6.Task2_test;

public class TryWithResourceExample
{

    public static void main(String[] args)
    {
        try (SomeClass sc = new SomeClass();)
        {
            System.out.println("main() try block");
            sc.doSomethingWrong();
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