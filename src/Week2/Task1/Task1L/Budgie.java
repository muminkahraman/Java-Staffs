package Week2.Task1.Task1L;

public class Budgie extends Pet {

    private  String colourOfFeathers  ;

    public Budgie(String name ,String ownerName ,String colourOfFeathers )
    {
        super(name,ownerName);
        this.colourOfFeathers = colourOfFeathers ;
    }

    public String getColourOfFeathers() {
        return colourOfFeathers;
    }
}
