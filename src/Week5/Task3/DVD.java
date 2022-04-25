package Week5.Task3;

public class DVD implements Cloneable{
    private final String title;
    private final Person leadActor;
    private final int numberOfStars;

    public String getTitle() {
        return title;
    }

    public Person getLeadActor() {
        return leadActor;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public DVD(String title, Person leadActor, int numberOfStars) {
        this.title = title;
        this.leadActor = leadActor;
        this.numberOfStars = numberOfStars;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", leadActor=" + leadActor +
                ", numberOfStars=" + numberOfStars +
                '}';
    }

    @Override
    protected DVD clone() throws CloneNotSupportedException{
        DVD dvd = new DVD (this.title, this.leadActor, this.numberOfStars);
        return dvd;
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
