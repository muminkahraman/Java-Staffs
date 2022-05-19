import java.util.ArrayList;

public class Person
{
    private String name;
    private ArrayList<Pet> pets;

    public Person(String name)
    {
        this.name = name;
        pets = new ArrayList<Pet>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean addPet(Pet p)
    {
        boolean petAdded = false;

        if (!pets.contains(p))
        {
            petAdded = pets.add(p);
        }

        return petAdded;
    }

    public void removePet(Pet p)
    {
        pets.remove(p);
    }

    public Pet getPet(String name)
    {
        Pet foundPet = null;

        for (int i = 0; foundPet == null && i < pets.size(); i++)
        {
            Pet p = pets.get(i);

            if (p.getName().equalsIgnoreCase(name))
            {
                foundPet = p;
            }
        }

        return foundPet;
    }

    public ArrayList<Pet> getPets()
    {
        return pets;
    }

    public int getNumberOfPets()
    {
        return pets.size();
    }
}