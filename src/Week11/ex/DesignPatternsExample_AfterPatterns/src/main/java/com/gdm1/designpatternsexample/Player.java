package com.gdm1.designpatternsexample;

/**
 *
 * @author gdm1
 */
public class Player
{
    private final int id;
    private final String name;
    private Club club;

    public Player(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
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
