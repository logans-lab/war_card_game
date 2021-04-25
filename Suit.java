package Model;

public enum Suit {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private final String suitValue;

    Suit(String suitValue) {
        this.suitValue = suitValue;
    }

    //getter
    public String getSuitValue() {
        return suitValue;
    }

    //for compiling the deck with unique ranks and suits
    private static final Suit[] suits = Suit.values();

    public static Suit getSuit(int i) {
        return Suit.suits[i];
    }
}
