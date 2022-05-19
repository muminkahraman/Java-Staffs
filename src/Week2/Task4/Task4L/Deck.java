package Week2.Task4.Task4L;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deck {

    private List<Card> Deck = new ArrayList<>();

    public void addCard(Card C) {
        Deck.add(C);
    }

    public Iterator deckIerator() {
        class DeckIterator implements Iterator {
            private Card[] cards;
            private int nextElement = 0;

            public DeckIterator(List<Card> Deck) {
                cards = Deck.toArray(new Card[0]);
            }

            @Override
            public boolean hasNext() {
                return nextElement < cards.length;
            }

            @Override
            public Card next() {
                return cards[nextElement++];
            }
        }
        return new DeckIterator(Deck);
    }

}















