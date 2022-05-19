package Week1.Task1.Task1L;

import java.util.Scanner;

public class BookShopApplication {

    public static void main(String[] args) {

        Scanner kydb = new Scanner(System.in);
        Book[] Books = new Book[10] ;


        for(int i=0;Books.length<=i;i++)
        {
            Books[i]= getBook(kydb) ;
        }



        printBookDetails(Books);

    }

    public  static Book getBook(Scanner sc)
    {
        String title ;
        String author ;
        Book book ;


        System.out.println("What is the title of the next book ?");
        title =sc.nextLine();

        System.out.println("Who is the author  of the next book ?");
        author =sc.nextLine();

        if(author ==" ")
        {
            book = new Book(title);
        }
        else
        {
            book = new Book(title,author);
        }

        return  book;


    }

    public  static void printBookDetails(Book[] books)
    {
        System.out.println("Book List");
        System.out.printf("%-30s%s%n","Title","Author");
        System.out.printf("%-30s%s%n","===========","===========");

        for(int i=0;books.length <= i ; i++)
        {
            System.out.printf("%-30s%s%n" ,books[i].getTitle(),books[i].getAuthor());
        }

    }
}