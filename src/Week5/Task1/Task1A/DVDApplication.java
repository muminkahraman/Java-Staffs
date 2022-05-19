package Week5.Task1.Task1A;

import java.util.*;

public class DVDApplication {
    public static void main(String[] args) {
        DVD[] Dvds = randomArray(10);

        System.out.println(Arrays.toString(Dvds));

        List<DVD> array = new ArrayList<>();
        for (DVD dvd : Dvds) {
            array.add(dvd);
        }
        //System.out.println(array);
        Collections.sort(array);
        System.out.println(array);
        DVDComparator comparator = new DVDComparator();
        Collections.sort(array, comparator);
        System.out.println(array);

        HashMap<Integer, DVD> DvdsHMap = new HashMap<>();
        for (DVD dvd : Dvds) {
            DvdsHMap.put(dvd.getId(), dvd);
        }
        System.out.println(DvdsHMap);

        TreeMap<Integer, DVD> DvdsTMap = new TreeMap<>();
        for (DVD dvd : Dvds) {
            DvdsTMap.put(dvd.getId(), dvd);
        }
        System.out.println(DvdsTMap);

        TreeSet<DVD> DvdsT = new TreeSet<>();
        DvdsT.addAll(array);
        System.out.println(DvdsT);

        TreeSet<DVD> DvdsTNotNatural = new TreeSet<>(new DVDComparator2());
        DvdsTNotNatural.addAll(array);
        System.out.println(DvdsTNotNatural);

    }

    public static DVD[] randomArray(int length) {
        Random random = new Random();

        DVD[] Dvds = new DVD[length];
        for (int i = 0; i < length; i++) {
            Dvds[i] = new DVD(i, randomString(random, 10), new Person(randomString(random, 7), randomString(random, 5)), random.nextInt(5));
        }

        return Dvds;
    }

    public static String randomString(Random random, int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
