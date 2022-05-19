package Week7.Task3.Task3L;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class DVDApplication {

    public static void main(String[] args) {


        DVD[] DVDArray = createArray();
        ArrayList<DVD> DVDList = createArrayList(DVDArray);

        DVDPredicate predicate1 = new DVDPredicate("A","D");
        DVDPredicate predicate2 = new DVDPredicate("P","W");

        Consumer<DVD> dvdConsumer = (n) ->
        {
            System.out.println(n);
            System.out.println("this film title within : "+predicate1.test(n));
            System.out.println("this film title within : "+predicate2.test(n));
        };

        Function<ArrayList<DVD>,Integer> listIntegerFunction1 = n->
        {
            int occur = 0 ;
            for (DVD dvd : n)
            {
                if (predicate1.test(dvd) == true) {
                    occur++ ;
                }
            }
            return occur ;
        };

        Function<ArrayList<DVD>,Integer> listIntegerFunction2 = n->
        {
            int occur = 0 ;
            for (DVD dvd : n)
            {
                if (predicate2.test(dvd) == true) {
                    occur++ ;
                }
            }
            return occur ;
        };

        DVDList.forEach(dvdConsumer);
        System.out.println("the number of DVD starting between A and D is :" + listIntegerFunction1.apply(DVDList));
        System.out.println("the number of DVD starting between P and W is :" + listIntegerFunction2.apply(DVDList));

    }


    private static DVD[] createArray()
    {
        Person P1 = new Person("Eren", "Jaeger");
        Person P2 = new Person("San", "Goku");
        Person P3 = new Person("Mugiwara", "Luffy");
        Person P4 = new Person("Livai", "Ackerman");
        Person P5 =new Person("The","Rock");
        Person P6 = new Person("Tom","Hollland");
        Person P7 = new Person("Lamine","Diedhiou");
        Person P8 = new Person("Chalwick","Bossman");
        Person P9 = new Person("Sakho","Mangane");


        DVD DVD1 = new DVD(3, "Shingeki no Kyojin", P4, 35);
        DVD DVD2 = new DVD(5, "Tanrantino", P1, 42);
        DVD DVD3 = new DVD(5, "One Piece", P3, 23);
        DVD DVD4 = new DVD(3, "Fast and furious", P5, 37);
        DVD DVD5 = new DVD(2, "Drago Ball", P2, 41);
        DVD DVD6 = new DVD(1, "Spiderman", P6, 23);
        DVD DVD7 = new DVD(3, "Batman", P7, 33);
        DVD DVD8 = new DVD(2, "Black Panther", P8, 42);
        DVD DVD9 = new DVD(1, "Sakho et Mangane", P9, 22);
        DVD DVD10 = new DVD(4, "Sakho et Mangane 2", P9, 23);


        DVD[] array = {DVD1,DVD2,DVD3,DVD4,DVD5,DVD6,DVD7,DVD8,DVD9,DVD10};


        for (int i = 0; i < array.length; i++)
        {

            array[i]
                    = new DVD(array[i].getNumberOfStars(),
                    array[i].getTitle(),array[i].getLeadActor(),array[i].getId());
        }
        return array;
    }

    private static int getRandomIntegerInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }


    private static ArrayList<DVD> createArrayList(DVD[] DVDS) {
        ArrayList<DVD> list = new ArrayList<>(DVDS.length);
        for (Week7.Task3.Task3L.DVD DVD : DVDS) {
            list.add(DVD);
        }
        return list;
    }



    }



