package Week7.Task2.Task2A;

public class Person implements Comparable<Person> {
    private final String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int compareTo(Person o) {
        int r = lastName.compareTo(o.getLastName());
        if (r == 0) {
            r = firstName.compareTo(o.getFirstName());
        }
        return r;
    }

}
