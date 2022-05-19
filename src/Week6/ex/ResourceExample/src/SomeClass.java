
/**
 *
 * @author gdm1
 */
public class SomeClass
{

    public SomeClass()
    {
        System.out.println("SomeClass constructor");
        // initialise the resource
    }
    
    public void doSomethingWrong() throws Exception
    {
        // an exception is thrown while using the resource
        throw new Exception("doSomethingWrong() did something wrong!");
    }

    public void close()
    {
        System.out.println("SomeClass close()");
        // close the resource
    }
}
