package Week7.Task2.Task2A;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class DVDApplication {
    public static void main(String[] args) {
        DVD[] dvds = randomArray(10);
        ArrayList<DVD> dvdsAl=new ArrayList<>(List.of(dvds));
        PredicateDVD p1=new PredicateDVD("A","D");
        PredicateDVD p2=new PredicateDVD("P","W");
        Consumer<DVD> cons=(n)->{
            System.out.println(n.getTitle());
            System.out.println(p1.test(n));
            System.out.println(p2.test(n));
        };
        dvdsAl.forEach(cons);
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
