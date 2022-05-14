package Week10.Task2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lecture10Demo
{

    private static final int VIEW_LIST_OF_CUSTOMERS = 1;
    private static final int EXIT = 6;

    private static final Scanner kybd = new Scanner(System.in);

    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args)
    {
        loadCustomersFromDatabase();

        displayMenu();
        int choice = getMenuChoice();

        while (choice != EXIT)
        {
            switch (choice)
            {
                case VIEW_LIST_OF_CUSTOMERS:
                    viewListOfCustomers();
                    break;
                default:
                    System.out.println("\nERROR: Choice not recognised");
            }
            displayMenu();
            choice = getMenuChoice();
        }
    }

    private static void displayMenu()
    {
        System.out.println("\n");
        System.out.println(VIEW_LIST_OF_CUSTOMERS + ". View list of customers");
        System.out.println(EXIT + ". Exit");
    }

    private static int getMenuChoice()
    {
        return inputIntegerInRange(VIEW_LIST_OF_CUSTOMERS, EXIT, "\nOption: > ");
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

    private static void viewListOfCustomers()
    {
        System.out.println("\nCustomer list");
        System.out.println("=========");

        if (customers.isEmpty())
        {
            System.out.println("No customers");
        }
        else
        {
            customers.forEach(b -> displayCustomer(b));
        }
    }

    private static void displayCustomer(Customer b)
    {
        System.out.printf("idcustomer: %s\tname: %s\t\tlastname: %s\n", b.getIdcustomer(), b.getName(), b.getLastname());
    }

    private static void loadCustomersFromDatabase()
    {
        try
        {
            customers = new LibraryGateway().loadCustomers();
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}