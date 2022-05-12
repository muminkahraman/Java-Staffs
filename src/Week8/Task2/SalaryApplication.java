package Week8.Task2;

import Week8.Task1.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class SalaryApplication {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        addEmployees(employees);

        System.out.println("\nSack Race Pupils :");
        Stream<Employee> employeeStream = employees.stream();

        employeeStream
                .sorted()
                .forEach(element -> System.out.println(element));
    }

    public static void addEmployees(ArrayList<Employee> pupils){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pupils do you want to add to the system ?");
        int numberOfPupils = scanner.nextInt();

        for (int i = 0; i < numberOfPupils; i++) {
            System.out.println("What is the name of the employee n"+ i+1+" ?");
            String name = scanner.nextLine();

            System.out.println("What is the department of the employee n" + i+1+ " ?");
            String department = scanner.nextLine();

            System.out.println("How much is the salary of the employee n" + i+1+ " ?");
            int salary = scanner.nextInt();
            pupils.add(new Employee(name, department, salary));
        }
    }

}
