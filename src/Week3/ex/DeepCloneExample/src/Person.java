/**
 *
 * @author gdm1
 */
public class Person implements Cloneable
{

    private String name;
    private String address;
    private Pet pet;

    public Person(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public Pet getPet()
    {
        return pet;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPet(Pet pet)
    {
        this.pet = pet;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        Person p = new Person(name, address);
        p.setPet((Pet)pet.clone());
        return p;
    }
}
