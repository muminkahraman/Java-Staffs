package Week8.Task1.Task1A;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class SportAppPerson {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int pupils = inputNb("Type the number of pupils : ");
        System.out.println("We have " + pupils + " pupils");
        int half = pupils / 2;
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < pupils; i++) {
            String name;
            int age;
            System.out.print("Type the name of pupils " + i + ": ");
            name = scanner.next();
            System.out.println(name);
            age = inputNb("How old is " + name + " ? :");
            persons.add(new Person(name, age));
        }


        Stream<Person> stream = persons.stream();
        stream.peek(person -> {
            System.out.print(person + " will race in : ");
            if (person.getFirstName().charAt(0) == 'a') System.out.println("Sack race .");
            int age = person.getAge();
            if (age > 4 && age < 8) System.out.print("Egg and spoon .");
        }).sorted().limit(half).forEach(person -> System.out.println(person +"you are in 3-legged race"));

        System.out.println("If you're not in 3-legged race you are in Obstacle race");


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
