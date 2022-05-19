public class Postgraduate extends Student
{
    private String firstDegree;

    public Postgraduate()
    {
        this("???", 0, "---"); //a call to the other constructor method for this object
    }

    public Postgraduate(String name, 
                        double tuitionFee, 
                        String firstDegree)
    {
        super(name, tuitionFee);
        this.firstDegree = firstDegree;
    }

    public String getFirstDegree()
    {
        return firstDegree;
    }

    public void setFirstDegree(String firstDegree)
    {
        this.firstDegree = firstDegree;
    }
}