package Week6.Task3.Task3L;

import java.util.ArrayList;

public class Team implements AutoCloseable
{
    private String name;
    private int requiredNumberOfPlayers;
    private ArrayList<Player> players;

    public Team(String name, int requiredNumberOfPlayers)
    {
        this.name = name;
        this.requiredNumberOfPlayers = requiredNumberOfPlayers;
        players = new ArrayList<>();
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

    public boolean addPlayer(Player p)
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

    public void removePlayer(Player p)
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

    @Override
    public void close() throws Exception {
        Team T = new Team(this.name , this.requiredNumberOfPlayers);
        System.out.println("We make the players list empty");

    }
}
