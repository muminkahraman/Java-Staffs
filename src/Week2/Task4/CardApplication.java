package Week2.Task4;

import java.util.ArrayList;
import java.util.Iterator;

public class CardApplication {

    public static void main(String[] args) {

        Deck deck = new Deck();


        Iterator iterator = deck.deckIterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
