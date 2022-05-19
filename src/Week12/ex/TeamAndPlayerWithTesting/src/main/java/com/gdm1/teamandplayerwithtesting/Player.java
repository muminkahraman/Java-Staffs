package com.gdm1.teamandplayerwithtesting;

/**
 *
 * @author gdm1
 */
public class Player
{
    private String name;
    private String position;
    private Team team;

    public Player(String name, String position)
    {
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("Name is blank");
        }
        this.name = name;
        this.position = position;
        team = null;
    }

    public String getName()
    {
        return name;
    }

    public String getPosition()
    {
        return position;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }
}
