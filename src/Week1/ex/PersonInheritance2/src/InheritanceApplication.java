public class InheritanceApplication
{
    public static void main(String args[])
    {
        Person p1 = new Person("Graham");
        Teacher t1 = new Teacher("Janet", 123456.78);
        Student s1 = new Student("Jimmy", 7612.99);
        Postgraduate pg1 = new Postgraduate("Jody", 8595.99, "Bee keeping");
        
        
        System.out.println("Person");
        System.out.println("\tName: " + p1.getName());
        
        System.out.println("\nTeacher");
        System.out.println("\tName: " + t1.getName());
        System.out.printf("\tWage: %.2f\n", t1.getWage());
        
        System.out.println("\nStudent");
        System.out.println("\tname: " + s1.getName());
        System.out.printf("\tFees: %.2f\n", s1.getFees());
        
        System.out.println("\nPostgraduate student");
        System.out.println("\tname: " + pg1.getName());
        System.out.printf("\tFees: %.2f\n", pg1.getFees());
        System.out.println("\t1st degree: " + pg1.getFirstDegree());
    }
}