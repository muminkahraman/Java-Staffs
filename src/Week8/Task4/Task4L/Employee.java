package Week8.Task4.Task4L;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private String name ;
    private String depName ;
    private int salary ;

    public Employee(String name,String depName,int salary)
    {
        this.name = name ;
        this.depName = depName ;
        this.salary = salary ;
    }

    public String getName() {
        return name;
    }

    public String getDepName() {
        return depName;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return
                " name = " + name  +
                " depName = " + depName  +
                "  salary = " + salary ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalary());
    }

    @Override
    public int compareTo(Employee E) {

        if(this.salary == E.salary)
        {
            return this.name.compareTo(E.name);
        }
        else
        {
            if(this.salary > E.salary)
            {
                return -1;
            }
            else
            {
                return  1;
            }
        }

    }
}
