package com.gdm1.designpatternsexample.command;

import com.gdm1.designpatternsexample.database.ClubGateway;
import com.gdm1.designpatternsexample.util.StringInputter;

/**
 *
 * @author gdm1
 */
public class InsertClub_Command implements Command
{

    private final StringInputter inputter = new StringInputter();
    
    @Override
    public void execute()
    {
        String clubName = inputter.input("What is the new club name? > ");

        System.out.println("\nCreating your new club " + clubName + "...");
        System.out.printf(
                "\nRows inserted: %d\n",
                ClubGateway.getInstance().insert(clubName));
        
        new CommandFactory()
                .create(CommandFactory.VIEW_ALL_CLUBS)
                .execute();
    }
}
