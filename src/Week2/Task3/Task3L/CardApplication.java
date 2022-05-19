package Week2.Task3.Task3L;

public class CardApplication {

    public static void main(String[] args) {

        Deck D1 = new Deck() ;
        Card[] cards = new Card[52];

        D1.fill(cards);

        for (Card card : cards) {

            System.out.println(card.rank() + " of " + card.suit() );

        }
    }
}
