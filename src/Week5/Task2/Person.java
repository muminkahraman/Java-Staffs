package Week5.Task2;

public class Person implements Person_comparator {
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;

    public String getFullName(){
        return (firstName + " " + lastName);
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }

    @Override
    public int compareTo(Person p)
    {
        if (this.firstName.equals(p.firstName))
        {
            return this.lastName.compareTo(p.lastName);
        }
        else
        {
            return this.firstName.compareTo(p.firstName);
        }
    }
}
