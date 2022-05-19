public class Person
{
    private String name;
    private String address;
    private Pet pet;

    public Person(String name, String address)
    {
        this.name = name;
        this.address = address;
        pet = null;
    }

    public String getAddress()
    {
        return address;
    }

    public String getName()
    {
        return name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Pet getPet()
    {
        return pet;
    }

    public void setPet(Pet pet)
    {
        this.pet = pet;
    }
}