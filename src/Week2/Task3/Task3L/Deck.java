package Week2.Task3.Task3L;

public class Deck {

    private Card[] cards ;

    public Deck()
    {
        cards =new Card[52] ;
    }

    public Card[] getCards() {
        return cards;
    }


    public void fill(Card[] newDeck) {
        int i = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                newDeck[i] = new Card(rank, suit);
                i++;
            }

        }

    }
}
