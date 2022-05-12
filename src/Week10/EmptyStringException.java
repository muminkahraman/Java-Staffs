package Week10;

public class EmptyStringException extends Exception
{

    public EmptyStringException()
    {
        this("A string was null or empty");
    }

    public EmptyStringException(String string)
    {
        super(string);
    }
}