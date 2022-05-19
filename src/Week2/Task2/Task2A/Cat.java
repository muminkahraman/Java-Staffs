package Week2.Task2.Task2A;

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

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (!(obj instanceof Cat)) return false;
        Cat cat = (Cat) obj;
        return this.getName()==cat.getName()&&this.getOverName()==cat.getOverName()&&this.getNumberOfTeeth()==cat.getNumberOfTeeth()&&this.getLenghtOfTail()==cat.getLenghtOfTail();
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

