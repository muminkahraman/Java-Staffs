
package Week1.Task1.Task1A;

import java.util.ArrayList;
import java.util.Scanner;


public class BookShopApplicqtion
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        ArrayList<Book> books= new ArrayList<>();
        System.out.println(books.size());
        for (int i=0;i<10;i++) books.add(i, getBook(kybd));
     printBookDetails(books);   
    }
    
    private static Book getBook(Scanner kybd){
        Book b =new Book(kybd.nextLine());
        return b;
        
    }
    
    
    private static void printBookDetails(ArrayList<Book> books){
        System.out.println("Book list");
        System.out.println("Title   Author");
        System.out.println("=====   ======");
        for (Book book : books) {
            System.out.println(book.getTitle()+"    "+book.getAuthor());
        }
    }
    
}
