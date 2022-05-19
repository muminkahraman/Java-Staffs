public class Student extends Person
{
    private double fees;
    
    public Student()
    {
        this("???", 0); //a call to the other constructor method for this object
    }

    public Student(String name, 
                   double fees)
    {
        super(name);
        this.fees = fees;
    }

    public double getFees()
    {
        return fees;
    }

    public void setFees(double fees)
    {
        this.fees = fees;
    }
}