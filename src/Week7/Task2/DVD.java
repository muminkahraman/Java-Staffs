package Week7.Task2;

public class DVD implements Cloneable{
    private String title;
    private Person leadActor;
    private int numberOfStars;
    private int id;

    public int getId() { return id; }

    public String getTitle() {
        return title;
    }

    public Person getLeadActor() {
        return leadActor;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setLeadActor(Person leadActor) {
        this.leadActor = leadActor;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public DVD(String title, Person leadActor, int numberOfStars, int id) {
        this.title = title;
        this.leadActor = leadActor;
        this.numberOfStars = numberOfStars;
        this.id = id;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", leadActor=" + leadActor +
                ", numberOfStars=" + numberOfStars +
                ", id=" + id +
                '}';
    }

    @Override
    protected DVD clone() throws CloneNotSupportedException{
        return new DVD (this.title, this.leadActor, this.numberOfStars, this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DVD dvd = (DVD) o;

        if (numberOfStars != dvd.getNumberOfStars()) return false;
        if (title != null ? !title.equals(dvd.getTitle()) : dvd.getTitle() != null) return false;
        return leadActor != null ? leadActor.equals(dvd.getLeadActor()) : dvd.getLeadActor() == null;
    }

}
