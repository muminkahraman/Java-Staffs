package Week11.Week11A.designpatternsexample.command;

import Week11.Week11A.designpatternsexample.Club;
import Week11.Week11A.designpatternsexample.database.ClubGateway;
import Week11.Week11A.designpatternsexample.util.StringInputter;


/**
 *
 * @author gdm1
 */
public class QueryClubDetails_Command implements Command
{

    private final StringInputter inputter = new StringInputter();

    @Override
    public void execute()
    {
        String clubName = inputter.input("What is the name of the club you want to see? > ");

        System.out.println("\nClub details");
        System.out.println("=========");
        Club c = ClubGateway.getInstance().findClubByName(clubName);
        System.out.printf(
                "%4d\t%s\n",
                c.getId(), c.getName());
        System.out.println("\tPlayers");
        c.getPlayers().forEach(p -> System.out.printf("\t%4d\t%s\n", p.getId(), p.getName()));
        System.out.println("=========");
    }
}
