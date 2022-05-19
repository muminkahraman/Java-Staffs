package com.gdm1.lecture4demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author gdm1
 */
public class ArrayListIterationExample
{

    private static final int VIEW_LIST_OF_BOOKS = 1;
    private static final int CREATE_A_NEW_BOOK = 2;
    private static final int BORROW_A_COPY_OF_A_BOOK = 3;
    private static final int RETURN_A_COPY_OF_A_BOOK = 4;
    private static final int EXIT = 5;

    private static final Scanner kybd = new Scanner(System.in);

    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args)
    {
        loadBooksFromFile();
        
        displayMenu();
        int choice = getMenuChoice();

        while (choice != EXIT)
        {
            switch (choice)
            {
                case VIEW_LIST_OF_BOOKS:
                    viewListOfBooks();
                    break;
                case CREATE_A_NEW_BOOK:
                    createBook();
                    break;
                case BORROW_A_COPY_OF_A_BOOK:
                    borrowCopyOfBook();
                    break;
                case RETURN_A_COPY_OF_A_BOOK:
                    returnCopyOfBook();
                    break;
                default:
                    System.out.println("\nERROR: Choice not recognised");
            }
            displayMenu();
            choice = getMenuChoice();
        }

        saveBooksToFile();
    }

    private static void displayMenu()
    {
        System.out.println("\n");
        System.out.println(VIEW_LIST_OF_BOOKS + ". View list of books");
        System.out.println(CREATE_A_NEW_BOOK + ". Create a new book");
        System.out.println(BORROW_A_COPY_OF_A_BOOK + ". Borrow a copy of a book");
        System.out.println(RETURN_A_COPY_OF_A_BOOK + ". Return a copy of a book");
        System.out.println(EXIT + ". Exit");
    }

    private static int getMenuChoice()
    {
        return inputIntegerInRange(VIEW_LIST_OF_BOOKS, EXIT, "\nOption: > ");
    }

    private static int inputIntegerInRange(int min, int max, String prompt)
    {
        int num = inputInteger(prompt);

        while (num > max || num < min)
        {
            System.out.println("\nERROR: Please enter an integer in the range " + min + "-" + max);
            num = inputInteger(prompt);
        }

        return num;
    }

    private static int inputInteger(String prompt)
    {
        boolean dataOK = false;
        int num = -1;

        do
        {
            System.out.println(prompt);
            try
            {
                num = kybd.nextInt();
                kybd.nextLine(); //flush the buffer
                dataOK = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nERROR: Please enter an integer.");
            }
        }
        while (!dataOK);

        return num;
    }

    private static String inputString(String prompt)
    {
        System.out.println(prompt);
        return kybd.nextLine();
    }

    private static void viewListOfBooks()
    {
        System.out.println("\nBook list");
        System.out.println("=========");

        if (books.isEmpty())
        {
            System.out.println("No books");
        }
        else
        {
            Iterator<Book> iterator = books.iterator();
            
            while (iterator.hasNext())
            {
                displayBook(iterator.next());
            }
        }
    }

    private static void displayBook(Book b)
    {
        System.out.printf("\n'%s'\nby %s\nISBN: %s\n", b.getTitle(), b.getAuthor(), b.getISBN());
        System.out.println("Copies");
        for (Copy c : b.getCopies())
        {
            if (c == null)
            {
                System.out.println("\t---");
            }
            else
            {
                System.out.printf("\t%d: %s\n", c.getId(), c.getState());
            }
        }
    }

    private static void createBook()
    {
        String title = inputString("\nTitle: > ");
        String author = inputString("Author: > ");
        String isbn = inputString("ISBN: > ");
        int numCopies = inputIntegerInRange(0, 5, "Number of copies (1-5): ");

        Book b = new Book(title, author, isbn);
        for (int i = 0; i < numCopies; i++)
        {
            b.addCopy(new Copy());
        }
        books.add(b);
    }

    private static void borrowCopyOfBook()
    {
        String isbn = inputString("ISBN of book: > ");
        int numCopy = inputIntegerInRange(0, Integer.MAX_VALUE, "Copy number you are borrowing: ");

        Copy copy = findCopy(isbn, numCopy);

        if (copy == null)
        {
            System.out.println("ERROR: Copy not found");
        }
        else
        {
            try
            {
                copy.borrowCopy();
                System.out.println("\nBook borrowed");
            }
            catch (RuntimeException e)
            {
                System.out.println("\n" + e.getMessage());
            }
        }
    }

    private static Copy findCopy(String isbn, int copyId)
    {
        Book book = findBook(isbn);

        if (book == null)
        {
            System.out.println("ERROR: Book not found");
            return null;
        }

        return book.findCopy(copyId);
    }

    private static Book findBook(String ISBN)
    {
        Book book = null;
        Iterator<Book> iterator = books.iterator();
        
        while (book == null && iterator.hasNext())
        {
            Book b = iterator.next();
            if (b.getISBN().equals(ISBN))
            {
                book = b;
            }
        }
        return book;
    }

    private static void returnCopyOfBook()
    {
        String isbn = inputString("ISBN of book: > ");
        int numCopy = inputIntegerInRange(0, Integer.MAX_VALUE, "Copy number you are returning: ");

        Copy copy = findCopy(isbn, numCopy);

        if (copy == null)
        {
            System.out.println("ERROR: Copy not found");
        }
        else
        {
            try
            {
                copy.returnCopy();
                System.out.println("\nBook returned");
            }
            catch (RuntimeException e)
            {
                System.out.println("\n" + e.getMessage());
            }
        }
    }

    private static void loadBooksFromFile()
    {
        try
        {
            ObjectInputStream input 
                    = new ObjectInputStream(
                            new FileInputStream(
                                    new File("BookList.dat")));
            books = (ArrayList<Book>)input.readObject();
            input.close();
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static void saveBooksToFile()
    {
        try
        {
            ObjectOutputStream output 
                    = new ObjectOutputStream(
                            new FileOutputStream(
                                    new File("BookList.dat")));
                output.writeObject(books);
                output.close();
        }
        catch (IOException e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }
}
