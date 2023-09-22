package proj4; // do not erase. Gradescope expects this.

import java.util.*;

public class PokerHand {

    public static final int MAX_HAND_SIZE = 5;
    private final int FLUSH = 4;
    private final int TWO_PAIR = 3;
    private final int PAIR = 2;
    private final int HIGH_CARD = 1;
    private final int SAME_HAND = 0;

    private ArrayList<Card> handOfCards;  //instance variable


    /**
     * non-default constructor: initializes the instance variables
     *
     * @param cardList: array list which is a hand of Card objects
     */
    public PokerHand(ArrayList<Card> cardList) {
        ArrayList<Card> newCardList = (ArrayList<Card>) cardList.clone();
        handOfCards = newCardList;
    }

    /**
     * takes a Card object as a parameter and add that
     * card to the hand. Nothing happens if the hand already has 5
     * cards in it
     */
    public void addCard(Card newCard) {
        if (handOfCards.size() < MAX_HAND_SIZE) {
            handOfCards.add(newCard);
        }
    }

    /**
     * takes an index (int >= 0) as a parameter. It will
     * return the Card object at that index. Return null if index is invalid.
     *
     * @return Card object at given index. Null if index is invalid
     */
    public Card get_ith_card(int cardIndex) {
        if (cardIndex < handOfCards.size() & cardIndex >= 0) {
            return handOfCards.get(cardIndex);
        }
        else {
            return null;
        }
    }

    /**
     * returns all the Cards in the Hand as a string
     *
     * @return string of Cards
     */
    public String toString() {
        String toReturn = "";
        for (int cardIndex = 0; cardIndex <= handOfCards.size() - 1; cardIndex++) {
            Card myCard = get_ith_card(cardIndex);
            toReturn += "(" + myCard + ")" + " ";
        }
        return toReturn;
    }

    /**
     * returns an array list of the ranks in the hand, in order from greatest
     * rank to least rank
     *
     * @return sortedRanks: array list of ranks of cards in hand,
     * ordered greatest to least
     */
    private ArrayList<Integer> ranksInHand() {
        ArrayList<Integer> sortedRanks = new ArrayList<Integer>(MAX_HAND_SIZE);
        for (int cardIndex = 0; cardIndex <= MAX_HAND_SIZE - 1; cardIndex++) {
            Card myCard = get_ith_card(cardIndex);
            int myRank = myCard.getRank();
            sortedRanks.add(myRank);
        }
        Collections.sort(sortedRanks, Collections.reverseOrder());
        return sortedRanks;
    }

    /**
     * returns an array list of the suits of the cards in the given hand
     *
     * @return suitsList: array list of suits of cards in hand
     */
    private ArrayList<String> suitsInHand() {
        ArrayList<String> suitsList = new ArrayList<String>(MAX_HAND_SIZE);
        for (int cardIndex = 0; cardIndex <= MAX_HAND_SIZE - 1; cardIndex++) {
            Card myCard = get_ith_card(cardIndex);
            String mySuit = myCard.getSuit();
            suitsList.add(mySuit);
        }
        return suitsList;
    }

    /**
     * checks which type of hand it is and returns its hand value
     *
     * @param ranksList: array list of the current ranks in the hand
     * @param suitsList: array list of the current suits in the hand
     * @return handValue: integer where flush = 4, two-pair = 3, pair = 2, high-card = 1
     */
    public int checkHand(ArrayList<Integer> ranksList, ArrayList<String> suitsList) {
        int handValue = 0;
        if (this.isFlush(suitsList)) {
            handValue = FLUSH;
        } else if (this.isTwoPair(ranksList)) {
            handValue = TWO_PAIR;
        } else if (this.isPair(ranksList)) {
            handValue = PAIR;
        } else if (this.isHighCard()) {
            handValue = HIGH_CARD;
        }
        return handValue;
    }

