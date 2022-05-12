package Week9.Task3.test;


import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class Book implements Serializable
{

    private final String title;
    private final String author;
    private final String ISBN;
    private Copy[] copies;
    private int numberOfCopies;

    public Book(String title, String author, String ISBN) throws EmptyStringException
    {
        String errorMsg = "";
        if (title == null || title.isEmpty())
        {
            errorMsg += "Title must have a value. ";
        }
        if (author == null || author.isEmpty())
        {
            errorMsg += "Author must have a value. ";
        }
        if (ISBN == null || ISBN.isEmpty())
        {
            errorMsg += "ISBN must have a value. ";
        }
        if (!errorMsg.isEmpty())
        {
            throw new EmptyStringException(errorMsg);
        }

        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = new Copy[5];
        this.numberOfCopies = 0;
    }

    public boolean addCopy(Copy c)
    {
        if (numberOfCopies < copies.length)
        {
            copies[numberOfCopies++] = c;
            return true;
        }
        return false;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public Copy findCopy(int copyId) throws CopyNotFoundException
    {
        try
        {
            return Arrays
                    .stream(copies)
                    .filter(c -> c.getId() == copyId)
                    .findFirst()
                    .get();
        }
        catch (NoSuchElementException e)
        {
            throw new CopyNotFoundException(copyId);
        }
    }

    public Copy[] getCopies()
    {
        return copies;
    }

    @Override
    public String toString()
    {
        return super.toString()
                + " - " + "title=" + title
                + ", author=" + author
                + ", ISBN=" + ISBN
                + ", numberOfCopies=" + numberOfCopies
                + ", copies=" + copies.toString()
                + " - " + copies[0]
                + " - " + copies[1]
                + " - " + copies[2];
    }

}