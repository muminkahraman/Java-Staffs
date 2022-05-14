package Week10.Task1.test;

public class CopyNotFoundException extends Exception
{

    public CopyNotFoundException(int copyId)
    {
        super("There is no copy with id: " + copyId);
    }

    public CopyNotFoundException(int copyId, Throwable thrwbl)
    {
        super("There is no copy with id: " + copyId, thrwbl);
    }

}