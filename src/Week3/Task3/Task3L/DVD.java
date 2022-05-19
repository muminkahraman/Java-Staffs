package Week3.Task3.Task3L;

public class DVD implements Cloneable{

    private String title ;
    private Person leadActor;
    private  int numberOfStars;


    public  DVD(String title,Person leadActor,int numberOfStars)
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

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public Person getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(Person leadActor) {
        this.leadActor = leadActor;
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
        D1.setLeadActor((Person) leadActor.clone());

        return D1 ;
    }
}
