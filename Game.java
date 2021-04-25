package Model;

public class Game {

    private static boolean emptyHand = false;
    static int position = 0;

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.populateDeck();
        deck.shuffleDeck(Deck.getDeck());
        deck.deal();

        Hand hand = new Hand();

        while (!emptyHand) {
            //reset position to first card in both decks
            position = 0;

            //check if a hand is empty
            if (hand.getPlayer1Deck().size() <= position || hand.getPlayer2Deck().size() <= position) {
                emptyHand = true;
                break;
            }

            //get card values for 4th faceup card to compare
            int player1Card = hand.playCard(hand.getPlayer1Deck(), position);
            int player2Card = hand.playCard(hand.getPlayer2Deck(), position);

            //each hand plays a card faceup
            System.out.println("New flip...");
            System.out.println("Player 1: " + hand.flipCard(hand.getPlayer1Deck(), position));
            System.out.println("Player 2: " + hand.flipCard(hand.getPlayer2Deck(), position));

            //compare faceup cards
            if (player1Card > player2Card) {
                System.out.println("Player 1 wins!");
                //if != winner adds all played cards into their hand
                hand.giveCardsToPlayer1(hand.getPlayer1Deck(), position);
                hand.giveCardsToPlayer1(hand.getPlayer2Deck(), position);
//                hand.printPlayer1Hand();
//                hand.printPlayer2Hand();
            } else if (player1Card < player2Card) {
                System.out.println("Player 2 wins!");
                //if != winner adds all played cards into their hand
                hand.giveCardsToPlayer2(hand.getPlayer2Deck(), position);
                hand.giveCardsToPlayer2(hand.getPlayer1Deck(), position);
//                hand.printPlayer1Hand();
//                hand.printPlayer2Hand();
            } else {
                System.out.println("Players tie!");
                boolean tied = false;
                position = 4;

                //if ==, play 3 cards face down and 1 faceup
                do {

                    //check if a hand will be empty
                    if (hand.getPlayer1Deck().size() <= position || hand.getPlayer2Deck().size() <= position) {
                        emptyHand = true;
                        break;
                    }

                    //get card values for 4th faceup card to compare
                    int p1Card = hand.playCard(hand.getPlayer1Deck(), position);
                    int p2Card = hand.playCard(hand.getPlayer2Deck(), position);

                    //play 3 cards facedown and compare 4th card faceup
                    System.out.println("New flip...");
                    System.out.println("Player 1: " + hand.flipCard(hand.getPlayer1Deck(), position));
                    System.out.println("Player 2: " + hand.flipCard(hand.getPlayer2Deck(), position));

                    //compare faceup cards
                    if (p1Card > p2Card) {
                        System.out.println("Player 1 wins!");
                        hand.giveCardsToPlayer1(hand.getPlayer1Deck(), position);
                        hand.giveCardsToPlayer1(hand.getPlayer2Deck(), position);
//                        hand.printPlayer1Hand();
//                        hand.printPlayer2Hand();
                    } else if (p1Card < p2Card) {
                        System.out.println("Player 2 wins!");
                        hand.giveCardsToPlayer2(hand.getPlayer2Deck(), position);
                        hand.giveCardsToPlayer2(hand.getPlayer1Deck(), position);
//                        hand.printPlayer1Hand();
//                        hand.printPlayer2Hand();
                    } else {
                        System.out.println("Players tie!");
                        position += 4;
                        tied = true;
                    }
                } while (tied);
            }

        }

        //if either player ran out of cards, other player wins the game
        if (hand.getPlayer1Deck().isEmpty() || hand.getPlayer1Deck().size() <= position) {
            System.out.println();
            System.out.println("Player 2 wins the game!");
        } else if (hand.getPlayer2Deck().isEmpty() || hand.getPlayer2Deck().size() <= position) {
            System.out.println();
            System.out.println("Player 1 wins the game!");
        }

//        hand.clearHand(deck.getPlayer1Deck());
//        hand.clearHand(deck.getPlayer2Deck());
        System.exit(0);
    }
}
