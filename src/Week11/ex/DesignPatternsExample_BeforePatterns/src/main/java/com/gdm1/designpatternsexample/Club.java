package com.gdm1.designpatternsexample;

/**
 *
 * @author gdm1
 */
public class Club
{
    private int id;
    private String name;

    public Club(int id, String name)
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
}
