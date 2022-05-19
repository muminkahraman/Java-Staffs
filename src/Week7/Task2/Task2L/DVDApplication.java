package Week7.Task2.Task2L;

import java.util.*;
import java.util.function.Consumer;

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

        DVDList.forEach(dvdConsumer);
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
        for (Week7.Task2.Task2L.DVD DVD : DVDS) {
            list.add(DVD);
        }
        return list;
    }

    private static ArrayList<DVD> createArrayList_NaturalOrder(DVD[] DVDS) {
        ArrayList<DVD> list = new ArrayList<>(DVDS.length);
        for (Week7.Task2.Task2L.DVD DVD : DVDS) {
            list.add(DVD);
        }
        Collections.sort(list);
        return list;
    }

    private static ArrayList<DVD> createArrayList_LeadActorOrder(DVD[] DVDS) {
        ArrayList<DVD> list = new ArrayList<>(DVDS.length);
        for (Week7.Task2.Task2L.DVD DVD : DVDS) {
            list.add(DVD);
        }
        Collections.sort(list, new DVDComparatorByLActor());
        return list;
    }



    private static HashMap<Integer, DVD> createHashMap(DVD[] DVDS) {
        HashMap<Integer, DVD> map = new HashMap<>(DVDS.length);
        for (Week7.Task2.Task2L.DVD DVD : DVDS) {
            map.put((Integer) DVD.getId(), DVD);
        }
        return map;
    }

    private static TreeMap<Integer, DVD> createTreeMap_NaturalOrderOfKey(DVD[] DVDS) {
        TreeMap<Integer, DVD> tree = new TreeMap<>();
        for (Week7.Task2.Task2L.DVD DVD : DVDS) {
            tree.put((Integer) DVD.getId(), DVD);
        }
        return tree;
    }

    private static TreeSet<DVD> createTreeSet_NaturalOrder_Comparator(DVD[] DVDS) {
        TreeSet<DVD> tree = new TreeSet<>();
        for (Week7.Task2.Task2L.DVD DVD : DVDS) {
            tree.add(DVD);
        }
        return tree;
    }

    private static TreeSet<DVD> createTreeSet_TitleOrder_Comparator(DVD[] DVDS) {
        TreeSet<DVD> tree = new TreeSet<>(new DVDComparatorByTitle());
        for (Week7.Task2.Task2L.DVD DVD : DVDS) {
            tree.add(DVD);
        }
        return tree;

    }



    private static class DVDComparatorByLActor implements Comparator<DVD> {

        @Override
        public int compare(DVD dvd1, DVD dvd2) {
            if ((dvd1.getLeadActor().equals(dvd2.getLeadActor())))
            {
                if (dvd1.getTitle().equals((dvd2.getTitle())))
                {
                    return Integer.compare(dvd1.getNumberOfStars(),dvd2.getNumberOfStars());
                }
                else
                {
                    return dvd1.getTitle().compareTo(dvd2.getTitle());
                }
            }
            else
            {
                return dvd1.getLeadActor().compareTo(dvd2.getLeadActor());
            }

        }

    }

    private static class DVDComparatorByTitle implements Comparator<DVD> {

        @Override
        public int compare(DVD dvd1, DVD dvd2) {
            if ((dvd1.getTitle().equals(dvd2.getTitle())))
            {
                if (dvd1.getLeadActor().equals((dvd2.getLeadActor())))
                {
                    return Integer.compare(dvd1.getNumberOfStars(),dvd2.getNumberOfStars());
                }
                else
                {
                    return dvd1.getLeadActor().compareTo(dvd2.getLeadActor());
                }
            }
            else
            {
                return dvd1.getTitle().compareTo(dvd2.getTitle());
            }

        }

    }

    private static void printCollections(String arrayTitle, DVD[] DVDS, String[] titles, Collection<DVD>... dvdCollection)
    {
        if (titles.length != dvdCollection.length)
        {
            throw new RuntimeException("ERROR: the nymber of titles is not the same as the number of collections");
        }

        System.out.printf(arrayTitle, DVDS.length);
        printArray(DVDS);

        for (int i = 0; i < dvdCollection.length; i++)
        {
            System.out.printf(titles[i], dvdCollection[i].size());
            printCollection(dvdCollection[i]);
        }
    }

    private static void printArray(DVD[] DVDS)
    {
        for (Week7.Task2.Task2L.DVD DVD : DVDS)
        {
            System.out.println("\t" + DVD);
        }
    }

    private static void printCollection(Collection<DVD> DVDS)
    {
        for (Week7.Task2.Task2L.DVD DVD : DVDS)
        {
            System.out.println("\t" + DVD);
        }
    }



    }


