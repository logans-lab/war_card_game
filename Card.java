package Model;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //getter
    public int getRank() {
        return rank.getRankValue();
    }

    //to print out in format "Rank of Suit"
    public String toString() {
        return String.format("%s of %s", rank.getRankName(), suit.getSuitValue());
    }
}