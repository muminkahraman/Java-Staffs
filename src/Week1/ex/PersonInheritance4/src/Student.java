public class Student extends Person
{
    private double fees;
    
    public Student()
    {
        this("???", 0);
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
    
    @Override
    public String toString()
    {
        return String.format("%s owes %.2f GBP", 
                             getName(), 
                             getFees());
    }
}