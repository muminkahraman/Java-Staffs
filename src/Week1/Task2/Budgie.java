package Week1.Task2;

public class Budgie extends Pet{

    public String getColourOfFeathers() {
        return ColourOfFeathers;
    }

    private String ColourOfFeathers;

    public Budgie(String name, String ownerName, String colourOfFeathers){
        super(name, ownerName);
        this.ColourOfFeathers = colourOfFeathers;
    }
}
