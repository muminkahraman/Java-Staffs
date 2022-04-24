package Week2.Task4;

import java.util.Iterator;

public class Deck {
    public Card[] getDeck() {
        return deck;
    }

    private Card[] deck = new Card[52];

    public Deck(){
        int counter = 0;
        for (Suit suit: Suit.values()) {
            for (Rank rank : Rank.values()){
                deck[counter] = new Card(suit, rank);
                counter++;
            }
        }
    }

    public Iterator deckIterator()
    {
        class DeckIterator implements Iterator
        {
            private Card[] cardsArray;
            private int nextElement = 0;

            public DeckIterator(Card[] cardsList)
            {
                cardsArray = cardsList;
            }

            public boolean hasNext()
            {
                return nextElement < cardsArray.length;
            }

            public Card next()
            {
                return cardsArray[nextElement++];
            }
        }

        return new DeckIterator(deck);
    }
}
