package Week10;

public class BookNotFoundException extends Exception
{

    public BookNotFoundException(String isbn)
    {
        super("There is no book with ISBN: " + isbn);
    }

}