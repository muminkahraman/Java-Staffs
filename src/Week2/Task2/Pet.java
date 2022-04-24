package Week2.Task2;

public abstract class Pet {

    private String name;

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    private String ownerName;

    public Pet(String name, String ownerName){
        this.name = name;
        this.ownerName = ownerName;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public String toString() {
        return (String.format("%-15s%-15s",this.name, this.ownerName));
    }
}
