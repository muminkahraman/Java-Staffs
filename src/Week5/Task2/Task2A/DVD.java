package Week5.Task2.Task2A;


public class DVD implements Cloneable, Comparable<DVD> {
    private final int id;
    private final String title;
    private final Person leadActor;
    private final int star;

    public DVD(int id, String title, Person leadActor, int star) {
        this.id = id;
        this.title = title;
        this.leadActor = leadActor;
        this.star = star;
    }


    public DVD(DVD dvd) {
        this.title = dvd.getTitle();
        this.leadActor = dvd.getLeadActor();
        this.star = dvd.getStar();
        this.id = dvd.id;
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

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return String.format("%1d: title:%10s actor:%10s start:%1d", id, title, leadActor.getFullName(), star);
    }

    @Override
    protected DVD clone() throws CloneNotSupportedException {
        return new DVD(this);
    }

    @Override
    public int compareTo(DVD o) {
        int r = star - o.getStar();
        if (r == 0) {
            r = title.compareTo(o.getTitle());
            if (r == 0) {
                r = leadActor.compareTo(o.getLeadActor());
            }
        }
        return r;
    }

    public int compareTo2(DVD o) {
        int r = leadActor.compareTo(o.getLeadActor());
        if (r == 0) {
            r = title.compareTo(o.getTitle());
            if (r == 0) {
                r = star - o.getStar();
            }
        }
        return r;
    }

    public int compareTo3(DVD o) {
        int r = title.compareTo(o.getTitle());
        if (r == 0) {
            r = leadActor.compareTo(o.getLeadActor());
            if (r == 0) {
                r = star - o.getStar();
            }
        }
        return r;
    }
}
