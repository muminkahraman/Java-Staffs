package Week7.Task3;

import java.util.Random;
import java.util.function.Supplier;

public class DVDSupplier implements Supplier<DVD> {

    private static int getRandomIntegerInRange(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    @Override
    public DVD get() {
        Random r = new Random();
        char c = (char)(r.nextInt('z' - 'a') + 'a');
        int i = getRandomIntegerInRange(0, 2000000);
        return new DVD(String.format("%cDVD %d",c, i), new Person(String.format("FirstName %d",i), String.format("LastName %d",i)), getRandomIntegerInRange(0, 5), i);
    }
}
