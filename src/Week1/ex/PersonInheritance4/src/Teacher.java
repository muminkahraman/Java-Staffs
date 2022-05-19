public class Teacher extends Person
{
    private double wage;

    public Teacher()
    {
        this("???", 0);
    }

    public Teacher(String name, 
                   double wage)
    {
        super(name);
        this.wage = wage;
    }

    public double getWage()
    {
        return wage;
    }

    public void setWage(double wage)
    {
        this.wage = wage;
    }
}