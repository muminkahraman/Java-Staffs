package Week2.Task3.Task3A;

import java.util.ArrayList;
import java.util.List;

public class Desk {
    private List<Card> cards;

    public Desk() {
        cards=new ArrayList<Card>(52);
        for (Card.Suit suit:Card.Suit.values()) {
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
}
