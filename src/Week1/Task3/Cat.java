package Week1.Task3;

public class Cat extends Pet {

    private int numberOfTeeth;

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public int getLengthOfTail() {
        return lengthOfTail;
    }

    private int lengthOfTail;

    public Cat (String name, String ownerName, int numberOfTeeth, int lengthOfTail){
        super(name, ownerName);
        this.lengthOfTail = lengthOfTail;
        this.numberOfTeeth = numberOfTeeth;
    }
}
