package Week10.Task1;

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