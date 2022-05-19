package com.gdm1.designpatternsexample;

import com.gdm1.designpatternsexample.command.CommandFactory;
import com.gdm1.designpatternsexample.util.IntegerInRangeInputter;
import java.util.Scanner;

/**
 *
 * @author gdm1
 */
public class DesignPatternsExample
{

    private static final int EXIT = 7;

    private static Scanner kybd = new Scanner(System.in);

    public static void main(String[] args)
    {
        CommandFactory commandFactory = new CommandFactory();

        displayMenu();
        int choice = getMenuChoice();

        while (choice != EXIT)
        {
            switch (choice)
            {
                case CommandFactory.DEMO_GATEWAY_CRUD:
                    commandFactory.create(choice).execute();
                    break;
                case CommandFactory.VIEW_ALL_CLUBS:
                    commandFactory.create(choice).execute();
                    break;
                case CommandFactory.CREATE_CLUB:
                    commandFactory.create(choice).execute();
                    break;
                case CommandFactory.CHANGE_CLUB_NAME:
                    commandFactory.create(choice).execute();
                    break;
                case CommandFactory.DELETE_CLUB:
                    commandFactory.create(choice).execute();
                    break;
                default:
                    commandFactory.create(choice).execute();
            }
            displayMenu();
            choice = getMenuChoice();
        }
    }

    private static void displayMenu()
    {
        System.out.println("\n");
        System.out.println(CommandFactory.DEMO_GATEWAY_CRUD + ". Demo gateway CRUD");
        System.out.println(CommandFactory.VIEW_ALL_CLUBS + ". View all clubs");
        System.out.println(CommandFactory.VIEW_CLUB_DETAILS + ". View club details");
        System.out.println(CommandFactory.CREATE_CLUB + ". Create a club");
        System.out.println(CommandFactory.CHANGE_CLUB_NAME + ". Change club name");
        System.out.println(CommandFactory.DELETE_CLUB + ". Delete a club");
        System.out.println(EXIT + ". Exit");
    }

    private static int getMenuChoice()
    {
        final IntegerInRangeInputter inputter = new IntegerInRangeInputter(CommandFactory.DEMO_GATEWAY_CRUD, EXIT);
        return inputter.input("\nOption: > ");
    }
}
