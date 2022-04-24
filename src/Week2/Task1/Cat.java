package Week2.Task1;

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

    @Override
    public String toString() {
        return (String.format("%s%-15s%-15s%-15s\n", super.toString(), this.numberOfTeeth, this.lengthOfTail, "-----"));
    }
}