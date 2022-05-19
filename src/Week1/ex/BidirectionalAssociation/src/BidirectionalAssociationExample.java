public class BidirectionalAssociationExample
{
    public static void main(String args[])
    {
        Manager manager = new Manager("Jo");
        Club club = new Club("Beaconside Breakers");
        
        System.out.print("\n");
        printManagerWithClubDetails(manager);
        printClubWithManagerDetails(club);
        
        manager.setClub(club);
        club.setManager(manager);
        
        System.out.print("\n");
        printManagerWithClubDetails(manager);
        printClubWithManagerDetails(club);
    }
    
    private static void printManagerWithClubDetails(Manager p)
    {
        System.out.print(p.getName());
        if (p.getClub() == null)
        {
            System.out.println(" does not have a club");
        }
        else
        {
            System.out.println("'s club is called " + p.getClub().getName());
        }
    }
    
    private static void printClubWithManagerDetails(Club p)
    {
        System.out.print(p.getName());
        if (p.getManager() == null)
        {
            System.out.println(" does not have a manager");
        }
        else
        {
            System.out.println("'s manager is called " + p.getManager().getName());
        }
    }
}
