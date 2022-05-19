package Week11.Week11A.designpatternsexample.command;

import Week11.Week11A.designpatternsexample.database.ClubGateway;

/**
 *
 * @author gdm1
 */
public class DemoCRUD_Command implements Command
{

    private final CommandFactory commandFactory = new CommandFactory();

    @Override
    public void execute()
    {
        commandFactory.create(CommandFactory.VIEW_ALL_CLUBS).execute();

        System.out.println("\nInserting row...");
        System.out.printf(
                "\nRows inserted: %d\n",
                ClubGateway.getInstance().insert("Staffs United"));
        commandFactory.create(CommandFactory.VIEW_ALL_CLUBS).execute();

        System.out.println("\nUpdating row...");
        System.out.printf(
                "\nRows updated: %d\n",
                ClubGateway.getInstance().update("Staffs United", "Staffs Rovers"));
        commandFactory.create(CommandFactory.VIEW_ALL_CLUBS).execute();

        System.out.println("\nDeleting row...");
        System.out.printf(
                "\nRows deleted: %d\n",
                ClubGateway.getInstance().delete("Staffs Rovers"));
        commandFactory.create(CommandFactory.VIEW_ALL_CLUBS).execute();
    }

}
