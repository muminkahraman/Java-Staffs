package Week7.Task1.Task1A;

import java.util.Comparator;

public class DVDComparator2 implements Comparator<DVD> {

    @Override
    public int compare(DVD o1, DVD o2) {
        return o1.compareTo3(o2);
    }
}