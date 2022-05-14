package Week10.Task1.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lecture10Demo
{

    private static final int VIEW_LIST_OF_BOOKS = 1;
    private static final int CREATE_A_NEW_BOOK = 2;
    private static final int BORROW_A_COPY_OF_A_BOOK = 3;
    private static final int RETURN_A_COPY_OF_A_BOOK = 4;
    private static final int VIEW_NUMBER_OF_COPIES = 5;
    private static final int EXIT = 6;

    private static final Scanner kybd = new Scanner(System.in);

    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args)
    {
        loadBooksFromDatabase();

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
                case VIEW_NUMBER_OF_COPIES:
                    viewNumberOfCopies();
                    break;
                default:
                    System.out.println("\nERROR: Choice not recognised");
            }
            displayMenu();
            choice = getMenuChoice();
        }

        saveBooksToDatabase();
    }

    private static void displayMenu()
    {
        System.out.println("\n");
        System.out.println(VIEW_LIST_OF_BOOKS + ". View list of books");
        System.out.println(CREATE_A_NEW_BOOK + ". Create a new book");
        System.out.println(BORROW_A_COPY_OF_A_BOOK + ". Borrow a copy of a book");
        System.out.println(RETURN_A_COPY_OF_A_BOOK + ". Return a copy of a book");
        System.out.println(VIEW_NUMBER_OF_COPIES + ". View number of copies");
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
            books.forEach(b -> displayBook(b));
        }
    }

    private static void displayBook(Book b)
    {
        System.out.printf("'%s'\nby %s\nISBN: %s\n", b.getTitle(), b.getAuthor(), b.getISBN());
        System.out.println("Copies");

        System.out.println(
                Arrays.stream(b.getCopies())
                        .map(c -> c == null ? "\t---\n" : String.format("\t%d: %s\n", c.getId(), c.getState()))
                        .collect(Collectors.joining()));
    }

    private static void createBook()
    {
        String title = inputString("\nTitle: > ");
        String author = inputString("Author: > ");
        String isbn = inputString("ISBN: > ");
        int numCopies = inputIntegerInRange(0, 5, "Number of copies (1-5): ");

        try
        {
            Book b = new Book(title, author, isbn);

            IntStream.range(0, numCopies)
                    .forEach(i -> b.addCopy(new Copy()));

            books.add(b);
        }
        catch (EmptyStringException e)
        {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    private static void borrowCopyOfBook()
    {
        String isbn = inputString("ISBN of book: > ");
        int numCopy = inputIntegerInRange(0, Integer.MAX_VALUE, "Copy number you are borrowing: ");

        try
        {
            Copy copy = findCopy(isbn, numCopy);
            copy.borrowCopy();
            System.out.println("\nBook borrowed");
        }
        catch (CopyNotFoundException | CopyAlreadyOnLoanException e)
        {
            System.out.print("\nERROR: Book not borrowed because ... ");
            if (e.getCause() != null)
            {
                System.out.println(e.getCause().getMessage());
            }
            else
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Copy findCopy(String isbn, int copyId) throws CopyNotFoundException
    {
        try
        {
            Book book = findBook(isbn);
            return book.findCopy(copyId);
        }
        catch (BookNotFoundException e)
        {
            throw new CopyNotFoundException(copyId, e);
        }
    }

    private static Book findBook(String ISBN) throws BookNotFoundException
    {
        try
        {
            return books
                    .stream()
                    .filter(b -> b.getISBN().equals(ISBN))
                    .findFirst()
                    .get();
        }
        catch (NoSuchElementException e)
        {
            throw new BookNotFoundException(ISBN);
        }
    }

    private static void returnCopyOfBook()
    {
        String isbn = inputString("ISBN of book: > ");
        int numCopy = inputIntegerInRange(0, Integer.MAX_VALUE, "Copy number you are returning: ");

        try
        {
            Copy copy = findCopy(isbn, numCopy);
            copy.returnCopy();
            System.out.println("\nBook returned");
        }
        catch (CopyNotFoundException | CopyNotOnLoanException e)
        {
            System.out.print("\nERROR: Book not returned because ... ");
            if (e.getCause() != null)
            {
                System.out.println(e.getCause().getMessage());
            }
            else
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void viewNumberOfCopies()
    {
        System.out.println("\nNumber of copies");
        System.out.println("=========");

        if (books.isEmpty())
        {
            System.out.println("There are no book copies");
        }
        else
        {
            System.out.printf(
                    "There are %d copies, of which %d are on loan\n",
                    books.stream()
                            .flatMap(b -> Stream.of(b.getCopies()))
                            .filter(c -> c != null)
                            .count(),
                    books.stream()
                            .flatMap(b -> Stream.of(b.getCopies()))
                            .filter(c -> c != null && c.getState().equals(Copy.ON_LOAN))
                            .count());
        }
    }

    private static void loadBooksFromDatabase()
    {
        try
        {
            books = new LibraryGateway().loadBooks();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private static void saveBooksToDatabase()
    {
        try
        {
            new LibraryGateway().saveBooks(books);
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}