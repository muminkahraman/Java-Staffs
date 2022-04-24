package Week1.Task3;

public class Budgie extends Pet {

    public String getColourOfFeathers() {
        return ColourOfFeathers;
    }

    private String ColourOfFeathers;

    public Budgie(String name, String ownerName, String colourOfFeathers){
        super(name, ownerName);
        this.ColourOfFeathers = colourOfFeathers;
    }
}
