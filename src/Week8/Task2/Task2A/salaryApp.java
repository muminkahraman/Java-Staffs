package Week8.Task2.Task2A;


import Week8.Task1.Task1A.Person;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class salaryApp {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int employee = inputNb("Type the number of employees : ");
        System.out.println("We have " + employee + " employees");
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employee; i++) {
            String name;
            String dep;
            int salarie;
            System.out.print("Type the name of employees " + i + ": ");
            name = scanner.next();
            System.out.print("In which department does "+name+" work? :");
            dep=scanner.next();
            salarie = inputNb("What is "+name+"'s salary ? :");
            employees.add(new Employee(name,dep,salarie));
        }

        employees.stream().sorted((employee1,employee2)->{int i=employee1.getName().compareTo(employee2.getName());
        if(i==0){
        i=employee1.getSalarie()-employee2.getSalarie();}
        return i;}).forEach(System.out::println);




    }

    public static int inputNb(String msg) {
        try {
            System.out.print(msg);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice");
            scanner.next(); //why we need that?
        }
        return inputNb(msg);
    }

}
