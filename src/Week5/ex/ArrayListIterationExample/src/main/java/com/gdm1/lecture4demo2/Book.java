package com.gdm1.lecture4demo2;

import java.io.Serializable;

/**
 *
 * @author gdm1
 */
public class Book implements Cloneable, Serializable
{

    private final String title;
    private final String author;
    private final String ISBN;
    private Copy[] copies;
    private int numberOfCopies;

    public Book(String title, String author, String ISBN)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = new Copy[5];
        this.numberOfCopies = 0;
    }

    public boolean addCopy(Copy c)
    {
        if (numberOfCopies < copies.length)
        {
            copies[numberOfCopies++] = c;
            return true;
        }
        return false;
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
        Copy copy = null;
        for (int i = 0; copy == null && i < numberOfCopies; i++)
        {
            if (copies[i].getId() == copyId)
            {
                copy = copies[i];
            }
        }
        return copy;
    }

    public Copy[] getCopies()
    {
        return copies;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        Book b = (Book) super.clone();  // makes a binary copy (shallow clone) of this object
                                        // Array is shallow cloned (i.e. this.copies and b.copies point at the same array)

        //now make it a deep clone
        b.copies = new Copy[copies.length];
        for (int i = 0; i < numberOfCopies; i++)
        {
            b.copies[i] = (Copy) copies[i].clone();
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
                + ", numberOfCopies=" + numberOfCopies 
                + ", copies=" + copies.toString() 
                + " - " + copies[0] 
                + " - " + copies[1] 
                + " - " + copies[2];
    }

}
