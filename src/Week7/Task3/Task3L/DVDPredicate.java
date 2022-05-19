package Week7.Task3.Task3L;

import java.util.function.Predicate;

public class DVDPredicate implements Predicate<DVD> {

    private final String C1 ;
    private final String C2;

    public DVDPredicate(String C1,String C2)
    {
        this.C1 = C1;
        this.C2 = C2 ;
    }

    @Override
    public boolean test(DVD testDVD) {
         String title = testDVD.getTitle();
        return (title.compareTo(C1)>=0 && title.compareTo(C2)<0);

    }
}


