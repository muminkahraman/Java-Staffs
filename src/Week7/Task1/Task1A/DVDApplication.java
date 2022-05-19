package Week7.Task1.Task1A;

import java.util.*;
import java.util.function.Consumer;

public class DVDApplication {
    public static void main(String[] args) {
        DVD[] dvds = randomArray(10);
        ArrayList<DVD> dvdsAl=new ArrayList<>(List.of(dvds));

        Consumer<DVD> cons=(n)->{
            System.out.println(n);
        };
        Consumer<DVD> cons2=(n)->{

            System.out.println(n.compareTo(n));
        };
        dvdsAl.forEach(cons);

        //dvdsAl.forEach(cons.andThen(cons2)); //andThen


    }

    public static DVD[] randomArray(int length) {
        Random random = new Random();


        DVD[] Dvds = new DVD[length];
        for (int i = 0; i < length; i++) {
            SupplierDVD sDvd=new SupplierDVD(i, randomString(random, 10), new Person(randomString(random, 7), randomString(random, 5)), random.nextInt(5));
            Dvds[i] = sDvd.get();
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
