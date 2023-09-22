package proj4;

import java.util.ArrayList;

public class PokerComparisonTests {

    private static String D = "Diamonds";
    private static String S = "Spades";
    private static String C = "Clubs";
    private static String H = "Hearts";


    public static void main(String[] args) {
        Testing.startTests();
        testFlushVsTwoPair();
        testFlushVsPair();
        testFlushVsHighCard();
        testTwoPairVsFlush();
        testPairVsFlush();
        testHighCardVsFlush();
        testHighCardVsFlushPt2();
        testHighCardVsLowCard();
        testLowCardVsHighCard();
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
        test4OfAKindHighVsLow();
        test4OfAKindLowVsHigh();
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
        testTwo1PairHandsTied();
        Testing.finishTests();
    }
        private static PokerHand helperToMakeHand(Card card1, Card card2, Card card3, Card card4, Card card5){
                ArrayList<Card> createHand = new ArrayList<>(5);
                createHand.add(card1);
                createHand.add(card2);
                createHand.add(card3);
                createHand.add(card4);
                createHand.add(card5);
                PokerHand hand = new PokerHand(createHand);
                return hand;
        }

    private static void testFlushVsTwoPair(){
        String msg = "test flush hand vs two pair hand";
        Card myCard1 = new Card(5, D);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, C);
        Card otherCard2 = new Card(5, S);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(9, H);
        Card otherCard5 = new Card(7, S);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testFlushVsPair(){
        String msg = "test flush hand vs pair hand";
        Card myCard1 = new Card(5, D);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, C);
        Card otherCard2 = new Card(5, S);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(6, H);
        Card otherCard5 = new Card(7, S);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testFlushVsHighCard(){
        String msg = "test flush hand vs high card hand";
        Card myCard1 = new Card(5, D);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, C);
        Card otherCard2 = new Card(2, S);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(10, H);
        Card otherCard5 = new Card(7, S);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testTwoPairVsFlush(){
        String msg = "test two pair hand vs flush";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(9, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(2, S);
        Card otherCard3 = new Card(9, S);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(7, S);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testPairVsFlush(){
        String msg = "test pair hand vs flush hand";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(2, S);
        Card otherCard3 = new Card(9, S);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(7, S);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighCardVsFlush(){
        String msg = "test high card hand vs flush hand";
        Card myCard1 = new Card(14, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(2, S);
        Card otherCard3 = new Card(9, S);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(7, S);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighCardVsFlushPt2(){
        String msg = "test high card vs flush hand (other compared to my)";
        Card myCard1 = new Card(14, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(2, S);
        Card otherCard3 = new Card(9, S);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(7, S);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 3;
        int actual = otherHand.compareTo(myHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighCardVsLowCard(){
        String msg = "test two high card hands: high card of p1 is" +
                "higher than p2";
        Card myCard1 = new Card(14, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(2, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(11, S);
        Card otherCard5 = new Card(7, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testLowCardVsHighCard(){
        String msg = "test two high card hands: high card of p1 is" +
                "lower than p2";
        Card myCard1 = new Card(3, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(2, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(11, S);
        Card otherCard5 = new Card(7, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighHighVsHighLow(){
        String msg = "test two high card hands: high card's are the" +
                " same. second high card of p1 is higher than p2 " +
                "(13,12 vs. 13,11)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(4, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(9, H);
        Card otherCard3 = new Card(8, D);
        Card otherCard4 = new Card(11, S);
        Card otherCard5 = new Card(7, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighLowVsHighHigh(){
        String msg = "test two high card hands: high card's are the" +
                "same. second high card of p1 is lower than p2 " +
                "(13,7 vs. 13,9)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(5, D);
        Card myCard3 = new Card(4, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(9, H);
        Card otherCard3 = new Card(6, D);
        Card otherCard4 = new Card(8, S);
        Card otherCard5 = new Card(7, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test3HighVs2High1Low(){
        String msg = "test two high card hands: first 2 high card's" +
                "are the same. third high card of p1 is higher than p2 " +
                "((13,12,11 vs. 13,12,6)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(12, H);
        Card otherCard3 = new Card(6, D);
        Card otherCard4 = new Card(5, S);
        Card otherCard5 = new Card(4, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 5;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test2High1LowVs3High(){
        String msg = "test two high card hands: first 2 high card's" +
                "are the same. third high card of p1 is lower than p2 " +
                "(13,12,4 vs. 13,12,6)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(4, C);
        Card myCard4 = new Card(2, D);
        Card myCard5 = new Card(3, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(12, H);
        Card otherCard3 = new Card(6, D);
        Card otherCard4 = new Card(5, S);
        Card otherCard5 = new Card(4, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test4HighVs3High1Low(){
        String msg = "test two high card hands: first 3 high card's" +
                "are the same. fourth high card of p1 is higher than p2 " +
                "(13,12,11,10 vs. 13,12,11,7)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(3, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(12, H);
        Card otherCard3 = new Card(11, D);
        Card otherCard4 = new Card(7, S);
        Card otherCard5 = new Card(4, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test3High1LowVs4High(){
        String msg = "test two high card hands: first 3 high card's" +
                "are the same. fourth high card of p1 is lower than p2 " +
                "(13,12,11,4 vs. 13,12,11,7)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(4, D);
        Card myCard5 = new Card(3, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(12, H);
        Card otherCard3 = new Card(11, D);
        Card otherCard4 = new Card(7, S);
        Card otherCard5 = new Card(4, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test5HighVs4High1Low(){
        String msg = "test two high card hands: first 4 high card's" +
                " are the same. fifth high card of p1 is higher than p2 " +
                "(13,12,11,10,9 vs. 13,12,11,10,6)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(9, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(12, H);
        Card otherCard3 = new Card(11, D);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(6, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void test4High1LowVs5High(){
        String msg = "test two high card hands: first 4 high card's" +
                " are the same. fifth high card of p1 is lower than p2 " +
                "(13,12,11,10,4 vs. 13,12,11,10,6)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(4, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(12, H);
        Card otherCard3 = new Card(11, D);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(6, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSameExactHighCard(){
        String msg = "\"test two high card hands where every rank is the same" +
                "(13,12,11,10,6 vs. 13,12,11,10,6)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(6, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, S);
        Card otherCard2 = new Card(12, H);
        Card otherCard3 = new Card(11, D);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(6, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 0;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testHighPairVsLowPair(){
        String msg = "test two hands of type pair: p1 hand pair value" +
                "higher than p2 (13,13 vs 8,8)";
        Card myCard1 = new Card(13, C);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(6, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(8, S);
        Card otherCard2 = new Card(8, H);
        Card otherCard3 = new Card(11, D);
        Card otherCard4 = new Card(10, S);
        Card otherCard5 = new Card(6, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 5;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testLowPairVsHighPair(){
        String msg = "test two hands of type pair: p1 hand pair value" +
                "lower than p2 (5,5 vs 10,10)";
        Card myCard1 = new Card(5, C);
        Card myCard2 = new Card(5, D);
        Card myCard3 = new Card(11, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(6, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(11, D);
        Card otherCard4 = new Card(3, S);
        Card otherCard5 = new Card(6, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -5;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSamePairHighVsLow(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, high card of p1 is higher than p2 (10,10,8 vs 10,10,4)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(8, C);
        Card myCard4 = new Card(5, D);
        Card myCard5 = new Card(6, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(4, D);
        Card otherCard4 = new Card(3, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 4;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSamePairLowVsHigh(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, high card of p1 is lower than p2 (10,10,6 vs 10,10,9)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(3, C);
        Card myCard4 = new Card(5, D);
        Card myCard5 = new Card(6, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(3, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair2HighVs1High1Low(){
        String msg = "\"test two hands of type pair: pair value is the" +
                "same, 1st high card is same. 2nd high card of p1 is" +
                "higher than p2 (10,10,9,6 vs 10,10,9,4)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(5, D);
        Card myCard5 = new Card(6, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(4, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair1High1LowVs2High(){
        String msg = "\"test two hands of type pair: pair value is the" +
                "same, 1st high card is same. 2nd high card of p1 is" +
                "lower than p2 (10,10,9,5 vs 10,10,9,8)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(5, D);
        Card myCard5 = new Card(3, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(8, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair3HighVs2High1Low(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, 1st and 2nd high card is same. 3rd high card of p1 is" +
                "higher than p2 (10,10,9,8,7 vs 10,10,9,8,3)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(8, S);
        Card otherCard5 = new Card(3, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 4;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSamePair2High1LowVs3High(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, 1st and 2nd high card is same. 3rd high card of p1 is" +
                "lower than p2 (10,10,9,8,2 vs 10,10,9,8,5)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(2, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(8, S);
        Card otherCard5 = new Card(5, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testSamePairSameHighCard(){
        String msg = "test two hands of type pair: pair value is the" +
                "same, all 3 high cards are the same. (10,10,9,8,5 vs 10,10,9,8,5)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, C);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(5, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(8, S);
        Card otherCard5 = new Card(5, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 0;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testHighPairHighPairVsLowPairLowPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is higher than p2 (10,10 vs 8,8)";
        Card myCard1 = new Card(12, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(10, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(5, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(5, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(9, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testLowPairLowPairVsHighPairHighPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is lower than p2 (10,10 vs 14,14)";
        Card myCard1 = new Card(12, C);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(10, C);
        Card myCard4 = new Card(10, D);
        Card myCard5 = new Card(5, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, S);
        Card otherCard2 = new Card(14, H);
        Card otherCard3 = new Card(9, D);
        Card otherCard4 = new Card(9, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testHighPairHighPairVsHighPairLowPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is same as p2. next pair of p1 is higher than p2" +
                "(8,8,7,7 vs 8,8,5,5)";
        Card myCard1 = new Card(8, C);
        Card myCard2 = new Card(8, D);
        Card myCard3 = new Card(7, C);
        Card myCard4 = new Card(7, D);
        Card myCard5 = new Card(5, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(5, H);
        Card otherCard3 = new Card(8, D);
        Card otherCard4 = new Card(8, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testHighPairLowPairVsHighPairHighPair(){
        String msg = "test two hands of type two pair: higher pair" +
                "value of p1 is same as p2. next pair of p1 is lower than p2" +
                "(8,8,4,4 vs 8,8,5,5)";
        Card myCard1 = new Card(8, C);
        Card myCard2 = new Card(8, D);
        Card myCard3 = new Card(4, C);
        Card myCard4 = new Card(4, D);
        Card myCard5 = new Card(5, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(5, H);
        Card otherCard3 = new Card(8, D);
        Card otherCard4 = new Card(8, S);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameTwoPairHighCardLowCard(){
        String msg = "test two hands of type two pair: both pairs are" +
                " of the same ranks. high card of p1 is higher than p2 " +
                "(10,10,5,5,14 vs 10,10,5,5,3)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(5, C);
        Card myCard4 = new Card(5, D);
        Card myCard5 = new Card(14, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(5, D);
        Card otherCard4 = new Card(5, S);
        Card otherCard5 = new Card(3, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 11;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameTwoPairLowCardHighCard(){
        String msg = "test two hands of type two pair: both pairs are" +
                " of the same ranks. high card of p1 is lower than p2 " +
                "(10,10,5,5,2 vs 10,10,5,5,13)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(5, C);
        Card myCard4 = new Card(5, D);
        Card myCard5 = new Card(2, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(5, D);
        Card otherCard4 = new Card(5, S);
        Card otherCard5 = new Card(13, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -11;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameTwoPairSameHighCard(){
        String msg = "test two hands of type two pair: both pairs are" +
                " of the same ranks. high cards are the same" +
                "(10,10,5,5,13 vs 10,10,5,5,13)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(5, C);
        Card myCard4 = new Card(5, D);
        Card myCard5 = new Card(13, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, S);
        Card otherCard2 = new Card(10, H);
        Card otherCard3 = new Card(5, D);
        Card otherCard4 = new Card(5, S);
        Card otherCard5 = new Card(13, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 0;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  test4OfAKindHighVsLow(){
        String msg = "test two hands of type four-of-a-kind: rank of" +
                " four-of-a-kind in p1's hand is higher than p2 " +
                "(10,10,10,10 vs 5,5,5,5)";
        Card myCard1 = new Card(10, C);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(10, S);
        Card myCard4 = new Card(10, H);
        Card myCard5 = new Card(13, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(5, H);
        Card otherCard3 = new Card(5, D);
        Card otherCard4 = new Card(5, C);
        Card otherCard5 = new Card(13, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 5;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  test4OfAKindLowVsHigh(){
        String msg = "test two hands of type four-of-a-kind: rank of" +
                " four-of-a-kind in p1's hand is lower than p2 " +
                "(2,2,2,2 vs 5,5,5,5)";
        Card myCard1 = new Card(2, C);
        Card myCard2 = new Card(2, D);
        Card myCard3 = new Card(2, S);
        Card myCard4 = new Card(2, H);
        Card myCard5 = new Card(13, H);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(5, S);
        Card otherCard2 = new Card(5, H);
        Card otherCard3 = new Card(5, D);
        Card otherCard4 = new Card(5, C);
        Card otherCard5 = new Card(13, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlushHighCardVsLowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in p1's hand is higher than p2 (D: 11 vs C: 10)";
        Card myCard1 = new Card(11, D);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(10, C);
        Card otherCard2 = new Card(5, C);
        Card otherCard3 = new Card(4, C);
        Card otherCard4 = new Card(3, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlushLowCardVsHighCard(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in p1's hand is lower than p2 (D: 10 vs C: 14)";
        Card myCard1 = new Card(3, D);
        Card myCard2 = new Card(10, D);
        Card myCard3 = new Card(9, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(5, C);
        Card otherCard3 = new Card(4, C);
        Card otherCard4 = new Card(3, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -4;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush2HighCardsVs1HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in hands are same. second high card in p1 hand)" +
                " is higher than in p2 (D: 14,12 vs C: 14,9)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(12, D);
        Card myCard3 = new Card(9, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(9, C);
        Card otherCard3 = new Card(4, C);
        Card otherCard4 = new Card(3, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush1HighCard1LowCardVs2HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "high card in hands are same. second high card in p1 hand)" +
                " is lower than in p2 (D: 14,9 vs C: 14,11)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(3, D);
        Card myCard3 = new Card(9, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(11, C);
        Card otherCard3 = new Card(4, C);
        Card otherCard4 = new Card(3, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -2;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush3HighCardsVs2HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "first 2 high cards in hands are same. third high card in p1 hand)" +
                " is higher than in p2 (D: 14,13,12 vs C: 14,13,8)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(12, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(13, C);
        Card otherCard3 = new Card(8, C);
        Card otherCard4 = new Card(3, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 4;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush2HighCard1LowCardVs3HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "first 2 high cards in hands are same. third high card in p1 hand)" +
                " is lower than in p2 (D: 14,13,8 vs C: 14,13,11)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(3, D);
        Card myCard4 = new Card(8, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(13, C);
        Card otherCard3 = new Card(11, C);
        Card otherCard4 = new Card(3, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -3;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush4HighCardsVs3HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "first 3 high cards in hands are same. fourth high card in p1 hand)" +
                " is higher than in p2 (D: 14,13,12,11 vs C: 14,13,12,7)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(12, D);
        Card myCard4 = new Card(11, D);
        Card myCard5 = new Card(7, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(13, C);
        Card otherCard3 = new Card(12, C);
        Card otherCard4 = new Card(7, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 4;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush3HighCard1LowCardVs4HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "first 3 high cards in hands are same. third high card in p1 hand)" +
                " is lower than in p2 (D: 14,13,12,6 vs C: 14,13,12,7)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(12, D);
        Card myCard4 = new Card(6, D);
        Card myCard5 = new Card(4, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(13, C);
        Card otherCard3 = new Card(12, C);
        Card otherCard4 = new Card(7, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush5HighCardsVs4HighCard1LowCard(){
        String msg = "test two hands of type flush: rank of first " +
                "first 4 high cards in hands are same. fifth high card in p1 hand)" +
                " is higher than in p2 (D: 14,13,12,11,10 vs C: 14,13,12,11,2)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(12, D);
        Card myCard4 = new Card(11, D);
        Card myCard5 = new Card(10, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(13, C);
        Card otherCard3 = new Card(12, C);
        Card otherCard4 = new Card(11, C);
        Card otherCard5 = new Card(2, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 8;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testBothFlush4HighCard1LowCardVs5HighCards(){
        String msg = "test two hands of type flush: rank of first " +
                "first 4 high cards in hands are same. third high card in p1 hand)" +
                " is lower than in p2 (D: 14,13,12,11,6 vs C: 14,13,12,11,7)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(12, D);
        Card myCard4 = new Card(6, D);
        Card myCard5 = new Card(11, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(13, C);
        Card otherCard3 = new Card(12, C);
        Card otherCard4 = new Card(7, C);
        Card otherCard5 = new Card(11, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = -1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  testSameExactFlush(){
        String msg = "test two hands of type flush: all ranks of each hand are" +
                " the same. (D: 14,13,12,11,6 vs C: 14,13,12,11,6)";
        Card myCard1 = new Card(14, D);
        Card myCard2 = new Card(13, D);
        Card myCard3 = new Card(12, D);
        Card myCard4 = new Card(6, D);
        Card myCard5 = new Card(11, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(14, C);
        Card otherCard2 = new Card(13, C);
        Card otherCard3 = new Card(12, C);
        Card otherCard4 = new Card(6, C);
        Card otherCard5 = new Card(11, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 0;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

    private static void  test4OfAKindVsPair(){
        String msg = "compare four of a kind hand to pair hand" +
                " (3,3,3,3,6 vs. 13,13,12,8,6)";
        Card myCard1 = new Card(3, D);
        Card myCard2 = new Card(3, H);
        Card myCard3 = new Card(3, S);
        Card myCard4 = new Card(3, C);
        Card myCard5 = new Card(6, D);
        PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
        Card otherCard1 = new Card(13, C);
        Card otherCard2 = new Card(13, H);
        Card otherCard3 = new Card(12, S);
        Card otherCard4 = new Card(6, D);
        Card otherCard5 = new Card(8, C);
        PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
        int expected = 1;
        int actual = myHand.compareTo(otherHand);
        Testing.assertEquals(msg, expected, actual);
    }

        private static void testTwo1PairHandsTied(){
                String msg = "Compare two hands with 1 pair that is a tie";
                Card myCard1 = new Card(5, D);
                Card myCard2 = new Card(5, H);
                Card myCard3 = new Card(9, S);
                Card myCard4 = new Card(8, D);
                Card myCard5 = new Card(7, C);
                PokerHand myHand = helperToMakeHand(myCard1, myCard2, myCard3, myCard4, myCard5);
                Card otherCard1 = new Card(5, C);
                Card otherCard2 = new Card(5, S);
                Card otherCard3 = new Card(9, D);
                Card otherCard4 = new Card(8, H);
                Card otherCard5 = new Card(7, S);
                PokerHand otherHand = helperToMakeHand(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);
                int expected = 0;
                int actual = myHand.compareTo(otherHand);
                Testing.assertEquals(msg, expected, actual);
        }
    }

