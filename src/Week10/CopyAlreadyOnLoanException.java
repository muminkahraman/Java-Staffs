package Week10;

public class CopyAlreadyOnLoanException extends RuntimeException
{

    public CopyAlreadyOnLoanException(int copyId)
    {
        super("Copy " + copyId + " is already on loan");
    }

}