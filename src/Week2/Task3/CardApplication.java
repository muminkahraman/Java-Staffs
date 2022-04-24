package Week2.Task3;


public class CardApplication {

    public static void main(String[] args) {

        Deck deck = new Deck();

        Card[] cards = deck.getDeck();

        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
