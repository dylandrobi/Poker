/**
 * represents the collection of community cards
 */

package proj4;

import java.util.ArrayList;

public class CommunityCardSet {
    public static final int COLLECTION_SIZE = 5;

    private ArrayList<Card> cardSet;  //instance variable


    /**
     * non-default constructor: initializes the instance variables
     *
     * @param cardList: array list which is a collection (of size COLLECTION_SIZE) of card objects
     */
    public CommunityCardSet(ArrayList<Card> cardList) {
        ArrayList<Card> newCardList = (ArrayList<Card>) cardList.clone();
        cardSet = newCardList;
    }

    /**
     * takes a Card object as a parameter and add that
     * card to the collection. Nothing happens if the collection already has 5
     * cards in it
     */
    public void addCard(Card newCard) {
        if (this.size() < COLLECTION_SIZE) {
            cardSet.add(newCard);
        }
    }

    /**
     * takes an index (int >= 0) as a parameter. It will
     * return the Card object at that index. Return null if index is invalid.
     *
     * @return Card object at given index. Null if index is invalid
     */
    public Card get_ith_card(int cardIndex) {
        if (cardIndex < this.size() & cardIndex >= 0) {
            return cardSet.get(cardIndex);
        }
        else {
            return null;
        }
    }

    /**
     * get the size of the cardSet
     *
     * @return integer size of cardSet collection of cards
     */
    public int size(){
        return cardSet.size();
    }

    /**
     * gathers the collection of the community cards from the object CommunityCardSet
     * into an ArrayList and returns it
     *
     * @return ccAsArray: an Array List of the Cards within the Community Card Set
     */
    public ArrayList<Card> communityCardsAsArrayList(){
        ArrayList<Card> ccAsArray = new ArrayList<Card>(this.size());   // use size() method, need to create in CCS class
        for (int i=0; i < CommunityCardSet.this.size(); i++){
            Card gatheredCard = this.get_ith_card(i);
            ccAsArray.add(gatheredCard);
        }
        return ccAsArray;
    }

    /**
     * returns all the Cards in the collection as a string
     *
     * @return string of Cards
     */
    public String toString() {
        String toReturn = "";
        for (int cardIndex = 0; cardIndex <= cardSet.size() - 1; cardIndex++) {
            Card myCard = get_ith_card(cardIndex);
            toReturn += "(" + myCard + ")" + " ";
        }
        return toReturn;
    }
}