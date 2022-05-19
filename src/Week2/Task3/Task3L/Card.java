package Week2.Task3.Task3L;

public class Card {

    public enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
                9), TEN(10), JACK(10), QUEEN(10), KING(10);

        private int points;

        Rank(int points) {
            this.points = points;
        }

        public int getRankpoints() {
            return this.points;
        }

    }

    public enum Suit {
        SPADES(1), CLUBS(2), DIAMONDS(3), HEARTS(4);

        private int suitPoints;

        Suit(int points) {

            this.suitPoints = points;

        }

        public int getSuitpoints() {
            return this.suitPoints;
        }

    }

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return this.rank;
    }

    public Suit suit() {

        return this.suit;

    }

}
