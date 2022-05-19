package com.gdm1.designpatternsexample.builder;

import com.gdm1.designpatternsexample.Club;
import com.gdm1.designpatternsexample.Player;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author gdm1
 */
public class ClubBuilder
{

    private int clubId;
    private String clubName;
    private final Collection<Player> players = new ArrayList<>();

    public ClubBuilder withClubId(int id)
    {
        this.clubId = id;
        return this;
    }

    public ClubBuilder withClubName(String name)
    {
        this.clubName = name;
        return this;
    }

    public ClubBuilder withPlayer(Player p)
    {
        if (!players.contains(p))
        {
            players.add(p);
        }
        return this;
    }
    
    public Club build()
    {
        Club c = new Club(clubId, clubName, players);
        players.forEach(p -> p.setClub(c));
        return c;
    }
}
