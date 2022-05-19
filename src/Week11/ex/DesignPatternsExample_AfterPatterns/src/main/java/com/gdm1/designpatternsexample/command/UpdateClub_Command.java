package com.gdm1.designpatternsexample.command;

import com.gdm1.designpatternsexample.database.ClubGateway;
import com.gdm1.designpatternsexample.util.StringInputter;

/**
 *
 * @author gdm1
 */
public class UpdateClub_Command implements Command
{

    private final StringInputter inputter = new StringInputter();
    
    @Override
    public void execute()
    {
        String oldClubName = inputter.input("What club name do you want to change? > ");
        String newClubName = inputter.input("What is the new club name for " + oldClubName + "? > ");

        System.out.println("\nUpdating the club name...");
        System.out.printf(
                "\nRows updated: %d\n",
                ClubGateway.getInstance().update(oldClubName, newClubName));
        
        new CommandFactory()
                .create(CommandFactory.VIEW_ALL_CLUBS)
                .execute();
    }
}
