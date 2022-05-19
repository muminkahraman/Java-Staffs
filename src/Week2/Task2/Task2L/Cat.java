package Week2.Task2.Task2L;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Cat)) return false;
        if (!super.equals(obj)) return false;
        Cat cat = (Cat) obj;

        return getNumberOfTeeth() == cat.getNumberOfTeeth() && getLengthOfTail() == cat.getLengthOfTail();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfTeeth(), getLengthOfTail());
    }
}
