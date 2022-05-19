package Week8.Task3.Task3L;

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
