package Week6.Task3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Team implements Serializable
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if (getClass() != o.getClass()) return false;
        final Team team = (Team) o;
        return requiredNumberOfPlayers == team.requiredNumberOfPlayers && Objects.equals(name, team.name) && Objects.equals(players, team.players);
    }

}
