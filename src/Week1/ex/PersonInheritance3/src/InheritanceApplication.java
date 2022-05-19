
public class InheritanceApplication
{
    public static void main(String args[])
    {
        Person[] people =
        {
            new Person("Graham"),
            new Teacher("Janet", 123456.78),
            new Student("Jimmy", 7612.99),
            new Postgraduate("Jody", 8595.99, "Bee keeping")
        };

        int count = 0;
        for (Person p : people)
        {
            count++;
            System.out.println("\nPerson " + count);
            System.out.println("\tName: " + p.getName());

            if (p instanceof Teacher)
            {
                System.out.println("\tRole: Teacher");
                Teacher t = (Teacher)p;
                System.out.printf("\tWage: %.2f\n", t.getWage());
            }
            else if (p instanceof Postgraduate)
            {
                System.out.println("\tRole: Postgraduate student");
                Postgraduate pg = (Postgraduate)p;
                System.out.printf("\tFees: %.2f\n", pg.getFees());
                System.out.println("\t1st degree: " + pg.getFirstDegree());
            }
            else if (p instanceof Student)
            {
                System.out.println("\tRole: Student");
                Student s = (Student)p;
                System.out.printf("\tFees: %.2f\n", s.getFees());
            }
        }
    }
}