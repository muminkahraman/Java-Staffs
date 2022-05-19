package Week1.Task3.Task3L;

public class Cat extends Pet {

    private int numberOfTeeth ;
    private int lengthOfTail ;

    public Cat(String name,String ownerName,int numberOfTeeth,int lengthOfTail)
    {
        super(name,ownerName);
        this.lengthOfTail = lengthOfTail ;
        this.numberOfTeeth = numberOfTeeth;
    }

    public int getLengthOfTail() {
        return lengthOfTail;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }
}
