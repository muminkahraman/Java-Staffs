package Week1.Task2.Task2A;

public class Budgie extends Pet{
    private String colourOfFeathers;

    public Budgie(String name, String overName, String colourOfFeathers) {
        super(name, overName);
        this.colourOfFeathers = colourOfFeathers;
    }

    public String getColourOfFeathers() {
        return colourOfFeathers;
    }

    @Override
    public String toString() {
        return super.toString()+ "           ---           ---              "+ colourOfFeathers;
    }
}
