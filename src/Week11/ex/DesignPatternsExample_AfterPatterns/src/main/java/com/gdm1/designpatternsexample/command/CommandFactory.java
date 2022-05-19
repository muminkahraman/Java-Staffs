package com.gdm1.designpatternsexample.command;

/**
 *
 * @author gdm1
 */
public class CommandFactory
{

    public static final int DEMO_GATEWAY_CRUD = 1;
    public static final int VIEW_ALL_CLUBS = 2;
    public static final int VIEW_CLUB_DETAILS = 3;
    public static final int CREATE_CLUB = 4;
    public static final int CHANGE_CLUB_NAME = 5;
    public static final int DELETE_CLUB = 6;

    public Command create(int commandCode)
    {
        switch (commandCode)
        {
            case DEMO_GATEWAY_CRUD:
                return new DemoCRUD_Command();
            case VIEW_ALL_CLUBS:
                return new QueryClubs_Command();
            case VIEW_CLUB_DETAILS:
                return new QueryClubDetails_Command();
            case CREATE_CLUB:
                return new InsertClub_Command();
            case CHANGE_CLUB_NAME:
                return new UpdateClub_Command();
            case DELETE_CLUB:
                return new DeleteClub_Command();
            default:
                return new Null_Command();
        }
    }
}
