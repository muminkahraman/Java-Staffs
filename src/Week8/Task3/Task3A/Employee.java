package Week8.Task3.Task3A;

public class Employee implements Comparable<Employee> {
    private String name;
    private String department;
    private int salarie;

    public Employee(String name, String department, int salarie) {
        this.name = name;
        this.department = department;
        this.salarie = salarie;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salarie=" + salarie +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSalarie() {
        return salarie;
    }

    @Override
    public int compareTo(Employee o) {
        System.out.println("test");
        return 0;
    }

}
