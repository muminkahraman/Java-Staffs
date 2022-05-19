public class UnidirectionalAssociationExample
{
    public static void main(String args[])
    {
        Person tim = new Person("Tim");
        Pet fluffy = new Pet("Fluffy");
        
        System.out.print("\n");
        printPersonWithPetDetails(tim);
        printPetDetails(fluffy);
        
        tim.setPet(fluffy);
        
        System.out.print("\n");
        printPersonWithPetDetails(tim);
        printPetDetails(fluffy);
    }
    
    private static void printPersonWithPetDetails(Person psn)
    {
        System.out.print(psn.getName());
        if (psn.getPet() == null)
        {
            System.out.println(" does not have a pet");
        }
        else
        {
            System.out.println("'s pet is called " + psn.getPet().getName());
        }
    }
    
    private static void printPetDetails(Pet pt)
    {
        System.out.println(pt.getName());
    }
}
