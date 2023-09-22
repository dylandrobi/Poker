/**
 * A simple user-implemented game of Texas Hold'em. This will entail one main difference: Instead of 5-card poker hands,
 * we will have community cards (five cards that all hands can use) and hole cards (2-card stud poker hands)
 * from which to make the best possible 5-card hand.
 * We first draw five community cards
 * from a deck and then repeatedly:
 * 1. Draw two new 2-card hands from a given deck. These are the hole cards.
 * 2. Print the community cards and the hands.
 * 3. Ask the user who the winner is (or if there's a tie), taking into account the community cards.
 * 4. If the player is correct, they get one point and the game continues.
 * 5. If the player is incorrect, the game ends and the player's total points should be displayed.
 * 6. The game is also over if there are not enough cards left in the deck to play another round.
 *
 * Project 4:
 * Dylan Robichaud
 * CS-120 with Chris
 * 05/24/23
 *
 * I affirm that I have carried out the attached academic
 * endeavors with full academic honesty, in accordance with
 * the Union College Honor Code and the course syllabus.
 */

package proj4;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static final int STARTING_POINTS = 0;
    private static final int POINT_EARNED = 1;
    private static final int NUMBER_OF_PLAYERS = 2;
    private static final int CARD_TOTAL_OF_N_HANDS_AND_N_COMMUNITY_CARDS = (StudPokerHand.MAX_STUD_HAND_SIZE *
            NUMBER_OF_PLAYERS) + CommunityCardSet.COLLECTION_SIZE;
    private static final int PLAYER_1_WON = 1;
    private static final int PLAYER_2_WON = 2;
    private static final int TIED_GAME = 3;


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        Deck deckOfCards = new Deck();
        deckOfCards.shuffle();
        boolean gameOver = false;
        int player1Points = STARTING_POINTS;
        while (!gameOver) {
            if (deckIsInsufficientToDealMore(deckOfCards)) {
                System.out.println("Game over: No cards left in deck");
                System.out.println("You earned a total of " + player1Points + " points!"); // repeated code that could have a helper?
                gameOver = true;
            }
            else{
                CommunityCardSet cardSet = dealNCardsToCommunityCardSet(deckOfCards);
                System.out.println("The community cards are: " + cardSet);
                StudPokerHand player1StudHand = dealNCardsToHand(deckOfCards, cardSet);
                System.out.println("Player 1's Hand: " + player1StudHand);
                StudPokerHand player2StudHand = dealNCardsToHand(deckOfCards, cardSet);
                System.out.println("Player 2's Hand: " + player2StudHand);
                int actualWinner = getWinner(player1StudHand, player2StudHand);
                System.out.println("Which hand wins? Player 1 = 1 || Player 2 = 2 || Tie =3");
                int guessedWinner = sc.nextInt();
                if (guessedWinner == actualWinner){
                    player1Points += POINT_EARNED;
                    System.out.println("Correct!");
                    System.out.println("----------------------------------------------------------------------------");
                }
                else{
                    System.out.println("You lost :(");
                    System.out.println("You earned a total of " + player1Points + " points!");
                    deckOfCards.gather();
                    gameOver = true;
                }
            }
        }
    }

    /**
     * given a deck of cards, deal a stud hand of cards and return that hand
     *
     * @param deckOfCards: Deck of cards
     * @return handOfCards: hand of cards of type PokerHand
     */
    public static StudPokerHand dealNCardsToHand(Deck deckOfCards, CommunityCardSet cc) {
        ArrayList<Card> newHandArray = new ArrayList<>(StudPokerHand.MAX_STUD_HAND_SIZE);
        for (int cardsDealt = 0; cardsDealt < StudPokerHand.MAX_STUD_HAND_SIZE; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
            newHandArray.add(dealtCard);
        }
        StudPokerHand studHandOfCards = new StudPokerHand(cc, newHandArray);
        return studHandOfCards;
    }

    /**
     * given a deck of cards, deal a stud hand of cards and return that hand
     *
     * @param deckOfCards: Deck of cards
     * @return handOfCards: hand of cards of type PokerHand
     */
    public static CommunityCardSet dealNCardsToCommunityCardSet(Deck deckOfCards) {
        ArrayList<Card> newCardSetArray = new ArrayList<>(CommunityCardSet.COLLECTION_SIZE);
        for (int cardsDealt = 0; cardsDealt < CommunityCardSet.COLLECTION_SIZE; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
            newCardSetArray.add(dealtCard);
        }
        CommunityCardSet cardSet = new CommunityCardSet(newCardSetArray);
        return cardSet;
    }

    /**
     * given the hand of player1 and player2, return which hand
     * is better
     *
     * @param player1StudHand: Player 1's hand of cards
     * @param player2StudHand: Player 2's hand of cards
     * @return integer: 1 if player 1 wins, 2 if player 2 wins
     * 3 if tied game.
     */
    private static int getWinner(StudPokerHand player1StudHand, StudPokerHand player2StudHand){
        int winner = player1StudHand.compareTo(player2StudHand);
        if (winner > 0){
            return PLAYER_1_WON;
        }
        else if (winner < 0){
            return PLAYER_2_WON;
        }
        else{
            return TIED_GAME;
        }
    }

    /**
     * given a deck of cards, determine if it has enough cards
     * to deal to n amount of players, return True if it doesn't
     * have enough cards
     *
     * @param deckOfCards: Deck of playing cards
     * @return boolean: True if it does not have enough cards
     * to deal to n players. False if not
     */
    private static boolean deckIsInsufficientToDealMore(Deck deckOfCards){
        if (deckOfCards.size() < CARD_TOTAL_OF_N_HANDS_AND_N_COMMUNITY_CARDS){
            return true;
        }
        else {
            return false;
        }
    }
}