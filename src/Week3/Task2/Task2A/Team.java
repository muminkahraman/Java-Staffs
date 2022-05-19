package Week3.Task2.Task2A;


import java.util.ArrayList;

public class Team {
    private String name;
    private int requiredNumberOfPlayers;
    private ArrayList<Player> players;

    public Team(String name, int requiredNumberOfPlayers)
    {
        this.name = name;
        this.requiredNumberOfPlayers = requiredNumberOfPlayers;
        players = new ArrayList<>(requiredNumberOfPlayers);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRequiredNumberOfPlayers()
    {
        return requiredNumberOfPlayers;
    }

    public boolean addPlayer(Week3.Task2.Task2A.Player p)
    {
        boolean playerAdded = false;

        if (players.size() < requiredNumberOfPlayers &&
                !players.contains(p))
        {
            playerAdded = players.add(p);
            p.setTeam(this);

        }
        return playerAdded;
    }

    public void removePlayer(Week3.Task2.Task2A.Player p)
    {
        if (players.remove(p))
        {
            p.setTeam(null);
        }
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public boolean canCompete()
    {
        return players.size() == requiredNumberOfPlayers;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
