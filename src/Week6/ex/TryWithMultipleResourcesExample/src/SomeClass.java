
/**
 *
 * @author gdm1
 */
public class SomeClass implements AutoCloseable
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

    @Override
    public void close() throws Exception
    {
        System.out.println("SomeClass close()");
        //close the resource
    }
}
