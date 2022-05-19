package Week7.Task3.Task3L;


import java.util.Objects;

public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName ;

    public Person(String firstName,String lastName)
    {
        this.firstName = firstName ;
        this.lastName = lastName ;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName()
    {
        return this.firstName+" "+this.lastName ;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(firstName,lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public int compareTo(Person o) {
        if (this.firstName.equals(o.firstName))
        {
            return this.lastName.compareTo(o.lastName);
        }
        else
        {
            return this.firstName.compareTo(o.firstName);
        }
    }
}
