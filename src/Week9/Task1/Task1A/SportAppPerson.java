package Week9.Task1.Task1A;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SportAppPerson {
    private static Scanner scanner;

    enum Event {
        StackRace,
        EggAndSpoon,
        Legged,
        ObstacleRace,
    }

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

        List<Person> stackRaceList = new ArrayList<>();
        List<Person> eggAndSpoonList = new ArrayList<>();
        List<Person> leggedList = new ArrayList<>();
        List<Person> obstacleRaceList = new ArrayList<>();

        List<List<Person>> lists = new ArrayList<>();


        persons.stream()
                .sorted()
                .peek(person -> {
            if (person.getFirstName().charAt(0) == 'a') stackRaceList.add(person);
            int age = person.getAge();
            if (age > 4 && age < 8) eggAndSpoonList.add(person);
        })
                .limit(half)
                .peek(leggedList::add).peek(person -> {
            if (!leggedList.contains(person)) obstacleRaceList.add(person);
        });
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
