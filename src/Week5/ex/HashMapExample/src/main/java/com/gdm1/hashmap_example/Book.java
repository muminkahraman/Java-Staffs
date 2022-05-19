package com.gdm1.hashmap_example;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author gdm1
 */
public class Book implements Cloneable, Serializable
{

    private final String title;
    private final String author;
    private final String ISBN;
    private HashMap<Integer, Copy> copies;

    public Book(String title, String author, String ISBN)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = new HashMap<>(5);
    }

    public boolean addCopy(Copy c)
    {
        copies.put(c.getId(), c);
        return true;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public Copy findCopy(int copyId)
    {
        return copies.get(copyId);
    }

    public HashMap<Integer, Copy> getCopies()
    {
        return copies;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        Book b = (Book) super.clone();  // makes a binary copy (shallow clone) of this object
        // HashMap is shallow cloned (i.e. this.copies and b.copies point at the same array)

        //now make it a deep clone
        b.copies = new HashMap<>(copies.size());
        for (Copy c : copies.values())
        {
            b.copies.put(c.getId(), (Copy)c.clone());
        }

        return b;
    }

    @Override
    public String toString()
    {
        return super.toString()
                + " - " + "title=" + title
                + ", author=" + author
                + ", ISBN=" + ISBN
                + ", numberOfCopies=" + copies.size();
//                + ", copies=" + copies.toString()
//                + " - " + copies[0]
//                + " - " + copies[1]
//                + " - " + copies[2];
    }

}
