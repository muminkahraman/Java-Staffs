package Week2.Task2.Task2L;

import java.util.Objects;

public abstract class Pet {

    private String name ;
    private String ownerName ;

    public Pet(String name , String ownerName)
    {
        this.name = name ;
        this.ownerName = ownerName ;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;

        Pet pet = (Pet) o;
        return Objects.equals(getName(), pet.getName()) && Objects.equals(getOwnerName(), pet.getOwnerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOwnerName());
    }
}
