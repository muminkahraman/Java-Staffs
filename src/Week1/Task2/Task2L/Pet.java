package Week1.Task2.Task2L;

public class Pet {

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
}