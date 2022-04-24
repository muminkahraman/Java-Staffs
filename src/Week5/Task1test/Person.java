package Week5.Task1test;

import java.util.Objects;

/**
 *
 * @author gdm1
 */
public class Person implements Comparable<Person>
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return String.format("%s: %d years old", name, age);
    }

    @Override
    public int compareTo(Person p)
    {
        if (this.name.equals(p.name))
        {
            return Integer.compare(this.age, p.age);
        }
        else
        {
            return this.name.compareTo(p.name);
        }
    }
}