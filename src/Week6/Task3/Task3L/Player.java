package Week6.Task3.Task3L;

public class Player
{
    private String name;
    private transient Team team;

    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
}
