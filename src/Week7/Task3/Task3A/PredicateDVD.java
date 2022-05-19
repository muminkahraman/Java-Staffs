package Week7.Task3.Task3A;

import java.util.function.Predicate;

public class PredicateDVD implements Predicate<DVD> {
    private String c1;
    private String c2;

    public PredicateDVD(String c1, String c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean test(DVD dvd) {
        String title=dvd.getTitle();
        return (title.compareTo(c1)>=0 && title.compareTo(c2)<0);

    }
}
