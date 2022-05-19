package com.gdm1.jsonexample;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person
{
    String name;
    String surname;
    Calendar dob;

    public Person()
    {
    }

    public Person(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Calendar getDob()
    {
        return dob;
    }

    public void setDob(Calendar dob)
    {
        this.dob = dob;
    }

    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return surname.toUpperCase() + ", " + name + " (" + sdf.format(dob.getTime()) + ")";
    }
}
