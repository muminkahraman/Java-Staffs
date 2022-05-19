public class Faculty
{
    private String name;
    private University university;
    
    public Faculty(String name, University university)
    {
        this.name = name;
        if (university == null)
        {
            throw new NullPointerException("University cannot be null");
        }
        this.university = university;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public University getUniversity()
    {
        return university;
    }
}
