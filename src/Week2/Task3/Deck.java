package Week2.Task3;

public class Deck {
    public Card[] getDeck() {
        return deck;
    }

    private Card[] deck = new Card[52];

    public Deck(){
        int counter = 0;
        for (Suit suit:Suit.values()) {
            for (Rank rank : Rank.values()){
                deck[counter] = new Card(suit, rank);
                counter++;
            }
        }
    }
}
