package Week2.Task2;

import java.util.Objects;

public class Budgie extends Pet {

    public String getColourOfFeathers() {
        return ColourOfFeathers;
    }

    private String ColourOfFeathers;

    public Budgie(String name, String ownerName, String colourOfFeathers){
        super(name, ownerName);
        this.ColourOfFeathers = colourOfFeathers;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.ColourOfFeathers);
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
        final Budgie other = (Budgie) obj;
        if (!Objects.equals(this.getName(), other.getName())) {return false;}
        if (!Objects.equals(this.getOwnerName(), other.getOwnerName())) {return false;}
        return this.ColourOfFeathers == other.getColourOfFeathers();
    }

    @Override
    public String toString() {
        return (String.format("%s%-15s%-15s%-15s\n", super.toString(), "-----", "-----", this.ColourOfFeathers));
    }
}
