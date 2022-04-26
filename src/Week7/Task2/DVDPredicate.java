package Week7.Task2;

import java.util.function.Predicate;

public class DVDPredicate implements Predicate<DVD> {
    private char c1;
    private char c2;

    public DVDPredicate(char c1, char c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean test(DVD dvd) {
        char c = dvd.getTitle().charAt(0);
        if (c>=c1 && c<c2) return true;
        else return false;
    }
}
