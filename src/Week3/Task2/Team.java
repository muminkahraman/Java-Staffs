package Week3.Task2;

import java.util.ArrayList;

public class Team
{
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
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", requiredNumberOfPlayers=" + requiredNumberOfPlayers +
                ", players=" + players +
                '}';
    }
}
