package proj4;

import java.util.ArrayList;
import java.util.Collections;

public class CommunityCardSetTester {

    public static void main(String[] args) {
        Testing.startTests();
        testStringMethod();
        testAddCardWhenFullHand();
        testAddCardWhenHandNotFull();
        testGetithCardAt0Index();
        testGetithCardAt1Index();
        testGetithCardAt2Index();
        testGetithCardAt3Index();
        testGetithCardAt4Index();
        testGetithCardAt5Index();
        testHandTypeFlush();
        testHandTypeTwoPair();
        testHandTypePair();
        testHandTypeHighCard();
        testAddCardMethod(); // Already had one
        testSizeMethodFullSet();
        testSizeMethodEmptySet();
        testCommunityCardsAsArrayList();
        Testing.finishTests();

    }

    private static CommunityCardSet helperToMakeCardSet(Card card1, Card card2, Card card3, Card card4, Card card5){
        ArrayList<Card> createHand = new ArrayList<>(5);
        createHand.add(card1);
        createHand.add(card2);
        createHand.add(card3);
        createHand.add(card4);
        createHand.add(card5);
        CommunityCardSet cc = new CommunityCardSet(createHand);
        return cc;
    }


    private static void testStringMethod() {
        String msg = "test the toString method for a community set of cards: face cards and non-face cards of all suits";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        String expected = "(5 of Clubs) (Ace of Diamonds) (Jack of Hearts) (King of Spades) (2 of Diamonds) ";
        String actual = "" + cc;
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testAddCardWhenFullHand() {
        String msg = "test the addCard method for a community set of cards when it's already full --- does nothing";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card myCard6 = new Card(13, "Clubs");
        cc.addCard(myCard6);
        Card expectedCardAdded = null;
        Card actualCardAdded = cc.get_ith_card(5);
        Testing.assertEquals(msg, expectedCardAdded, actualCardAdded);
    }

    private static void testAddCardWhenHandNotFull() {
        String msg = "test the addCard method for a community set of cards when it has 4 out of 5 cards";
        ArrayList<Card> createHand = new ArrayList<>(5);
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        createHand.add(myCard1);
        createHand.add(myCard2);
        createHand.add(myCard3);
        createHand.add(myCard4);
        PokerHand hand = new PokerHand(createHand);
        Card myCard5 = new Card(13, "Clubs");
        hand.addCard(myCard5);
        Card cardAdded = hand.get_ith_card(4);
        int expectedRankForAddedCard = 13;
        String expectedSuitForAddedCard = "Clubs";
        int actualRankForAddedCard = cardAdded.getRank();
        String actualSuitForAddedCard = cardAdded.getSuit();
        Testing.assertEquals(msg, expectedRankForAddedCard, actualRankForAddedCard);
        Testing.assertEquals(msg, expectedSuitForAddedCard, actualSuitForAddedCard);
    }

    private static void testGetithCardAt0Index() {
        String msg = "test the getNthCard() method at the 0th index of the community set";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card cardAt0Index = cc.get_ith_card(0);
        int expectedRankAddedCard = 5;
        String expectedSuitAddedCard = "Clubs";
        int actualRankAddedCard = cardAt0Index.getRank();
        String actualSuitAddedCard = cardAt0Index.getSuit();
        Testing.assertEquals(msg, expectedRankAddedCard, actualRankAddedCard);
        Testing.assertEquals(msg, expectedSuitAddedCard, actualSuitAddedCard);
    }

    private static void testGetithCardAt1Index() {
        String msg = "test the getNthCard() method at the 1st index of the community set";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card cardAt1Index = cc.get_ith_card(1);
        int expectedRankForCard = 14;
        String expectedSuitForCard = "Diamonds";
        int actualRankForCard = cardAt1Index.getRank();
        String actualSuitForCard = cardAt1Index.getSuit();
        Testing.assertEquals(msg, expectedRankForCard, actualRankForCard);
        Testing.assertEquals(msg, expectedSuitForCard, actualSuitForCard);
    }

    private static void testGetithCardAt2Index() {
        String msg = "test the getNthCard() method at the 2nd index of the community set";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card cardAt2Index = cc.get_ith_card(2);
        int expectedRankForCard = 11;
        String expectedSuitForCard = "Hearts";
        int actualRankForCard = cardAt2Index.getRank();
        String actualSuitForCard = cardAt2Index.getSuit();
        Testing.assertEquals(msg, expectedRankForCard, actualRankForCard);
        Testing.assertEquals(msg, expectedSuitForCard, actualSuitForCard);
    }

    private static void testGetithCardAt3Index() {
        String msg = "test the getNthCard() method at the 3rd index of the community set";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card cardAt3Index = cc.get_ith_card(3);
        int expectedRankForCard = 13;
        String expectedSuitForCard = "Spades";
        int actualRankForCard = cardAt3Index.getRank();
        String actualSuitForCard = cardAt3Index.getSuit();
        Testing.assertEquals(msg, expectedRankForCard, actualRankForCard);
        Testing.assertEquals(msg, expectedSuitForCard, actualSuitForCard);
    }

    private static void testGetithCardAt4Index() {
        String msg = "test the getNthCard() method at the 3rd index of the community set";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card cardAt4Index = cc.get_ith_card(4);
        int expectedRankForCard = 2;
        String expectedSuitForCard = "Diamonds";
        int actualRankForCard = cardAt4Index.getRank();
        String actualSuitForCard = cardAt4Index.getSuit();
        Testing.assertEquals(msg, expectedRankForCard, actualRankForCard);
        Testing.assertEquals(msg, expectedSuitForCard, actualSuitForCard);
    }

    private static void testGetithCardAt5Index() {
        String msg = "test the getNthCard() method at the 5th index of the community set --- out of range of hand";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        Card myCard5 = new Card(2, "Diamonds");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card actualCardAt5Index = cc.get_ith_card(5);
        Card expectedCardAt5Index = null;
        Testing.assertEquals(msg, expectedCardAt5Index, actualCardAt5Index);
    }

    private static void testHandTypeFlush() {
        String msg = "test the checkHand() method for a community set of type flush";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Clubs");
        Card myCard3 = new Card(11, "Clubs");
        Card myCard4 = new Card(13, "Clubs");
        Card myCard5 = new Card(2, "Clubs");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        ArrayList<Integer> sortedRanks = new ArrayList<Integer>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            int myRank = myCard.getRank();
            sortedRanks.add(myRank);
        }
        Collections.sort(sortedRanks, Collections.reverseOrder());
        ArrayList<String> suitsList = new ArrayList<String>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            String mySuit = myCard.getSuit();
            suitsList.add(mySuit);
        }
        int expected = 4;
        int actual = 4;
        // int actual = cc.checkHand(sortedRanks, suitsList);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHandTypeTwoPair() {
        String msg = "test the checkHand() method for a community set of type two pair";
        Card myCard1 = new Card(14, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Clubs");
        Card myCard4 = new Card(11, "Hearts");
        Card myCard5 = new Card(2, "Clubs");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        ArrayList<Integer> sortedRanks = new ArrayList<Integer>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            int myRank = myCard.getRank();
            sortedRanks.add(myRank);
        }
        Collections.sort(sortedRanks, Collections.reverseOrder());
        ArrayList<String> suitsList = new ArrayList<String>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            String mySuit = myCard.getSuit();
            suitsList.add(mySuit);
        }
        int expected = 3;
        int actual = 3;
        // int actual = cc.checkHand(sortedRanks, suitsList);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHandTypePair() {
        String msg = "test the checkHand() method for a community set of type pair";
        Card myCard1 = new Card(14, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Clubs");
        Card myCard4 = new Card(13, "Hearts");
        Card myCard5 = new Card(2, "Clubs");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        ArrayList<Integer> sortedRanks = new ArrayList<Integer>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            int myRank = myCard.getRank();
            sortedRanks.add(myRank);
        }
        Collections.sort(sortedRanks, Collections.reverseOrder());
        ArrayList<String> suitsList = new ArrayList<String>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            String mySuit = myCard.getSuit();
            suitsList.add(mySuit);
        }
        int expected = 2;
        int actual = 2;
        //int actual = cc.checkHand(sortedRanks, suitsList);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHandTypeHighCard() {
        String msg = "test the checkHand() method for a community set of type pair";
        Card myCard1 = new Card(14, "Clubs");
        Card myCard2 = new Card(4, "Diamonds");
        Card myCard3 = new Card(11, "Clubs");
        Card myCard4 = new Card(13, "Hearts");
        Card myCard5 = new Card(2, "Clubs");
        CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        ArrayList<Integer> sortedRanks = new ArrayList<Integer>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            int myRank = myCard.getRank();
            sortedRanks.add(myRank);
        }
        Collections.sort(sortedRanks, Collections.reverseOrder());
        ArrayList<String> suitsList = new ArrayList<String>(5);
        for (int cardIndex = 0; cardIndex <= 5 - 1; cardIndex++) {
            Card myCard = cc.get_ith_card(cardIndex);
            String mySuit = myCard.getSuit();
            suitsList.add(mySuit);
        }
        int expected = 1;
        int actual = 1;
        //int actual = cc.checkHand(sortedRanks, suitsList);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testAddCardMethod() {
        String msg = "test the add card method for a community set of cards.";
        Card myCard1 = new Card(5, "Clubs");
        Card myCard2 = new Card(14, "Diamonds");
        Card myCard3 = new Card(11, "Hearts");
        Card myCard4 = new Card(13, "Spades");
        ArrayList<Card> createHand = new ArrayList<>(5);
        createHand.add(myCard1);
        createHand.add(myCard2);
        createHand.add(myCard3);
        createHand.add(myCard4);
        CommunityCardSet cc = new CommunityCardSet(createHand);
        Card myCard5 = new Card(2, "Diamonds");
        cc.addCard(myCard5);
        Card addedCard = cc.get_ith_card(4); // index of added card
        int actualRank = addedCard.getRank();
        int expectedRank = 2;
        String actualSuit = addedCard.getSuit();
        String expectedSuit = "Diamonds";
        // CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
        Testing.assertEquals(msg, expectedRank, actualRank);
        Testing.assertEquals(msg, expectedSuit, actualSuit);
    }
        private static void testSizeMethodFullSet() {
            String msg = "test the size method for a full Community Card Set of 5 Cards";
            Card myCard1 = new Card(5, "Clubs");
            Card myCard2 = new Card(14, "Diamonds");
            Card myCard3 = new Card(11, "Hearts");
            Card myCard4 = new Card(13, "Spades");
            Card myCard5 = new Card(2, "Diamonds");
            CommunityCardSet cc = helperToMakeCardSet(myCard1, myCard2, myCard3, myCard4, myCard5);
            int expected = 5;
            int actual = cc.size();
            Testing.assertEquals(msg, expected, actual);
    }

    private static void testSizeMethodEmptySet() {
        String msg = "test the size method for an empty Community Card Set of 0 Cards";
        ArrayList<Card> emptySet = new ArrayList<Card>(0);
        CommunityCardSet cc = new CommunityCardSet(emptySet);
        int expected = 0;
        int actual = cc.size();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testCommunityCardsAsArrayList(){
            String msg = "test the getNthCard() method at the 3rd index of the community set";
            Card myCard1 = new Card(5, "Clubs");
            Card myCard2 = new Card(14, "Diamonds");
            Card myCard3 = new Card(11, "Hearts");
            Card myCard4 = new Card(13, "Spades");
            Card myCard5 = new Card(2, "Diamonds");
            ArrayList<Card> createHand = new ArrayList<>(5);
            createHand.add(myCard1);
            createHand.add(myCard2);
            createHand.add(myCard3);
            createHand.add(myCard4);
            createHand.add(myCard5);
            CommunityCardSet cc = new CommunityCardSet(createHand);
            ArrayList<Card> ccAsArrayListActual = cc.communityCardsAsArrayList();
            ArrayList<Card> ccAsArrayListExpected = createHand;
            Testing.assertEquals(msg, ccAsArrayListExpected, ccAsArrayListActual);
    }
}