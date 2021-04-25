package Model;

public enum Rank {
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    JACK(11, "Jack"),
    QUEEN(12, "Queen"),
    KING(13, "King"),
    ACE(14, "Ace");

    private final int rankValue;
    private final String rankName;

    Rank(int rankValue, String rankName) {
        this.rankValue = rankValue;
        this.rankName = rankName;
    }

    //getters
    public int getRankValue() {
        return rankValue;
    }

    public String getRankName() {
        return rankName;
    }

    //for compiling the deck with unique ranks and suits
    private static final Rank[] ranks = Rank.values();

    public static Rank getRank(int i) {
        return Rank.ranks[i];
    }
}
