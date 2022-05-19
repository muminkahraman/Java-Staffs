package Week5.Task2.Task2A;

import java.util.*;

public class ArrayDeque implements Iterable<DVD>{
    TreeSet<DVD> dvds;

    public ArrayDeque(DVD[] dvds) {
        this.dvds=new TreeSet<>(new DVDComparator2());
        this.dvds.addAll(List.of(dvds));
    }

    @Override
    public Iterator<DVD> iterator() {
        return dvds.iterator();
    }

    public Iterator<DVD> desIterator(){
        return dvds.descendingIterator();
    }

}