    /**
     * decides whether the hand is a flush or not
     *
     * @param suitsList: array list of the current suits in the hand
     * @return boolean: true if it is a flush, false if not
     */
    private boolean isFlush(ArrayList<String> suitsList) {
        String suit1 = suitsList.get(0);
        String suit2 = suitsList.get(1);
        String suit3 = suitsList.get(2);
        String suit4 = suitsList.get(3);
        String suit5 = suitsList.get(4);
        if (suit1 == suit2 & suit2 == suit3 & suit3 == suit4 & suit4 == suit5){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * decides whether the hand contains a two-pair or not
     *
     * @param ranksList: array list of the current ranks in the hand
     * @return boolean: true hand has a two-pair, false if not
     */
    private boolean isTwoPair(ArrayList<Integer> ranksList) {
        Map<Integer, Integer> rankOccurances = new HashMap<Integer, Integer>();
        int pairs = 0;
        for (int rank : ranksList) {
            if (rankOccurances.containsKey(rank)) {
                int pairCountValue = rankOccurances.get(rank);
                int newPairCountValue = pairCountValue += 1;
                rankOccurances.put(rank, newPairCountValue);
            } else {
                rankOccurances.put(rank, 1);
            }
        }
        for (int rankOccurance : rankOccurances.values()) {
            if (rankOccurance == 4) {
                pairs += 2;
            } else if (rankOccurance >= 2) {
                pairs += 1;
            }
        }
        if (pairs >= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * decides whether the hand contains a pair or not
     *
     * @param ranksList: array list of the current ranks in the hand
     * @return boolean: true hand has a pair, false if not
     */
    private boolean isPair(ArrayList<Integer> ranksList) {
        int rankSize = ranksList.size();
        for (int rankIndex1 = 0; rankIndex1 <= rankSize - 2; rankIndex1++) {
            for (int rankIndex2 = rankIndex1 + 1; rankIndex2 <= rankSize - 1; rankIndex2++) {
                int rankOfIndex1 = ranksList.get(rankIndex1);
                int rankOfIndex2 = ranksList.get(rankIndex2);
                if (rankOfIndex1 == rankOfIndex2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * if its none of the other three types of hands, it's automatically
     * a high card hand
     *
     * @return boolean: Always return true
     */
    private boolean isHighCard() {
        return true;
    }

    /**
     * given an array list of ranks, retrieve the rank of the pair, then
     * remove both occurences of the rank from the list, and return that rank's value
     *
     * @param ranksList: array list containing the rank of each card in the hand
     * @return integer: value of the rank of the pair, return null if there's no pair
     * within the hand
     */
    private Integer obtainPairValue(ArrayList<Integer> ranksList) {
        int rankSize = ranksList.size();
        for (int rankIndex1 = 0; rankIndex1 <= rankSize - 2; rankIndex1++) {
            for (int rankIndex2 = rankIndex1 + 1; rankIndex2 <= rankSize - 1; rankIndex2++) {
                int rankOfIndex1 = ranksList.get(rankIndex1);
                int rankOfIndex2 = ranksList.get(rankIndex2);
                if (rankOfIndex1 == rankOfIndex2) {
                    int pairValue = ranksList.get(rankIndex1);
                    ranksList.remove(Integer.valueOf(rankOfIndex1));
                    ranksList.remove(Integer.valueOf(rankOfIndex2));
                    return pairValue;
                }
            }
        }
        return null;
    }

    /**
     * given an array list of ranks, retrieve the value of the highest rank,
     * pop it out of the list, then return it.
     * We are popping at index 0 because the list of ranks is in order from
     * greatest to smallest
     *
     * @param myRanks: Array list of ranks in hand
     * @return highCard: highest rank in list
     */
    private int obtainHighCardValue(ArrayList<Integer> myRanks) {
        int highCard = myRanks.remove(0);
        return highCard;
    }

    /**
     * compares which hand of type flush is better by comparing the
     * high cards in each hand.
     *
     * @param otherHand:  Hand of other player to compare
     * @param myRanks:    array list of current ranks in my hand
     * @param otherRanks: array list of current ranks in other hand
     * @return the integer difference between the high card value of each hand
     */
    private int compareFlush(PokerHand otherHand, ArrayList<Integer> myRanks, ArrayList<Integer> otherRanks) {
        return this.compareHighCards(otherHand, myRanks, otherRanks);
    }

    /**
     * compares both pairs of ranks-- in my hand and other
     * hand -- and determines which pair is better (higher number)
     * then returns the difference between the rank values
     * If the higher pair values are different, return the
     * difference of the pair values
     * If the higher pair values are the same, compare the
     * lower pair value of each hand. If those values differ,
     * return the difference of the two. If their values
     * are the same, return the difference of the high card values
     *
     * @param otherHand:  Hand of other player to compare
     * @param myRanks:    array list of current ranks in my hand
     * @param otherRanks: array list of current ranks in other hand
     * @return the integer difference of whichever components vary,
     * whether it's the first pair, second pair, or high card
     */
    private Integer compareTwoPair(PokerHand otherHand, ArrayList<Integer> myRanks, ArrayList<Integer> otherRanks) {
        int myHigherPair = this.obtainPairValue(myRanks);
        int myLowerPair = this.obtainPairValue(myRanks);
        int otherHigherPair = otherHand.obtainPairValue(otherRanks);
        int otherLowerPair = otherHand.obtainPairValue(otherRanks);
        if (myHigherPair != otherHigherPair) {
            return myHigherPair - otherHigherPair;
        }
        else {
            if (myLowerPair != otherLowerPair) {
                return myLowerPair - otherLowerPair;
            } else {
                return this.compareHighCards(otherHand, myRanks, otherRanks);
            }
        }
    }

    /**
     * compares which pair of ranks (in my hand in other hand) is better (the higher value)
     * then return the difference between the rank values. If the pair is the same
     * (both pairs of 8's), then compare their high card values and return that difference
     *
     * @param otherHand:  Hand of the other pler to compare with
     * @param myRanks:    Array list of current ranks in my hand
     * @param otherRanks: Array list of current ranks in other hand
     * @return integer of difference between the pair value, or if they're the same,
     * the difference between the high card, and if those are the same, return 0
     */
    private int comparePair(PokerHand otherHand, ArrayList<Integer> myRanks, ArrayList<Integer> otherRanks) {
        int myPair = this.obtainPairValue(myRanks);
        int otherPair = otherHand.obtainPairValue(otherRanks);
        if (myPair == otherPair) {
            return this.compareHighCards(otherHand, myRanks, otherRanks);
        } else {
            return myPair - otherPair;
        }
    }

    /**
     * compares the rank of the high card in both my hand
     * and other hand. If the ranks are the same, compare the
     * next high card's with each other. If they're the
     * same, repeat the process until their values differ,
     * then return the difference of the two. If all high
     * cards are the same, return 0.
     *
     * @param otherHand:  Hand of the other player to compare with
     * @param myRanks:    List of current ranks in my hand
     * @param otherRanks: List of current ranks in other hand
     * @return integer value representing the difference between
     * the high card of each hand, 0 if all high cards are the same value
     */
    private int compareHighCards(PokerHand otherHand, ArrayList<Integer> myRanks, ArrayList<Integer> otherRanks) {
        int myHighCard = this.obtainHighCardValue(myRanks);
        int otherHighCard = otherHand.obtainHighCardValue(otherRanks);
        int myCurrentHighCard = myHighCard;
        int otherCurrentHighCard = otherHighCard;
        while (myCurrentHighCard == otherCurrentHighCard) {
            if (myRanks.size() > 0) {
                myCurrentHighCard = this.obtainHighCardValue(myRanks);
                otherCurrentHighCard = otherHand.obtainHighCardValue(otherRanks);
            } else {
                return SAME_HAND;
            }
        }
        return myCurrentHighCard - otherCurrentHighCard;
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative integer if this hand is worth LESS than other hand, zero
     * if they are worth the SAME, and a positive number if this hand is worth
     * MORE than other hand
     */
    public int compareTo(PokerHand other) {
        ArrayList<Integer> myRanks = this.ranksInHand();
        ArrayList<String> mySuits = this.suitsInHand();
        ArrayList<Integer> otherRanks = other.ranksInHand();
        ArrayList<String> otherSuits = other.suitsInHand();
        int myType = this.checkHand(myRanks, mySuits);
        int otherType = other.checkHand(otherRanks, otherSuits);
        if (myType != otherType) {
            return myType - otherType;
        } else if (myType == FLUSH) {
            return this.compareFlush(other, myRanks, otherRanks);
        } else if (myType == TWO_PAIR) {
            return this.compareTwoPair(other, myRanks, otherRanks);
        } else if (myType == PAIR) {
            return this.comparePair(other, myRanks, otherRanks);
        } else {
            return this.compareHighCards(other, myRanks, otherRanks);
        }
    }
}