public class Budgie extends Pet
{
    private String colourOfFeathers;

    public Budgie(String name, String colourOfFeathers)
    {
        super(name);
        this.colourOfFeathers = colourOfFeathers;
    }

    public String getColourOfFeathers()
    {
        return colourOfFeathers;
    }

    public void setColourOfFeathers(String colourOfFeathers)
    {
        this.colourOfFeathers = colourOfFeathers;
    }

    @Override
    public String toString()
    {
        return super.getName() + " (Colour: " + colourOfFeathers + ")";
    }
}
