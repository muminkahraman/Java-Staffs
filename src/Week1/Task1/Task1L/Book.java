package Week1.Task1.Task1L;

public class Book {

    private String author ;
    private String title ;

    public Book(String title)
    {
        this.title = title ;
        author = "Anon" ;
    }

    public Book(String title , String author)
    {
        this.title = title ;
        this.author  = author ;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}