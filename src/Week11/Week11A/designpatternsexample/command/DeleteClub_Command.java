package Week11.Week11A.designpatternsexample.command;

import Week11.Week11A.designpatternsexample.database.ClubGateway;
import Week11.Week11A.designpatternsexample.util.StringInputter;


/**
 *
 * @author gdm1
 */
public class DeleteClub_Command implements Command
{

    private final StringInputter inputter = new StringInputter();
    
    @Override
    public void execute()
    {
        String clubName = inputter.input("What is the name of the club you want to delete? > ");

        System.out.println("\nDeleting the club...");
        System.out.printf(
                "\nRows deleted: %d\n",
                ClubGateway.getInstance().delete(clubName));
        
        new CommandFactory()
                .create(CommandFactory.VIEW_ALL_CLUBS)
                .execute();
    }
}
