package Week8.Task1.Test1l;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class RaceApplication {

    public static void main(String[] args) {

        ArrayList<Person> pupils = new ArrayList<>();

        //We use registerPupils function if we want to register new pupil to the register
        registerPupils(pupils);

        // use the following section to not add a lot of pupils in the list

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

        EggandSpoonRacer(pupils);
        sackRacer(pupils);
        threeLegRacer(pupils);
        obstacleRacer(pupils);


    }

    public static void registerPupils(ArrayList<Person> pupils)
    {

        System.out.println("Give the number of pupils you want to register");
        Scanner sc = new Scanner(System.in);
        int numberOfPupils = sc.nextInt();
        sc.nextLine();


        for (int i = 0 ;i<numberOfPupils;i++)
        {
            System.out.println("What's is the name of the pupils to register ");
            String name = sc.nextLine();


            System.out.println("What's is the age of the pupils to register ");
            int age = sc.nextInt();

            Person P = new Person(name,age);

            pupils.add(P);

        }

    }

    public static void EggandSpoonRacer(ArrayList<Person> pupils)
    {
        Stream<Person> StreamofPupils = pupils.stream();

        System.out.println("The racer for the egg and spoon are :");

        StreamofPupils
                .filter(e-> e.getAge() == 5 || e.getAge() == 6 || e.getAge() == 7 )
                .forEach(e->System.out.println(e.toString()));

        System.out.println("--------------------------------------------------------------");

    }

    public static void  sackRacer(ArrayList<Person> pupils)
    {
        Stream<Person> StreamofPupils = pupils.stream();
        PersonPredicate predicate = new PersonPredicate("a");

        System.out.println("The racer for the sack race  are :");
        StreamofPupils
                .filter(e -> predicate.test(e) )
                .forEach(e ->System.out.println(e.toString()));

        System.out.println("--------------------------------------------------------------");

    }

    public static void  threeLegRacer(ArrayList<Person> pupils)
    {
        ArrayList<Person> HalfOfRegister = new ArrayList<>();

        for (int i =0;i<pupils.size()/2;i++)
        {
            HalfOfRegister.add(pupils.get(i));
        }

        Stream<Person> StreamofPupils = HalfOfRegister.stream();

        System.out.println("The racer for the 3 leg Racer are :");

        StreamofPupils.forEach(e ->System.out.println(e.toString()));

        System.out.println("--------------------------------------------------------------");


    }

    public static void  obstacleRacer(ArrayList<Person> pupils)
    {
        ArrayList<Person> SecondHalfOfRegister = new ArrayList<>();

        int sizeofSecondhalf = pupils.size()/2;

        for (int i =0;i< pupils.size();i++)
        {
            if(i>=sizeofSecondhalf) {
                SecondHalfOfRegister.add(pupils.get(i));
            }
        }

        Stream<Person> StreamofPupils = SecondHalfOfRegister.stream();

        System.out.println("The racer for the obstacle racer are :");

        StreamofPupils.forEach(e ->System.out.println(e.toString()));

        System.out.println("--------------------------------------------------------------");

    }

}
