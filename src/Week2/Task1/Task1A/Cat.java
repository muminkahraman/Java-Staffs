package Week2.Task1.Task1A;

public class Cat extends Pet {
    private int numberOfTeeth;
    private int lenghtOfTail;

    public Cat(String name, String overName, int numberOfTeeth, int lenghtOfTail) {
        super(name, overName);
        this.numberOfTeeth = numberOfTeeth;
        this.lenghtOfTail = lenghtOfTail;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public int getLenghtOfTail() {
        return lenghtOfTail;
    }

    @Override
    public String toString() {
        return super.toString()+ "             "+numberOfTeeth +
                "             " + lenghtOfTail + "              ---";
    }
}

