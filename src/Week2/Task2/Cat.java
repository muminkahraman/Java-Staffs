package Week2.Task2;

import java.util.Objects;

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
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.lengthOfTail);
        hash = 89 * hash + Objects.hashCode(this.numberOfTeeth);
        hash = 89 * hash + Objects.hashCode(getName());
        hash = 89 * hash + Objects.hashCode(getOwnerName());
        hash = 89 * hash + Objects.hashCode(getClass());
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {return true;}
        if (obj == null) { return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Cat other = (Cat) obj;
        if (!Objects.equals(this.getName(), other.getName())) {return false;}
        if (!Objects.equals(this.getOwnerName(), other.getOwnerName())) {return false;}
        if (!Objects.equals(this.lengthOfTail, other.getLengthOfTail())) {return false;}
        return this.numberOfTeeth == other.getNumberOfTeeth();
    }

    @Override
    public String toString() {
        return (String.format("%s%-15s%-15s%-15s\n", super.toString(), this.numberOfTeeth, this.lengthOfTail, "-----"));
    }
}