package Week7.Task3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class DVDapplication {
    public static void main(String[] args) {

        DVD[] DVDArray = createArray();
        ArrayList<DVD> DVDList = createArrayList(DVDArray);
        ArrayList<DVD> DVDList_NaturalOrder = createArrayList_NaturalOrder(DVDArray);
        ArrayList<DVD> DVDList_LeadActorOrder = createArrayList_LeadActorOrder(DVDArray);
        HashMap<Integer, DVD> DVDHashMap = createHashMap(DVDArray);
        TreeMap<Integer, DVD> DVDTreeMap = createTreeMap_NaturalOrderOfKey(DVDArray);
        TreeSet<DVD> DVDTreeSet = createTreeSet_NaturalOrder_Comparator(DVDArray);
        TreeSet<DVD> DVDTreeSet_TitleOrder = createTreeSet_TitleOrder_Comparator(DVDArray);

        String arrayTitle = "\nDVD array (%d entries)\n";
        String[] collectionTitles =
                {
                        "\nDVD ArrayList (%d entries)\n",
                        "\nDVD ArrayList - Sorted in natural order - (%d entries)\n",
                        "\nDVD ArrayList - Sorted in Lead Actor order - (%d entries)\n",
                        "\nDVD HashMap (%d entries)\n",
                        "\nDVD TreeMap (%d entries)\n",
                        "\nDVD TreeSet - Natural order - (%d entries)\n",
                        "\nDVD TreeSet - Title order - (%d entries)\n"

                };

        printCollections(
                arrayTitle,
                DVDArray,
                collectionTitles,
                DVDList,
                DVDList_NaturalOrder,
                DVDList_LeadActorOrder,
                DVDHashMap.values(),
                DVDTreeMap.values(),
                DVDTreeSet,
                DVDTreeSet_TitleOrder);
        DVDConsumer
                (DVDArrayListSupplier(10));
    }

    private static DVD[] createArray()
    {
        DVDSupplier sup = new DVDSupplier();
        DVD[] array = new DVD[10];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = sup.get();
        }
        return array;
    }

    private static int getRandomIntegerInRange(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static ArrayList<DVD> createArrayList(DVD[] dvds)
    {
        ArrayList<DVD> list = new ArrayList<>(dvds.length);
        for (DVD dvd : dvds)
        {
            list.add(dvd);
        }
        return list;
    }

    private static ArrayList<DVD> createArrayList_NaturalOrder(DVD[] dvds)
    {
        ArrayList<DVD> list = new ArrayList<>(dvds.length);
        for (DVD dvd : dvds)
        {
            list.add(dvd);
        }
        Collections.sort(list, new DVDComparator_natural());
        return list;
    }

    private static ArrayList<DVD> createArrayList_LeadActorOrder(DVD[] dvds)
    {
        ArrayList<DVD> list = new ArrayList<>(dvds.length);
        for (DVD dvd : dvds)
        {
            list.add(dvd);
        }
        Collections.sort(list, new DVDComparator_leadActor());
        return list;
    }

    private static class DVDComparator_leadActor implements Comparator<DVD>
    {

        @Override
        public int compare(DVD dvd1, DVD dvd2)
        {
            if (dvd1.getLeadActor().equals(dvd2.getLeadActor())) {
                if (dvd1.getTitle().equals(dvd2.getTitle())) {
                    return Integer.compare(dvd1.getNumberOfStars(), dvd2.getNumberOfStars());
                } else {
                    return dvd1.getTitle().compareTo(dvd2.getTitle());
                }
            } else {
                return dvd1.getLeadActor().compareTo(dvd2.getLeadActor());
            }
        }
    }

    private static HashMap<Integer, DVD> createHashMap(DVD[] dvds)
    {
        HashMap<Integer, DVD> map = new HashMap<>(dvds.length);
        for (DVD dvd : dvds)
        {
            map.put(dvd.getId(), dvd);
        }
        return map;
    }

    private static TreeMap<Integer, DVD> createTreeMap_NaturalOrderOfKey(DVD[] dvds)
    {
        TreeMap<Integer, DVD> tree = new TreeMap<>();
        for (DVD dvd : dvds)
        {
            tree.put(dvd.getId(), dvd);
        }
        return tree;
    }

    private static TreeSet<DVD> createTreeSet_NaturalOrder_Comparator(DVD[] dvds)
    {
        TreeSet<DVD> tree = new TreeSet<>(new DVDComparator_natural());
        for (DVD dvd : dvds)
        {
            tree.add(dvd);
        }
        return tree;
    }

    private static TreeSet<DVD> createTreeSet_TitleOrder_Comparator(DVD[] dvds)
    {
        TreeSet<DVD> tree = new TreeSet<>(new DVDComparator_title());
        for (DVD dvd : dvds)
        {
            tree.add(dvd);
        }
        return tree;
    }

    private static class DVDComparator_title implements Comparator<DVD>
    {

        @Override
        public int compare(DVD dvd1, DVD dvd2)
        {
            if (dvd1.getTitle().equals(dvd2.getTitle())) {
                if (dvd1.getLeadActor().equals(dvd2.getLeadActor())) {
                    return Integer.compare(dvd1.getNumberOfStars(), dvd2.getNumberOfStars());
                } else {
                    return dvd1.getLeadActor().compareTo(dvd2.getLeadActor());
                }
            } else {
                return dvd1.getTitle().compareTo(dvd2.getTitle());
            }
        }
    }

    private static class DVDComparator_natural implements Comparator<DVD>
    {

        @Override
        public int compare(DVD dvd1, DVD dvd2)
        {
            if (dvd1.getNumberOfStars() == dvd2.getNumberOfStars()) {
                if (dvd1.getTitle().equals(dvd2.getTitle())) {
                    return dvd1.getLeadActor().compareTo(dvd2.getLeadActor());
                } else {
                    return dvd1.getTitle().compareTo(dvd2.getTitle());
                }
            } else {
                return Integer.compare(dvd1.getNumberOfStars(), dvd2.getNumberOfStars());
            }
        }
    }

    private static void printCollections(String arrayTitle, DVD[] dvds, String[] titles, Collection<DVD>... DVDCollection)
    {
        if (titles.length != DVDCollection.length)
        {
            throw new RuntimeException("ERROR: the nymber of titles is not the same as the number of collections");
        }

        System.out.printf(arrayTitle, dvds.length);
        printArray(dvds);

        for (int i = 0; i < DVDCollection.length; i++)
        {
            System.out.printf(titles[i], DVDCollection[i].size());
            printCollection(DVDCollection[i]);
        }

        System.out.printf("\nDVD ArrayList generated by supplier printed with predicate btw A & D - (%d entries(calculated with function interface))\n", FunctionCounter(DVDCollection[DVDCollection.length-1], 'a', 'd'));
        printCollectionWithPredicate(DVDCollection[DVDCollection.length-1], 'a', 'd');

        System.out.printf("\nDVD ArrayList generated by supplier printed with predicate btw P & W - (%d entries(calculated with function interface))\n", FunctionCounter(DVDCollection[DVDCollection.length-1], 'p', 'w'));
        printCollectionWithPredicate(DVDCollection[DVDCollection.length-1], 'p', 'w');
    }

    private static void printArray(DVD[] dvds)
    {
        for (DVD dvd : dvds)
        {
            System.out.println("\t" + dvd);
        }
    }

    private static void printCollection(Collection<DVD> dvds)
    {
        for (DVD dvd : dvds)
        {
            System.out.println("\t" + dvd);
        }
    }

    private static ArrayList<DVD> DVDArrayListSupplier(int x) {
        Supplier<ArrayList<DVD>> DVDALSupplier = () ->
        {
            DVDSupplier sup = new DVDSupplier();
            ArrayList<DVD> array = new ArrayList<>();
            for (int i = 0; i < x; i++)
            {
                DVD dvd = sup.get();
                array.add(dvd);
            }
            return array;
        };
        return DVDALSupplier.get();
    }

    private static void DVDConsumer(ArrayList<DVD> t)
    {
        Consumer<ArrayList<DVD>> DVDPrinter = (x) -> {
                System.out.printf("\nDVD ArrayList generated by supplier - (%d entries)\n", x.size());
                printCollection(x);
        };
        DVDPrinter.accept(t);
    }

    private static void printCollectionWithPredicate(Collection<DVD> dvds, char a, char b)
    {
        DVDPredicate pred = new DVDPredicate(a,b);
        for (DVD dvd : dvds)
        {
            if (pred.test(dvd))
            System.out.println("\t" + dvd);
        }
    }
    private static int FunctionCounter(Collection<DVD> dvds, char a, char b)
    {
        Function<Collection<DVD>, Integer> counter = new Function<Collection<DVD>, Integer>()
        {
            @Override
            public Integer apply(Collection<DVD> dvdd)
            {
                int x = 0;
                DVDPredicate pred = new DVDPredicate(a,b);
                for (DVD dvd : dvds)
                {
                    if (pred.test(dvd))
                        x++;
                }
                return x;
            }
        };

        return counter.apply(dvds);
    }
}
