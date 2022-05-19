public class FirstInheritanceApplication
{
    public static void main(String args[])
    {
        Person p1 = new Person();
        Teacher t1 = new Teacher();
        Student s1 = new Student();
        Postgraduate pg1 = new Postgraduate();
        
        p1.setName("Graham");
        
        t1.setName("Janet");
        t1.setWage(123456.78);
        
        s1.setName("Jimmy");
        s1.setFees(7612.99);
        
        pg1.setName("Jody");
        pg1.setFees(8595.99);
        pg1.setFirstDegree("Bee keeping");
        
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