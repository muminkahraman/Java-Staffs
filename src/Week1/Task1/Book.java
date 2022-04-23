package Week1.Task1;

public class Book {
    private String author;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    private String title;

    public Book (String title){
        this.title = title;
        this.author = "Anon";
    }

    public Book (String author, String title){
        this.title = title;
        this.author = author;
    }


}
