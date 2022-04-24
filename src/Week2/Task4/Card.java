package Week2.Task4;

public class Card {
    private Suit suit;

    private Rank rank;

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString (){
        return (this.suit + " " + this.rank);
    }
}
