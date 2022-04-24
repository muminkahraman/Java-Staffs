package Week5.Task1test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author gdm1
 */
public class Lecture5Demo
{

    public static void main(String[] args)
    {
        Person[] peopleArray = createArray();
        ArrayList<Person> peopleList = createArrayList(peopleArray);
        ArrayList<Person> peopleList_NaturalOrder = createArrayList_NaturalOrder(peopleArray);
        ArrayList<Person> peopleList_AgeOrder = createArrayList_AgeOrder(peopleArray);
        HashMap<String, Person> peopleHashMap = createHashMap(peopleArray);
        TreeMap<String, Person> peopleTreeMap = createTreeMap_NaturalOrderOfKey(peopleArray);
        TreeSet<Person> peopleTreeSet = createTreeSet_NaturalOrder_Comparator(peopleArray);
        TreeSet<Person> peopleTreeSet_AgeOrder = createTreeSet_AgeOrder_Comparator(peopleArray);

        String arrayTitle = "\nPerson array (%d entries)\n";
        String[] collectionTitles =
                {
                        "\nPerson ArrayList (%d entries)\n",
                        "\nPerson ArrayList - Sorted in natural order - (%d entries)\n",
                        "\nPerson ArrayList - Sorted in age order - (%d entries)\n",
                        "\nPerson HashMap (%d entries)\n",
                        "\nPerson TreeMap (%d entries)\n",
                        "\nPerson TreeSet - Natural order - (%d entries)\n",
                        "\nPerson TreeSet - Age order - (%d entries)\n"
                };

        printCollections(
                arrayTitle,
                peopleArray,
                collectionTitles,
                peopleList,
                peopleList_NaturalOrder,
                peopleList_AgeOrder,
                peopleHashMap.values(),
                peopleTreeMap.values(),
                peopleTreeSet,
                peopleTreeSet_AgeOrder);
    }

    private static Person[] createArray()
    {
        Person[] array = new Person[10];

        for (int i = 0; i < array.length; i++)
        {
            array[i]
                    = new Person(
                    String.format(
                            "Person %d",
                            getRandomIntegerInRange(1, 7)),
                    getRandomIntegerInRange(18, 80));
        }
        return array;
    }

    private static int getRandomIntegerInRange(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static ArrayList<Person> createArrayList(Person[] people)
    {
        ArrayList<Person> list = new ArrayList<>(people.length);
        for (Person person : people)
        {
            list.add(person);
        }
        return list;
    }

    private static ArrayList<Person> createArrayList_NaturalOrder(Person[] people)
    {
        ArrayList<Person> list = new ArrayList<>(people.length);
        for (Person person : people)
        {
            list.add(person);
        }
        Collections.sort(list);
        return list;
    }

    private static ArrayList<Person> createArrayList_AgeOrder(Person[] people)
    {
        ArrayList<Person> list = new ArrayList<>(people.length);
        for (Person person : people)
        {
            list.add(person);
        }
        Collections.sort(list, new PersonComparator());
        return list;
    }

    private static HashMap<String, Person> createHashMap(Person[] people)
    {
        HashMap<String, Person> map = new HashMap<>(people.length);
        for (Person person : people)
        {
            map.put(person.getName(), person);
        }
        return map;
    }

    private static TreeMap<String, Person> createTreeMap_NaturalOrderOfKey(Person[] people)
    {
        TreeMap<String, Person> tree = new TreeMap<>();
        for (Person person : people)
        {
            tree.put(person.getName(), person);
        }
        return tree;
    }

    private static TreeSet<Person> createTreeSet_NaturalOrder_Comparator(Person[] people)
    {
        TreeSet<Person> tree = new TreeSet<>();
        for (Person person : people)
        {
            tree.add(person);
        }
        return tree;
    }

    private static TreeSet<Person> createTreeSet_AgeOrder_Comparator(Person[] people)
    {
        TreeSet<Person> tree = new TreeSet<>(new PersonComparator());
        for (Person person : people)
        {
            tree.add(person);
        }
        return tree;
    }

    private static void printCollections(String arrayTitle, Person[] people, String[] titles, Collection<Person>... personCollection)
    {
        if (titles.length != personCollection.length)
        {
            throw new RuntimeException("ERROR: the nymber of titles is not the same as the number of collections");
        }

        System.out.printf(arrayTitle, people.length);
        printArray(people);

        for (int i = 0; i < personCollection.length; i++)
        {
            System.out.printf(titles[i], personCollection[i].size());
            printCollection(personCollection[i]);
        }
    }

    private static void printArray(Person[] people)
    {
        for (Person person : people)
        {
            System.out.println("\t" + person);
        }
    }

    private static void printCollection(Collection<Person> people)
    {
        for (Person person : people)
        {
            System.out.println("\t" + person);
        }
    }

    private static class PersonComparator implements Comparator<Person>
    {

        @Override
        public int compare(Person p1, Person p2)
        {
            if (p1.getAge() == p2.getAge())
            {
                return p1.getName().compareTo(p2.getName());
            }
            else
            {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        }
    };

}