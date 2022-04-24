package Week2.Task1;

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
    public String toString() {
        return (String.format("%s%-15s%-15s%-15s\n", super.toString(), "-----", "-----", this.ColourOfFeathers));
    }
}
