package proj4;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class StudPokerHandTester {

    private static String D = "Diamonds";
    private static String S = "Spades";
    private static String C = "Clubs";
    private static String H = "Hearts";

    public static void main(String[] args) {
        Testing.startTests();
        testStringMethod();
        testAddMethodWhenHandEmpty();
        testAddMethodWhenHandFull();
        testGetIthCardOfFullHand();
        testFlushVsTwoPair();
        testFlushVsPair();
        testFlushVsHighCard();
        testTwoPairVsFlush();
        testPairVsFlush();
        testHighCardVsFlush();
        testHighCardVsFlushPt2();
        testHighCardVsLowCard();
        testHighHighVsHighLow();
        testHighLowVsHighHigh();
        test3HighVs2High1Low();
        test2High1LowVs3High();
        test4HighVs3High1Low();
        test3High1LowVs4High();
        test5HighVs4High1Low();
        test4High1LowVs5High();
        testSameExactHighCard();
        testHighPairVsLowPair();
        testLowPairVsHighPair();
        testSamePairHighVsLow();
        testSamePairLowVsHigh();
        testSamePair2HighVs1High1Low();
        testSamePair1High1LowVs2High();
        testSamePair3HighVs2High1Low();
        testSamePair2High1LowVs3High();
        testSamePairSameHighCard();
        testHighPairHighPairVsLowPairLowPair();
        testLowPairLowPairVsHighPairHighPair();
        testHighPairHighPairVsHighPairLowPair();
        testHighPairLowPairVsHighPairHighPair();
        testSameTwoPairHighCardLowCard();
        testSameTwoPairLowCardHighCard();
        testSameTwoPairSameHighCard();
        testBothFlushHighCardVsLowCard();
        testBothFlushLowCardVsHighCard();
        testBothFlush2HighCardsVs1HighCard1LowCard();
        testBothFlush1HighCard1LowCardVs2HighCards();
        testBothFlush3HighCardsVs2HighCard1LowCard();
        testBothFlush2HighCard1LowCardVs3HighCards();
        testBothFlush4HighCardsVs3HighCard1LowCard();
        testBothFlush3HighCard1LowCardVs4HighCards();
        testBothFlush5HighCardsVs4HighCard1LowCard();
        testBothFlush4HighCard1LowCardVs5HighCards();
        testSameExactFlush();
        test4OfAKindVsPair();
        testHighPairHighPairvsHighPairLowPair();
        Testing.finishTests();
    }
    private static CommunityCardSet helperToMakeCommunityCards(Card card1, Card card2, Card card3, Card card4, Card card5){
        ArrayList<Card> createHand = new ArrayList<>(5);
        createHand.add(card1);
        createHand.add(card2);
        createHand.add(card3);
        createHand.add(card4);
        createHand.add(card5);
        // PokerHand hand = new PokerHand(createHand);  // ITS TAKING POKER HAND SHIT RN, NEEDS TO BE STUDHAND
        CommunityCardSet theCardSet = new CommunityCardSet(createHand);
        return theCardSet;
    }

    private static ArrayList<Card> helperToMakeStudPokerHand (Card card1, Card card2){
        ArrayList<Card> createHand = new ArrayList<>(2);
        createHand.add(card1);
        createHand.add(card2);
        return createHand;
    }

    private static void testHighPairHighPairvsHighPairLowPair(){
        String msg = "test comparison of two hands of type 2-pair. my hand beats other hand on the second pair. " +
                "(10,10,7,7 vs, 7,7,7,7)";
        Card cCard1 = new Card(7, C);
        Card cCard2 = new Card(7, D);
        Card cCard3 = new Card(7, S);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, S);
        Card myCard2 = new Card(10, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(2, D);
        Card otherCard2 = new Card(4, C);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testStringMethod(){
        String msg = "test toString method for a singular hand";
        Card cCard1 = new Card(7, C);
        Card cCard2 = new Card(7, D);
        Card cCard3 = new Card(7, S);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, S);
        Card myCard2 = new Card(10, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        String actual = myStudPokerHand.toString();
        String expected = "(10 of Spades) (10 of Hearts) ";
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testAddMethodWhenHandEmpty(){
        String msg = "test the add method when the hand is empty";
        Card cCard1 = new Card(7, C);
        Card cCard2 = new Card(7, D);
        Card cCard3 = new Card(7, S);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card card1 = new Card(4, D);
        Card card2 = new Card(13, C);
        ArrayList<Card> myHand = new ArrayList<Card>(2); // empty list
        String beforeAddExpected = "[]";
        String beforeAddActual = myHand.toString();
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        myStudPokerHand.addCard(card1);
        myStudPokerHand.addCard(card2);
        Card firstAddedCard = myStudPokerHand.get_ith_card(0);
        Card secondAddedCard = myStudPokerHand.get_ith_card(1);
        String actualSuit1 = firstAddedCard.getSuit();
        String expectedSuit1 = "Diamonds";
        int actualRank1 = firstAddedCard.getRank();
        int expectedRank1 = 4;
        String actualSuit2 = secondAddedCard.getSuit();
        String expectedSuit2 = "Clubs";
        int actualRank2 = secondAddedCard.getRank();
        int expectedRank2 = 13;
        Testing.assertEquals(msg, beforeAddExpected, beforeAddActual);
        Testing.assertEquals(msg, expectedRank1, actualRank1);
        Testing.assertEquals(msg, expectedSuit1, actualSuit1);
        Testing.assertEquals(msg, expectedRank2, actualRank2);
        Testing.assertEquals(msg, expectedSuit2, actualSuit2);
    }

    private static void testAddMethodWhenHandFull(){
        String msg = "test add method for a hand that is already full";
        Card cCard1 = new Card(7, C);
        Card cCard2 = new Card(7, D);
        Card cCard3 = new Card(7, S);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card card1 = new Card(4, D);
        Card card2 = new Card(13, C);
        Card card3 = new Card(5,H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(card1,card2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        myStudPokerHand.addCard(card3);
        Card actualAddedCard = myStudPokerHand.get_ith_card(2);
        Card expectedAddedCard = null;
        Testing.assertEquals(msg, expectedAddedCard, actualAddedCard);
    }

    private static void testGetIthCardOfFullHand(){
        String msg = "test the GetIth method for StudPokerHand where hand is (10 of Spades, 3 of Hearts)";
        Card cCard1 = new Card(7, C);
        Card cCard2 = new Card(7, D);
        Card cCard3 = new Card(7, S);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, S);
        Card myCard2 = new Card(3, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        Card firstCard = myStudPokerHand.get_ith_card(0);
        Card secondCard = myStudPokerHand.get_ith_card(1);
        int actualRankOfFirst = firstCard.getRank();
        int expectedRankOfFirst = 10;
        String actualSuitOfFirst = firstCard.getSuit();
        String expectedSuitOfFirst = "Spades";
        int actualRankOfSecond = secondCard.getRank();
        int expectedRankOfSecond = 3;
        String actualSuitOfSecond = secondCard.getSuit();
        String expectedSuitOfSecond = "Hearts";
        Testing.assertEquals(msg, expectedRankOfFirst, actualRankOfFirst);
        Testing.assertEquals(msg, expectedRankOfSecond, actualRankOfSecond);
        Testing.assertEquals(msg, expectedSuitOfFirst, actualSuitOfFirst);
        Testing.assertEquals(msg, expectedSuitOfSecond, actualSuitOfSecond);
    }

    private static void testFlushVsTwoPair(){
        String msg = "test flush hand vs two pair hand";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(2, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, H);
        Card myCard2 = new Card(6, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(14, D);
        Card otherCard2 = new Card(14, C);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testFlushVsPair(){
        String msg = "test flush hand vs pair hand";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(2, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, H);
        Card myCard2 = new Card(6, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, D);
        Card otherCard2 = new Card(14, C);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testFlushVsHighCard(){
        String msg = "test flush hand vs high card hand";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(1, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, H);
        Card myCard2 = new Card(6, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, D);
        Card otherCard2 = new Card(14, C);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testTwoPairVsFlush(){
        String msg = "test two pair hand vs flush";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(2, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(14, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testPairVsFlush(){
        String msg = "test pair hand vs flush hand";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(2, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(9, C);
        Card myCard2 = new Card(10, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(14, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighCardVsFlush(){
        String msg = "test high card hand vs flush hand";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(1, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(6, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(14, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighCardVsFlushPt2(){
        String msg = "test high card vs flush hand (other compared to my)";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(1, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(6, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(14, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 3;
        int actual = otherStudPokerHand.compareTo(myStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighCardVsLowCard(){
        String msg = "test two high card hands: high card of p1 is" +
                "higher than p2";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(1, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(6, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(9, H);
        Card otherCard2 = new Card(8, D);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testLowCardVsHighCard(){
        String msg = "test two high card hands: high card of p1 is" +
                "lower than p2";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(1, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(7, C);
        Card myCard2 = new Card(6, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(14, H);
        Card otherCard2 = new Card(8, D);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -7;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighHighVsHighLow(){
        String msg = "test two high card hands: high card's are the" +
                " same. second high card of p1 is higher than p2 " +
                "(13,12 vs. 13,11)";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(1, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(11, D);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighLowVsHighHigh(){
        String msg = "test two high card hands: high card's are the" +
                "same. second high card of p1 is lower than p2 " +
                "(13,7 vs. 13,9)";
        Card cCard1 = new Card(2, C);
        Card cCard2 = new Card(1, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(7, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, D);
        Card otherCard2 = new Card(9, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test3HighVs2High1Low(){
        String msg = "test two high card hands: first 2 high card's" +
                "are the same. third high card of p1 is higher than p2 " +
                "((13,12,11 vs. 13,12,6)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(11, C);
        Card myCard2 = new Card(7, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(6, H);
        Card otherCard2 = new Card(2, D);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 5;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test2High1LowVs3High(){
        String msg = "test two high card hands: first 2 high card's" +
                "are the same. third high card of p1 is lower than p2 " +
                "(13,12,8 vs. 13,12,10)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(3, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(8, C);
        Card myCard2 = new Card(7, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(10, C);
        Card otherCard2 = new Card(2, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test4HighVs3High1Low(){
        String msg = "test two high card hands: first 3 high card's" +
                "are the same. fourth high card of p1 is higher than p2 " +
                "(13,12,11,10 vs. 13,12,11,7)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(11, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(7, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(7, H);
        Card otherCard2 = new Card(2, C);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test3High1LowVs4High(){
        String msg = "test two high card hands: first 3 high card's" +
                "are the same. fourth high card of p1 is lower than p2 " +
                "(13,12,11,6 vs. 13,12,11,10)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(11, H);
        Card cCard4 = new Card(4, H);
        Card cCard5 = new Card(3, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(6, C);
        Card myCard2 = new Card(5, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(10, H);
        Card otherCard2 = new Card(2, C);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -4;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test5HighVs4High1Low(){
        String msg = "test two high card hands: first 4 high card's" +
                " are the same. fifth high card of p1 is higher than p2 " +
                "(13,12,11,10,9 vs. 13,12,11,10,6)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(11, H);
        Card cCard4 = new Card(10, H);
        Card cCard5 = new Card(3, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(9, C);
        Card myCard2 = new Card(5, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(6, H);
        Card otherCard2 = new Card(2, D);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test4High1LowVs5High(){
        String msg = "test two high card hands: first 4 high card's" +
                " are the same. fifth high card of p1 is lower than p2 " +
                "(13,12,11,10,4 vs. 13,12,11,10,6)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(11, H);
        Card cCard4 = new Card(10, H);
        Card cCard5 = new Card(3, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(4, C);
        Card myCard2 = new Card(2, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(6, C);
        Card otherCard2 = new Card(4, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSameExactHighCard(){
        String msg = "\"test two high card hands where every rank is the same" +
                "(13,12,11,10,6 vs. 13,12,11,10,6)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(11, H);
        Card cCard4 = new Card(10, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(4, C);
        Card myCard2 = new Card(2, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(5, H);
        Card otherCard2 = new Card(4, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 0;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighPairVsLowPair(){
        String msg = "test two hands of type pair: p1 hand pair value" +
                "higher than p2 (13,13 vs 8,8)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(11, H);
        Card cCard4 = new Card(10, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(2, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(8, H);
        Card otherCard2 = new Card(8, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 5;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testLowPairVsHighPair(){
        String msg = "test two hands of type pair: p1 hand pair value" +
                "lower than p2 (5,5 vs 10,10)";
        Card cCard1 = new Card(13, C);
        Card cCard2 = new Card(12, D);
        Card cCard3 = new Card(11, H);
        Card cCard4 = new Card(10, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(5, C);
        Card myCard2 = new Card(5, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(10, H);
        Card otherCard2 = new Card(8, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -5;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSamePairHighVsLow(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, high card of p1 is higher than p2 (10,10,8 vs 10,10,7)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(2, H);
        Card cCard4 = new Card(3, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(8, C);
        Card myCard2 = new Card(6, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(7, H);
        Card otherCard2 = new Card(5, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSamePairLowVsHigh(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, high card of p1 is lower than p2 (10,10,6 vs 10,10,9)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(2, H);
        Card cCard4 = new Card(3, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(5, C);
        Card myCard2 = new Card(6, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(9, H);
        Card otherCard2 = new Card(5, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair2HighVs1High1Low(){
        String msg = "\"test two hands of type pair: pair value is the" +
                "same, 1st high card is same. 2nd high card of p1 is" +
                "higher than p2 (10,10,9,6 vs 10,10,9,5)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(2, H);
        Card cCard4 = new Card(3, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(9, C);
        Card myCard2 = new Card(6, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(9, H);
        Card otherCard2 = new Card(5, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair1High1LowVs2High(){
        String msg = "\"test two hands of type pair: pair value is the" +
                "same, 1st high card is same. 2nd high card of p1 is" +
                "lower than p2 (10,10,9,5 vs 10,10,9,8)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(2, H);
        Card cCard4 = new Card(3, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(9, C);
        Card myCard2 = new Card(5, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(9, H);
        Card otherCard2 = new Card(8, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair3HighVs2High1Low(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, 1st and 2nd high card is same. 3rd high card of p1 is" +
                "higher than p2 (10,10,9,8,7 vs 10,10,9,8,5)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(9, H);
        Card cCard4 = new Card(8, H);
        Card cCard5 = new Card(4, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(7, C);
        Card myCard2 = new Card(5, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(5, H);
        Card otherCard2 = new Card(2, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair2High1LowVs3High(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, 1st and 2nd high card is same. 3rd high card of p1 is" +
                "lower than p2 (10,10,9,8,4 vs 10,10,9,8,5)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(9, H);
        Card cCard4 = new Card(8, H);
        Card cCard5 = new Card(2, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(4, C);
        Card myCard2 = new Card(3, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(5, H);
        Card otherCard2 = new Card(3, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSamePairSameHighCard(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, all 3 high cards are the same. (10,10,9,8,5 vs 10,10,9,8,5)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(9, H);
        Card cCard4 = new Card(8, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(4, C);
        Card myCard2 = new Card(3, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(2, H);
        Card otherCard2 = new Card(3, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 0;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testHighPairHighPairVsLowPairLowPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is higher than p2 (10,10 vs 8,8)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(9, D);
        Card cCard3 = new Card(8, H);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(3, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(8, H);
        Card otherCard2 = new Card(3, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testLowPairLowPairVsHighPairHighPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is lower than p2 (10,10 vs 14,14)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(9, D);
        Card cCard3 = new Card(8, H);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(3, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(14, H);
        Card otherCard2 = new Card(14, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -4;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testHighPairHighPairVsHighPairLowPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is same as p2. next pair of p1 is higher than p2" +
                "(8,8,7,7 vs 8,8,5,5)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(9, D);
        Card cCard3 = new Card(8, H);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(8, C);
        Card myCard2 = new Card(7, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(8, H);
        Card otherCard2 = new Card(5, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testHighPairLowPairVsHighPairHighPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is same as p2. next pair of p1 is lower than p2" +
                "(8,8,4,4 vs 8,8,5,5)";
        Card cCard1 = new Card(4, C);
        Card cCard2 = new Card(9, D);
        Card cCard3 = new Card(8, H);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(8, C);
        Card myCard2 = new Card(4, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(8, H);
        Card otherCard2 = new Card(5, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameTwoPairHighCardLowCard(){
        String msg = "test two hands of type two pair: both pairs are" +
                " of the same ranks. high card of p1 is higher than p2 " +
                "(10,10,5,5,14 vs 10,10,5,5,10)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(8, H);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(5, C);
        Card myCard2 = new Card(14, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(5, H);
        Card otherCard2 = new Card(10, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 4;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameTwoPairLowCardHighCard(){
        String msg = "test two hands of type two pair: both pairs are" +
                " of the same ranks. high card of p1 is lower than p2 " +
                "(10,10,5,5,9 vs 10,10,5,5,13)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(8, H);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(5, C);
        Card myCard2 = new Card(9, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(5, H);
        Card otherCard2 = new Card(13, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -4;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameTwoPairSameHighCard(){
        String msg = "test two hands of type two pair: both pairs are" +
                " of the same ranks. high cards are the same" +
                "(10,10,5,5,13 vs 10,10,5,5,13)";
        Card cCard1 = new Card(10, C);
        Card cCard2 = new Card(10, D);
        Card cCard3 = new Card(8, H);
        Card cCard4 = new Card(7, H);
        Card cCard5 = new Card(5, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(5, C);
        Card myCard2 = new Card(13, S);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(5, H);
        Card otherCard2 = new Card(13, S);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 0;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlushHighCardVsLowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in p1's hand is higher than p2 (D: 11 vs C: 10)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(5, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(11, H);
        Card myCard2 = new Card(7, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(10, H);
        Card otherCard2 = new Card(8, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlushLowCardVsHighCard(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in p1's hand is lower than p2 (D: 10 vs C: 14)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(5, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(10, H);
        Card myCard2 = new Card(7, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(14, H);
        Card otherCard2 = new Card(8, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -4;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush2HighCardsVs1HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in hands are same. second high card in p1 hand)" +
                " is higher than in p2 (D: 14,12 vs C: 14,9)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(5, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(14, H);
        Card myCard2 = new Card(12, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(14, H);
        Card otherCard2 = new Card(9, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush1HighCard1LowCardVs2HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in hands are same. second high card in p1 hand)" +
                " is lower than in p2 (D: 14,9 vs C: 14,11)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(5, H);
        Card cCard5 = new Card(6, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(14, H);
        Card myCard2 = new Card(9, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(14, H);
        Card otherCard2 = new Card(11, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush3HighCardsVs2HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "first 2 high cards in hands are same. third high card in p1 hand)" +
                " is higher than in p2 (D: 14,13,12 vs C: 14,13,8)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(5, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(13, H);
        Card myCard2 = new Card(12, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(8, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 4;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush2HighCard1LowCardVs3HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "first 2 high cards in hands are same. third high card in p1 hand)" +
                " is lower than in p2 (D: 14,13,8 vs C: 14,13,11)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(5, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(13, H);
        Card myCard2 = new Card(8, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(11, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -3;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush4HighCardsVs3HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "first 3 high cards in hands are same. fourth high card in p1 hand)" +
                " is higher than in p2 (D: 14,13,12,11 vs C: 14,13,12,7)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(13, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(12, H);
        Card myCard2 = new Card(11, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(12, H);
        Card otherCard2 = new Card(7, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 4;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush3HighCard1LowCardVs4HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "first 3 high cards in hands are same. third high card in p1 hand)" +
                " is lower than in p2 (D: 14,13,12,6 vs C: 14,13,12,7)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(4, H);
        Card cCard4 = new Card(13, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(12, H);
        Card myCard2 = new Card(6, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(12, H);
        Card otherCard2 = new Card(7, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush5HighCardsVs4HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "first 4 high cards in hands are same. fifth high card in p1 hand)" +
                " is higher than in p2 (D: 14,13,12,11,10 vs C: 14,13,12,11,8)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(12, H);
        Card cCard4 = new Card(13, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(11, H);
        Card myCard2 = new Card(10, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(11, H);
        Card otherCard2 = new Card(8, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 2;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush4HighCard1LowCardVs5HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "first 4 high cards in hands are same. third high card in p1 hand)" +
                " is lower than in p2 (D: 14,13,12,11,6 vs C: 14,13,12,11,7)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(12, H);
        Card cCard4 = new Card(13, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(11, H);
        Card myCard2 = new Card(6, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(11, H);
        Card otherCard2 = new Card(7, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -1;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameExactFlush(){
        String msg = "test two hands of type flush: all ranks of each hand are" +
                " the same. (D: 14,13,12,11,6 vs C: 14,13,12,11,6)";
        Card cCard1 = new Card(2, H);
        Card cCard2 = new Card(3, H);
        Card cCard3 = new Card(12, H);
        Card cCard4 = new Card(13, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(11, H);
        Card myCard2 = new Card(6, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(11, H);
        Card otherCard2 = new Card(6, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = 0;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  test4OfAKindVsPair(){
        String msg = "compare four of a kind hand to pair hand" +
                " (3,3,3,3,6 vs. 13,13,12,8,6)";
        Card cCard1 = new Card(3, S);
        Card cCard2 = new Card(3, C);
        Card cCard3 = new Card(12, D);
        Card cCard4 = new Card(13, H);
        Card cCard5 = new Card(14, H);
        CommunityCardSet theCardSet = helperToMakeCommunityCards(cCard1, cCard2, cCard3, cCard4, cCard5);
        Card myCard1 = new Card(3, H);
        Card myCard2 = new Card(3, H);
        ArrayList<Card> myHand = helperToMakeStudPokerHand(myCard1, myCard2);
        Card otherCard1 = new Card(13, H);
        Card otherCard2 = new Card(6, H);
        ArrayList<Card> otherHand = helperToMakeStudPokerHand(otherCard1, otherCard2);
        StudPokerHand myStudPokerHand = new StudPokerHand(theCardSet, myHand);
        StudPokerHand otherStudPokerHand = new StudPokerHand(theCardSet, otherHand);
        int expected = -10;
        int actual = myStudPokerHand.compareTo(otherStudPokerHand);
        Testing.assertEquals(msg, expected, actual);
    }
}