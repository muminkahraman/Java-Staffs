public class MultiplicityExample
{
    public static void main(String args[])
    {
        Person tim = new Person("Timmy");
        Person sam = new Person("Sammy");
        
        Pet fluffy = new Pet("Fluffy");
        Pet fang = new Pet("Fang");
        Pet drooler = new Pet("Drooler");
        Pet bounder = new Pet("Bounder");
        Pet snarler = new Pet("Snarler");
        
        sam.addPet(fluffy);
        tim.addPet(fang);
        tim.addPet(drooler);
        tim.addPet(bounder);
        
        System.out.println("\nAll Person details");
        System.out.println("==================");
        printPersonWithPetDetails(sam);
        printPersonWithPetDetails(tim);
        
        System.out.println("\nAll pets");
        System.out.println("========");
        printPetDetails(fluffy);
        printPetDetails(fang);
        printPetDetails(drooler);
        printPetDetails(bounder);
        printPetDetails(snarler);
    }
    
    private static void printPersonWithPetDetails(Person p)
    {
        System.out.print(p.getName());
        if (p.getNumberOfPets() == 0)
        {
            System.out.println(" does not have a pet");
        }
        else
        {
            System.out.println("'s pets:");
            for (Pet pet : p.getPets())
            {
                System.out.println("\t" + pet.getName());
            }
        }
    }
    
    private static void printPetDetails(Pet p)
    {
        System.out.println(p.getName());
    }
}
