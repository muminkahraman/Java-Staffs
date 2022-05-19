package Week11.Week11A.designpatternsexample;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author gdm1
 */
public class Club
{
    private int id;
    private String name;
    private final Collection<Player> players;

    public Club(int id, String name)
    {
        this(id, name, new ArrayList<>());
    }

    public Club(int id, String name, Collection<Player> players)
    {
        this.id = id;
        this.name = name;
        this.players = players;
    }
    
    public void addPlayer(Player p)
    {
        if (!players.contains(p))
        {
            players.add(p);
        }
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Collection<Player> getPlayers()
    {
        return players;
    }
}
