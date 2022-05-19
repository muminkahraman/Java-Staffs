package com.gdm1.teamandplayerwithtesting;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author gdm1
 */
public class Team
{

    private String name;
    private int requiredNumberOfPlayers;
    private ArrayList<Player> players;

    public Team(String name, int requiredNumberOfPlayers) throws IllegalArgumentException
    {
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("Name is blank");
        }
        if (requiredNumberOfPlayers < 1)
        {
            throw new IllegalArgumentException("Required number of players is less than 1");
        }
        this.name = name;
        this.requiredNumberOfPlayers = requiredNumberOfPlayers;
        players = new ArrayList<>(requiredNumberOfPlayers);
    }

    public void addPlayer(Player p, String position)
    {
        if (players.size() < requiredNumberOfPlayers
                && p.getTeam() == null
                && (position.equals("Attack") || position.equals("Defence")))
        {
            players.add(p);
            p.setTeam(this);
            p.setPosition(position);
        }
    }

    public boolean canCompete()
    {
        return players.size() == requiredNumberOfPlayers;
    }

    public String getName()
    {
        return name;
    }

    public int getRequiredNumberOfPlayers()
    {
        return requiredNumberOfPlayers;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    public Player removePlayer(String playerName)
    {
        Optional<Player> p 
                = players
                        .stream()
                        .filter(p1 -> p1.getName().equals(playerName))
                        .findFirst();
        
        if (p.isPresent())
        {
            Player player = p.get();
            players.remove(player);
            player.setTeam(null);
            player.setPosition("");
            return player;
        }
        
        return null;
    }
}
