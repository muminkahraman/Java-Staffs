package Week10;

public class CopyNotOnLoanException extends RuntimeException
{

    public CopyNotOnLoanException(int copyId)
    {
        super("Copy " + copyId + " is not on loan");
    }

}