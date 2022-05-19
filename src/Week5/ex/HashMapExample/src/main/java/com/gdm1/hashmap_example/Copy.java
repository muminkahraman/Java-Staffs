package com.gdm1.hashmap_example;

import java.io.Serializable;

/**
 *
 * @author gdm1
 */
public class Copy implements Cloneable, Serializable
{

    private static int nextId = 1;

    private static final String AVAILABLE = "Available";
    private static final String ON_LOAN = "On loan";

    private final int id;
    private String state;

    public Copy()
    {
        this(nextId, AVAILABLE);
    }

    public Copy(int id, String state)
    {
        this.id = id;
        if (id >= nextId)
        {
            nextId = id + 1;
        }
        this.state = state;
    }

    public int getId()
    {
        return id;
    }

    public String getState()
    {
        return state;
    }

    public void borrowCopy()
    {
        if (this.state.equals(ON_LOAN))
        {
            throw new RuntimeException("Copy cannot be borrowed because it is already on loan");
        }
        this.state = ON_LOAN;
    }

    public void returnCopy()
    {
        if (this.state.equals(AVAILABLE))
        {
            throw new RuntimeException("Copy cannot be returned because it is not on loan");
        }
        this.state = AVAILABLE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();  // makes a binary copy (shallow clone) of this object
        // deep clone not needed because all variables will be cloned
    }

    @Override
    public String toString()
    {
        return super.toString() + " (" + "id=" + id + ", state=" + state + ')';
    }

}
