package Week8.Task1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SportsDayApplication {
    public static void main(String[] args) {
        ArrayList<Person> pupils = new ArrayList<Person>();
        addPupils(pupils);
        Person P1 = new Person("Lamine",5);
        Person P2 = new Person("Moussa",5);
        Person P3 = new Person("Mum",8);
        Person P4 = new Person("Rex",7);
        Person P5 = new Person("Tex",6);
        Person P6 = new Person("Mex",8);
        Person P7 = new Person("Dex",5);
        Person P9 = new Person("amine",6);
        Person P10 = new Person("ariane",6);

        pupils.add(P1);
        pupils.add(P2);
        pupils.add(P3);
        pupils.add(P4);
        pupils.add(P5);
        pupils.add(P6);
        pupils.add(P7);
        pupils.add(P9);
        pupils.add(P10);

        sackRace(pupils);
        eggAndSpoon(pupils);
        threeLeggedRace(pupils);
        obstacleRace(pupils);
    }

    public static void addPupils(ArrayList<Person> pupils){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pupils do you want to add to the system ?");
        int numberOfPupils = scanner.nextInt();

        for (int i = 0; i < numberOfPupils; i++) {
            System.out.println("What is the name of the pupil n"+ i+1+" ?");
            String name = scanner.nextLine();

            System.out.println("How old is the pupil n" + i+1+ " ?");
            int age = scanner.nextInt();
            pupils.add(new Person(name, age));
        }
    }

    public static void sackRace(ArrayList<Person> pupils){
        System.out.println("\nSack Race Pupils :");
        Stream<Person> pupilsStream = pupils.stream();
        Predicate1 predicate1 = new Predicate1("a");

        pupilsStream
                .filter(element -> predicate1.test(element))
                .forEach(element -> System.out.println(element.toString()));
    }

    public static void eggAndSpoon(ArrayList<Person> pupils){
        System.out.println("\nEgg and Spoon Pupils :");
        Stream<Person> pupilsStream = pupils.stream();
        Predicate2 predicate2 = new Predicate2();

        pupilsStream
                .filter(element -> predicate2.test(element))
                .forEach(element -> System.out.println(element.toString()));
    }

    public static void threeLeggedRace (ArrayList<Person> pupils){
        System.out.println("\n3 legged Race Pupils :");
        int size = pupils.size();
        Stream<Person> pupilsStream = pupils.stream();

        pupilsStream
                .limit(size/2)
                .forEach(element -> System.out.println(element.toString()));
    }

    public static void obstacleRace (ArrayList<Person> pupils){
        System.out.println("\nObstacle Race Pupils :");
        int size = pupils.size();
        Stream<Person> pupilsStream = pupils.stream();

        pupilsStream
                .skip(size/2)
                .forEach(element -> System.out.println(element.toString()));
    }
    
}
