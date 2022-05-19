public class Club
{
    private String name;
    private Manager manager;

    public Club(String name)
    {
        this.name = name;
        manager = null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Manager getManager()
    {
        return manager;
    }

    public void setManager(Manager m)
    {
        manager = m;
    }

}