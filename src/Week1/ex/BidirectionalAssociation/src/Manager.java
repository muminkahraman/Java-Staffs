public class Manager
{
    private String name;
    private Club club;

    public Manager(String name)
    {
        this.name = name;
        club = null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Club getClub()
    {
        return club;
    }

    public void setClub(Club club)
    {
        this.club = club;
    }

}