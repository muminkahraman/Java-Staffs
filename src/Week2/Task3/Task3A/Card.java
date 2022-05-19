package Week2.Task3.Task3A;

public class Card {
    enum Suit {
        Hearts,
        Clubs,
        Diamonds,
        Spades
    }

    enum Rank {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seventh,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King
    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank +" of "+ suit +"\n";
    }
}
