package Week9.Task3.test;

public class BookNotFoundException extends Exception
{

    public BookNotFoundException(String isbn)
    {
        super("There is no book with ISBN: " + isbn);
    }

}