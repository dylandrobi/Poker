/**
 * defines properties and behavior of a single playing card
 */

package proj4; // do not erase. Gradescope expects this.

public class Card {
    public static final int[] ranks = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    public static final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    private final int ACE = 14;
    private final String DEFAULT_SUIT_STR = "Spades";
    private final int DEFAULT_SUIT_INT = 0;
    private  final int DEFAULT_RANK_INT = ACE;
    private final String DEFAULT_RANK_STR = "Ace";

    private int rank; // instance variable
    private String suit; // instance variable


    /**
     * non-default constructor = initializes the instance variables
     *
     * @param newRank: rank of card: 2,3,4 ... 11 = Jack, 12 = Queen, etc
     * @param newSuit: card's suit: "Clubs", "Hearts", etc;
     */
    public Card(int newRank, String newSuit) {
        this.rank = newRank;
        this.suit = newSuit;
    }

    /**
     * constructor
     * @param rank String: whole cards (2-10) can either be spelled
     * out like "two" or numeric like "2". Face cards will always be
     * spelled out like "Jack". Case insensitive.
     * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit){
        Integer intRank = rank2Int(rank);
        String strSuit = suit.substring(0, 1).toUpperCase() + suit.substring(1).toLowerCase();  // hEartS --> Hearts
        this.rank = intRank;
        this.suit = strSuit;
    }
    /**
     * constructor
     * @param rank integer between 2-14
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int rank, int suit){
        this.rank = rank;
        String strSuit = suit2String(suit);
        this.suit = strSuit;
    }

    /**
     * returns rank of this Card
     *
     * @return int between 2-14
     */
    public int getRank() {
        return rank;
    }

    /**
     * returns suit of this card
     *
     * @return String of either "Hearts", "Clubs", "Spades", or "Diamonds"
     */
    public String getSuit() {
        return suit;
    }

    /**
     * helper method that converts integer suit to string... 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     *
     * @return String version of suit
     */
    private String suit2String(int suit){
        String suitAsString;
        if (suit==0) {
            suitAsString = "Spades";
        }
        else if (suit==1) {
            suitAsString = "Hearts";
        }
        else if (suit==2) {
            suitAsString = "Clubs";
        }
        else if (suit==3) {
            suitAsString = "Diamonds";
        }
        else {  // numeric rank
            suitAsString = DEFAULT_SUIT_STR;
        }
        return suitAsString;
    }

    /**
     * helper method that converts string rank to integer... "Two" --> 2
     *
     * @return integer version of rank
     */
    private Integer rank2Int(String rank){
        Integer rankAsInt;
        String cardRankLowerCase = rank.toLowerCase();
        if (cardRankLowerCase.equals("two") || cardRankLowerCase.equals("2")) {
            rankAsInt = 2;
        }
        else if (cardRankLowerCase.equals("three") || cardRankLowerCase.equals("3")) {
            rankAsInt = 3;
        }
        else if (cardRankLowerCase.equals("four") || cardRankLowerCase.equals("4")) {
            rankAsInt = 4;
        }
        else if (cardRankLowerCase.equals("five") || cardRankLowerCase.equals("5")) {
            rankAsInt = 5;
        }
        else if (cardRankLowerCase.equals("six") || cardRankLowerCase.equals("6")) {
            rankAsInt = 6;
        }
        else if (cardRankLowerCase.equals("seven") || cardRankLowerCase.equals("7")) {
            rankAsInt = 7;
        }
        else if (cardRankLowerCase.equals("eight") || cardRankLowerCase.equals("8")) {
            rankAsInt = 8;
        }
        else if (cardRankLowerCase.equals("nine") || cardRankLowerCase.equals("9")) {
            rankAsInt = 9;
        }
        else if (cardRankLowerCase.equals("ten") || cardRankLowerCase.equals("10")) {
            rankAsInt = 10;
        }
        else if (cardRankLowerCase.equals("jack") || cardRankLowerCase.equals("11")) {
            rankAsInt = 11;
        }
        else if (cardRankLowerCase.equals("queen") || cardRankLowerCase.equals("12")) {
            rankAsInt = 12;
        }
        else if (cardRankLowerCase.equals("king") || cardRankLowerCase.equals("13")) {
            rankAsInt = 13;
        }
        else if (cardRankLowerCase.equals("ace") || cardRankLowerCase.equals("14")) {
            rankAsInt = 14;
        }
        else {  // numeric rank
            rankAsInt = DEFAULT_RANK_INT;
        }
        return rankAsInt;
    }

    /**
     * helper method that converts integer rank to string like "Jack"
     *
     * @return String version of rank
     */
    private String rank2String(){
        String rankAsString;
        int cardRank = this.getRank();
        if (cardRank==JACK) {
            rankAsString = "Jack";
        }
        else if (cardRank==QUEEN) {
            rankAsString = "Queen";
        }
        else if (cardRank==KING) {
            rankAsString = "King";
        }
        else if (cardRank==ACE) {
            rankAsString = "Ace";
        }
        else {  // numeric rank
            rankAsString = String.valueOf(cardRank);
        }
        return rankAsString;
    }

    /**
     * return a string version of this Card object
     *
     * @return printable string like "5 of Clubs"
     */
    public String toString() {
        String rankAsString = rank2String();
        return rankAsString + " of " + getSuit();
    }
}