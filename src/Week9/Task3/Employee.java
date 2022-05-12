package Week9.Task3;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable {
    private String name;
    private String department;
    private int salary;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee employee2)
    {
        if (this.name.equals(employee2.getName())) {
            if (this.salary > employee2.getSalary()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return this.name.compareTo(employee2.getName());
        }
    }
}
