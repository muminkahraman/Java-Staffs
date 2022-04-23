package Week1.Task1;

import java.util.Scanner;

public class BookShopApplication {

    public static void main(String[] args) {
        Scanner kybd = new Scanner(System.in);
        Book[] books = new Book[10];

        for (int i = 0; i < books.length; i++) {
            books[i] = getBook(kybd);
        }
        printBookDetails(books);
    }

    private static Book getBook (Scanner kybd){
        System.out.println("What is the title of the next book? > ");
        String title = kybd.nextLine();

        System.out.println("What is the name of the author? > ");
        String author = kybd.nextLine();

        if (author == ""){
            return new Book(title);
        } else {
            return new Book(author, title);
        }
    }

    private static void printBookDetails (Book[] books) {
        System.out.printf("Book list \n");
        System.out.printf("%-15s","Title");
        System.out.printf("%-15s \n","Author");
        System.out.printf("%-15s","=====");
        System.out.printf("%-15s \n","======");

        for (Book book : books) {
            System.out.printf("%-15s", book.getTitle());
            System.out.printf("%-15s \n", book.getAuthor());
        }
    }


}
