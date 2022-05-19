package Week3.Task4.Task4L;

public class DVD implements Cloneable{

    private final String title ;
    private final Person leadActor;
    private  final int numberOfStars;


    public  DVD(String title, Person leadActor, int numberOfStars)
    {
        this.leadActor=leadActor;
        this.numberOfStars=numberOfStars;
        this.title=title ;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }


    public Person getLeadActor() {
        return leadActor;
    }


    @Override
    public String toString() {
        return "DVD Specification:" +
                "title= " + title + ' ' +
                "leadActor = " + leadActor.getFullName() +
                " numberOfStars = " + numberOfStars;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        DVD D1 = new DVD(title,leadActor,numberOfStars);

        return D1 ;
    }
}
