package Week7.Task1.Task1L;

import java.util.Objects;

public class DVD implements Cloneable,Comparable<DVD>{

    private String title ;
    private Person leadActor;
    private  int numberOfStars;
    private int id ;


    public  DVD(int numberOfStars, String title, Person leadActor, int id)
    {
        this.leadActor=leadActor;
        this.numberOfStars=numberOfStars;
        this.title=title ;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        DVD D1 = new DVD(id,title,leadActor,numberOfStars);
        D1.setLeadActor((Person) leadActor.clone());

        return D1 ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DVD)) return false;
        DVD dvd = (DVD) o;
        return getNumberOfStars() == dvd.getNumberOfStars() && getId() == dvd.getId() && Objects.equals(getTitle(), dvd.getTitle()) && Objects.equals(getLeadActor(), dvd.getLeadActor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getLeadActor(), getNumberOfStars(), getId());
    }

    @Override
    public int compareTo(DVD dvd1) {

        if((Integer.compare(this.numberOfStars,dvd1.getNumberOfStars())==0))
        {
            if(this.title.equals(dvd1.getTitle()))
            {
                    return this.leadActor.compareTo(dvd1.getLeadActor());

            }
            else
            {
                return  this.title.compareTo(dvd1.getTitle());
            }
        }
        else
        {
           return Integer.compare(this.numberOfStars,dvd1.getNumberOfStars());
        }

    }
}
