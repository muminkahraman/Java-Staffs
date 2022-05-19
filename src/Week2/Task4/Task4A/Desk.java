package Week2.Task4.Task4A;

import java.util.*;
import java.util.function.Consumer;

public class Desk implements Iterable<Card>{
    private List<Card> cards;

    public Desk() {
        cards=new ArrayList<>(52);
        for (Card.Suit suit: Card.Suit.values()) {
            for (Card.Rank rank: Card.Rank.values()){
                cards.add(new Card(suit,rank));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Desk : \n");
        for (Card card: cards) {
            sb.append(card.toString());
        }
        return sb.toString();

    }

    public Iterator<Card> iterator(){
        return new Itr();
    }

    private class Itr implements Iterator<Card> {
        int cursor;
        int lastRet = -1;

        // prevent creating a synthetic constructor
        Itr() {}

        public boolean hasNext() {
            return cursor != cards.size();
        }

        @SuppressWarnings("unchecked")
        public Card next() {
            int i = cursor;
            if (i >= cards.size())
                throw new NoSuchElementException();
            Object[] elementData = cards.toArray();
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (Card) elementData[lastRet = i];
        }




    }
}
