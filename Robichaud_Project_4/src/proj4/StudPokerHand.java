/**
 * represents a 2-card poker hand that also has access to the community cards.
 */

package proj4;

import java.util.ArrayList;

public class StudPokerHand {
    public static final int MAX_STUD_HAND_SIZE = 2;
    public static final int STUD_COMBINED_CC_MAX_SIZE = MAX_STUD_HAND_SIZE + CommunityCardSet.COLLECTION_SIZE;

    private ArrayList<Card> studHandOfCards;  //instance variable
    private CommunityCardSet communityCardSet; //instance variable

    /**
     * non-default constructor: initializes the instance variables
     *
     * @param cc: Group of cards which are in type CommunityCardSet. Represents community pile of cards
     * @param cardList: The array list of cards which belong to the player's hand
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        ArrayList<Card> newCardList = (ArrayList<Card>) cardList.clone();
        studHandOfCards = newCardList;
        communityCardSet = cc;
    }

    /**
     * takes a Card object as a parameter and add that
     * card to the hand. Nothing happens if the hand already has 2
     * cards in it
     */
    public void addCard(Card newCard) {
        if (studHandOfCards.size() < MAX_STUD_HAND_SIZE) {
            studHandOfCards.add(newCard);
        }
    }

    /**
     * takes an index (int >= 0) as a parameter. It will
     * return the Card object at that index. Return null if index is invalid.
     *
     * @return Card object at given index. Null if index is invalid
     */
    public Card get_ith_card(int cardIndex) {
        if (cardIndex < studHandOfCards.size() & cardIndex >= 0) {
            return studHandOfCards.get(cardIndex);
        } else {
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
        for (int cardIndex = 0; cardIndex <= studHandOfCards.size() - 1; cardIndex++) {
            Card myCard = get_ith_card(cardIndex);
            toReturn += "(" + myCard + ")" + " ";
        }
        return toReturn;
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other){
        PokerHand myBestHand = this.getBestFiveCardHand();
        PokerHand otherBestHand = other.getBestFiveCardHand();
        int comparisonValue = myBestHand.compareTo(otherBestHand);
        return comparisonValue;
    }

    /**
     * given two indexes, remove the two cards from the Array List of 7 cards (Stud Poker Hand of 2 and Community Card
     * Set of 5), and return a singular Poker Hand
     *
     * @param i: first index of card to be removed
     * @param j: second index of card to be removed
     * @return pokerHandCombination: unique Poker Hand combination of stud poker hand and community card set cards
     */
    private PokerHand getOneFiveCardHand(int i, int j){
        ArrayList<Card> handContents = new ArrayList<Card> (communityCardSet.size() + studHandOfCards.size());
        handContents.addAll(studHandOfCards);
        ArrayList<Card> communityCardsToAdd = communityCardSet.communityCardsAsArrayList(); //HAS TO BE IN COMMUNITY CARDS CLASS!!!!
        handContents.addAll(communityCardsToAdd);
        Card cardToRemove1 = handContents.get(i);
        Card cardToRemove2 = handContents.get(j);
        handContents.remove(cardToRemove1);
        handContents.remove(cardToRemove2);
        PokerHand pokerHandCombination = new PokerHand(handContents);
        return pokerHandCombination;
    }

    /**
     * get every possible combination of 5-Card PokerHands using cards from the
     * Stud Poker Hand (2 Cards) and the Community Card Set (5 Cards)
     *
     * @return allHands: an Array List of all possible Poker Hands
     */
    private ArrayList<PokerHand> getAllFiveCardHands(){
        ArrayList<PokerHand> allHands = new ArrayList<PokerHand>(PokerHand.MAX_HAND_SIZE);
        for (int i =0; i<STUD_COMBINED_CC_MAX_SIZE; i++ ){
            for (int j = i+1; j<STUD_COMBINED_CC_MAX_SIZE; j++ ){
                PokerHand pokerHandCombination = getOneFiveCardHand(i,j);
                allHands.add(pokerHandCombination);
            }
        }
        return allHands;
    }

    /**
     * find the best hand (worth the most) out of all the 5-Card PokerHand combinations
     * and return it
     *
     * @return bestSoFar: the best PokerHand in the ArrayList of Poker Hands
     */
    private PokerHand getBestFiveCardHand()
    {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }
}