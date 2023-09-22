/**
 * defines a standard deck of 52 playing cards
 */

package proj4; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static proj4.Card.ranks;
import static proj4.Card.suits;

public class Deck {

    public final int DEFAULT_DECK_SIZE = 52;
    private final int FIRST_CARDS_INDEX = 0;

    private ArrayList<Card> deckContents;
    private int nextToDeal;



    /**
     * default constructor = initializes the instance variables
     */
    public Deck() {
        deckContents = new ArrayList<Card>(DEFAULT_DECK_SIZE);
        nextToDeal = FIRST_CARDS_INDEX;
        for (String suit: suits){
            for (int rank: ranks) {
                Card myCard = new Card(rank, suit);
                deckContents.add(myCard);
            }
        }
    }

    /**
     * shuffles the deck of cards
     */
    public void shuffle(){
        for (int i = nextToDeal; i <= DEFAULT_DECK_SIZE - 1; i++){
            int firstIndex = i;
            int randomIndex = ThreadLocalRandom.current().nextInt(DEFAULT_DECK_SIZE - 1);
            Card temporaryCard = deckContents.get(firstIndex);
            deckContents.set(firstIndex, deckContents.get(randomIndex));
            deckContents.set(randomIndex, temporaryCard);
        }
    }

    /**
     * returns the next unDealt card or null if deck is empty
     *
     * @return dealtCard: the next unDealt Card at index nextToDeal if deck isn't empty
     * @return null: if deck isn't empty
     */
    public Card deal(){
        if (!isEmpty()){
            Card dealtCard = deckContents.get(this.nextToDeal);
            this.nextToDeal += 1;
            return dealtCard;
        }
        else{
            return null;
        }
    }

    /**
     * method that returns a boolean indicating if there are still unDealt
     * cards in the deck
     *
     * @return true if deck is empty, false if deck is not empty
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * returns the number of unDealt cards in the deck
     *
     * @return integer number of unDealt card in the deck
     */
    public int size(){
        return DEFAULT_DECK_SIZE - nextToDeal;
    }

    /**
     * reverts the deck to a state where all cards are un-dealt
     */
    public void gather(){
        nextToDeal = FIRST_CARDS_INDEX;
    }

    /**
     * returns all the unDealt cards in the deck as a string
     *
     * @return string of all unDealt cards in the deck
     */
    public String toString(){
        String toReturn = "";
        for (int i = nextToDeal; i<=DEFAULT_DECK_SIZE - 1; i++){
            toReturn += "(" + deckContents.get(i) + ")" + " ";
        }
        return toReturn;
    }
}