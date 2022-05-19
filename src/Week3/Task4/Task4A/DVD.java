package Week3.Task4.Task4A;

public class DVD implements Cloneable{
    private final String title;
    private final Person leadActor;
    private final int star;

    public DVD(String title, Person leadActor, int star) {
        this.title = title;
        this.leadActor = leadActor;
        this.star = star;
    }

    public DVD(DVD dvd){
        this.title = dvd.getTitle();
        this.leadActor = dvd.getLeadActor();
        this.star = dvd.getStar();
    }

    public int getStar() {
        return star;
    }

    public Person getLeadActor() {
        return leadActor;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%10s : %10s, %1d",title,leadActor.getFullName(),star);
    }

    @Override
    protected DVD clone() throws CloneNotSupportedException {
        return new DVD(this);
    }

    protected DVD clone(int star) throws CloneNotSupportedException {
        return new DVD(getTitle(),getLeadActor(),star);
    }
}
