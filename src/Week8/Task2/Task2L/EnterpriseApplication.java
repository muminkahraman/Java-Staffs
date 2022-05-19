package Week8.Task2.Task2L;

import Week8.Task1.Test1L.Person;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class EnterpriseApplication {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        // Creation of employee to have base and well see the test
        Employee P1 =new Employee("Lamine","dep2",2000);
        Employee P2 =new Employee("Lamine","dep2",1400);
        Employee P3 =new Employee("Mex","dep2",2000);
        Employee P4 =new Employee("Tex","dep2",2500);
        Employee P5 =new Employee("Rex","dep2",1700);

        employees.add(P1);
        employees.add(P2);
        employees.add(P3);
        employees.add(P4);
        employees.add(P5);

        registerEmployee(employees);

        sortInSalaryOrder(employees);

        //the sort work with a perfect order

    }

    public static void registerEmployee(ArrayList<Employee> employees)
    {
        System.out.println("Give the number of employee you want to register");
        Scanner sc = new Scanner(System.in);
        int numberOfEmployee = sc.nextInt();
        sc.nextLine();


        for (int i = 0 ;i<numberOfEmployee;i++)
        {
            System.out.println("What's is the  first name of the employee to register ");
            String firstname = sc.nextLine();

            System.out.println("What's is the t name of the departement of the employee ");
            String depname = sc.nextLine();

            System.out.println("What's is the salary of the employee to register ");
            int salary = sc.nextInt();
            sc.nextLine();

            Employee E = new Employee(firstname,depname,salary);

            employees.add(E);

        }
    }

    public static void  sortInSalaryOrder(ArrayList<Employee> employees)
    {
        Stream<Employee> StreamOfEmployee = employees.stream();

        System.out.println("the list of employee sorted by highest salary");

        StreamOfEmployee
                .sorted()
                .forEach(e -> System.out.println(e.toString()));

    }


}
