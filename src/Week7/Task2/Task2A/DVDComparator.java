package Week7.Task2.Task2A;

import java.util.Comparator;

public class DVDComparator implements Comparator<DVD> {

    @Override
    public int compare(DVD o1, DVD o2) {
        return o1.compareTo2(o2);
    }
}
