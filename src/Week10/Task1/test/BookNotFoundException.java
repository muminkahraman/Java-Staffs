package Week10.Task1.test;

public class BookNotFoundException extends Exception
{

    public BookNotFoundException(String isbn)
    {
        super("There is no book with ISBN: " + isbn);
    }

}