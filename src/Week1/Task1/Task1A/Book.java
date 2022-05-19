
package Week1.Task1.Task1A;

public class Book
{
    private String author;
    private String title;

    public Book(String author, String title)
    {
        this.author = author;
        this.title = title;
    }

    public Book(String title)
    {
        this.title = title;
        author="Anon";
    }
    
 

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }
   
    
}
