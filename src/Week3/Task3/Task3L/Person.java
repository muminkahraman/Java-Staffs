package Week3.Task3.Task3L;


public class Person {

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
}
