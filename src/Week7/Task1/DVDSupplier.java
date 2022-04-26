package Week7.Task1;

import java.util.function.Supplier;

public class DVDSupplier implements Supplier<DVD> {

    private static int getRandomIntegerInRange(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    @Override
    public DVD get() {
        int i = getRandomIntegerInRange(0, 2000000);
        return new DVD(String.format("DVD %d",i), new Person(String.format("FirstName %d",i), String.format("LastName %d",i)), getRandomIntegerInRange(0, 5), i);
    }
}
