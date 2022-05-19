
public class PersonPetApplication
{

    public static void main(String args[])
    {
        Person[] people =
        {
            new Person("Timmy", "Home"),
            new Person("Sammy", "Theatre"),
            new Person("Tina", "The Street"),
            new Person("Joe", "University")
        };

        Pet fluffy = new Cat("Fluffy", 28);
        Pet growler = new Cat("Hisser", 15);
        Pet snarler = new Budgie("Whistler", "Blue and yellow");

        people[0].setPet(fluffy);
        people[1].setPet(growler);
        people[2].setPet(snarler);
        
        for (Person p : people)
        {
            printPersonDetails(p);
        }
    }
    
    private static void printPersonDetails(Person p)
    {
        System.out.println("\nName:    " + p.getName());
        System.out.println("Address: " + p.getAddress());
        System.out.print("Pet:     ");
        
        if (p.getPet() == null)
        {
            System.out.println("----");
        }
        else
        {
            System.out.println(p.getPet().toString());
        }
    }
}
