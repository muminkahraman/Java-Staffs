package Week9.Task3.test;

public class CopyNotOnLoanException extends RuntimeException
{

    public CopyNotOnLoanException(int copyId)
    {
        super("Copy " + copyId + " is not on loan");
    }

}