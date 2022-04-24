package Week1.Task3;

public class Pet {

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

/*    @Override
    public String toString();*/
}
