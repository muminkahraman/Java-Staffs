package Week9.Task1.Task1A;

public class Person implements Comparable<Person> {
    private final String firstName;
    private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age=age;

    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return firstName.compareTo(o.getFirstName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
