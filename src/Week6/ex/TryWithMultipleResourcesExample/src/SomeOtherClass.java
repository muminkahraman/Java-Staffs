
/**
 *
 * @author gdm1
 */
public class SomeOtherClass implements AutoCloseable
{

    public SomeOtherClass()
    {
        System.out.println("SomeOtherClass constructor");
        // initialise the resource
    }
    
    @Override
    public void close() throws Exception
    {
        System.out.println("SomeOtherClass close()");
        // close the resource
    }
}
