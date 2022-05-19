package com.gdm1.designpatternsexample;

import com.gdm1.designpatternsexample.database.ClubGateway;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author gdm1
 */
public class DesignPatternsExample
{
    private static final int DEMO_GATEWAY_CRUD = 1;
    private static final int VIEW_ALL_CLUBS = 2;
    private static final int CREATE_CLUB = 3;
    private static final int CHANGE_CLUB_NAME = 4;
    private static final int DELETE_CLUB = 5;
    private static final int EXIT = 6;

    private static Scanner kybd = new Scanner(System.in);

    public static void main(String[] args)
    {
        displayMenu();
        int choice = getMenuChoice();

        while (choice != EXIT)
        {
            switch (choice)
            {
                case DEMO_GATEWAY_CRUD:
                    demoClubCRUD();
                    break;
                case VIEW_ALL_CLUBS:
                    queryClubs();
                    break;
                case CREATE_CLUB:
                    createClub();
                    break;
                case CHANGE_CLUB_NAME:
                    changeClubName();
                    break;
                case DELETE_CLUB:
                    deleteClub();
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
        System.out.println(DEMO_GATEWAY_CRUD + ". Demo gateway CRUD");
        System.out.println(VIEW_ALL_CLUBS + ". View all clubs");
        System.out.println(CREATE_CLUB + ". Create a club");
        System.out.println(CHANGE_CLUB_NAME + ". Change club name");
        System.out.println(DELETE_CLUB + ". Delete a club");
        System.out.println(EXIT + ". Exit");
    }

    private static int getMenuChoice()
    {
        return inputIntegerInRange(DEMO_GATEWAY_CRUD, EXIT, "\nOption: > ");
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

    private static void demoClubCRUD()
    {
        queryClubs();

        System.out.println("\nInserting row...");
        insertClub("Staffs United");
        queryClubs();

        System.out.println("\nUpdating row...");
        updateClub("Staffs United", "Staffs Rovers");
        queryClubs();

        System.out.println("\nDeleting row...");
        deleteClub("Staffs Rovers");
        queryClubs();
    }

    private static void changeClubName()
    {
        String oldClubName = inputString("What club name do you want to change? > ");
        String newClubName = inputString("What is the new club name for " + oldClubName + "? > ");

        System.out.println("\nUpdating the club name...");
        updateClub(oldClubName, newClubName);
        queryClubs();
    }

    private static void createClub()
    {
        String clubName = inputString("What is the new club name? > ");

        System.out.println("\nCreating your new club...");
        insertClub(clubName);
        queryClubs();
    }

    private static void deleteClub()
    {
        String clubName = inputString("What is the name of the club you want to delete? > ");

        System.out.println("\nDeleting the club...");
        deleteClub(clubName);
        queryClubs();
    }

    private static void deleteClub(String clubName)
    {
        System.out.printf(
                "\nRows deleted: %d\n",
                new ClubGateway().delete(clubName));
    }

    private static void insertClub(String clubName)
    {
        System.out.printf(
                "\nRows inserted: %d\n",
                new ClubGateway().insert(clubName));
    }

    private static void queryClubs()
    {
        System.out.println("\nAll clubs");
        System.out.println("=========");
        new ClubGateway()
                .findAll()
                .stream()
                .forEach(c -> System.out.printf("%4d\t%s\n", c.getId(), c.getName()));
        System.out.println("=========");
    }

    private static void updateClub(String oldClubName, String newClubName)
    {
        System.out.printf(
                "\nRows updated: %d\n",
                new ClubGateway().update(oldClubName, newClubName));
    }
}
