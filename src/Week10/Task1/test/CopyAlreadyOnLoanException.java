package Week10.Task1.test;

public class CopyAlreadyOnLoanException extends RuntimeException
{

    public CopyAlreadyOnLoanException(int copyId)
    {
        super("Copy " + copyId + " is already on loan");
    }

}