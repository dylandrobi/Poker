package proj4;

public class CardTester {

    public static void main(String[] args) {
        Testing.startTests();
        testString2ofHearts();
        testStringJackofSpades();
        testStringKingofHearts();
        testStringAceofDiamonds();
        testGetRankof2ofClubs();
        testGetRankofJackofHearts();
        testGetSuitof6ofDiamonds();
        testGetSuitofAceofHearts();
        testGetSuitofStrAceofStrHearts();
        testGetSuitofStr5ofStrDiamonds();
        testGetRankofStr3ofStrDiamonds();
        testGetSuitofInt5ofIntSpades();
        testGetRankofInt5ofIntSpades();
        testGetterofStr10ofStrClubs();
        // testDefaultCardCase();
        Testing.finishTests();
    }

    private static void testString2ofHearts(){
        String msg = "Test the print of a 2 of Hearts";
        String expected = "2 of Hearts";
        Card myCard = new Card(2, "Hearts");
        String actual = "" + myCard;
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testStringJackofSpades(){
        String msg = "Test the print of a Jack of Spades";
        String expected = "Jack of Spades";
        Card myCard = new Card(11, "Spades");
        String actual = "" + myCard;
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testStringKingofHearts(){
        String msg = "Test the print of a King of Hearts";
        String expected = "King of Hearts";
        Card myCard = new Card(13, "Hearts");
        String actual = "" + myCard;
        Testing.assertEquals(msg, expected, actual);
    }
    private static void testStringAceofDiamonds(){
        String msg = "Test the print of an Ace of Diamonds";
        String expected = "Ace of Diamonds";
        Card myCard = new Card(14, "Diamonds");
        String actual = "" + myCard;
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetRankof2ofClubs(){
        String msg = "Test the get method of Card for a 2 of Clubs";
        int expected = 2;
        Card myCard = new Card(2, "Clubs");
        int actual = myCard.getRank();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetRankofJackofHearts(){
        String msg = "Test the get method of Card for a Jack of Hearts";
        int expected = 11;
        Card myCard = new Card(11, "Hearts");
        int actual = myCard.getRank();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetSuitof6ofDiamonds(){
        String msg = "Test the get method of Card for a 6 of Diamonds";
        String expected = "Diamonds";
        Card myCard = new Card(6, "Diamonds");
        String actual = myCard.getSuit();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetSuitofAceofHearts(){
        String msg = "Test the get method of Card for an ace of Hearts";
        String expected = "Hearts";
        Card myCard = new Card(14, "Hearts");
        String actual = myCard.getSuit();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetSuitofStrAceofStrHearts() {
        String msg = "Test the get method of Card for an Ace of Hearts, where rank and suit are both strings with " +
                "random capitalized letters throughout: aCe, heArTS";
        String expected = "Hearts";
        Card myCard = new Card("aCe", "heArTS");
        String actual = myCard.getSuit();
        Testing.assertEquals(msg, expected, actual);
    }
    private static void testGetSuitofStr5ofStrDiamonds() {
        String msg = "Test the get method of Card for an Ace of Hearts, where rank and suit are both strings with " +
                "random capitalized letters throughout: fIVE, dIamOnDS";
        String expected = "Diamonds";
        Card myCard = new Card("fIVE", "dIamOnDS");
        String actual = myCard.getSuit();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetterofStr10ofStrClubs() {
        String msg = "Test the get method of Card for an Ten of Clubs, where rank and suit are both strings with " +
                ": Ten, Clubs";
        int expected = 10;
        String expected2 = "Clubs";
        Card myCard = new Card("10", "Clubs");
        int actual = myCard.getRank();
        String actual2 = myCard.getSuit();
        Testing.assertEquals(msg, expected, actual);
        Testing.assertEquals(msg, expected2, actual2);
    }

    private static void testGetRankofStr3ofStrDiamonds() {
        String msg = "Test the get method of Card for an Ace of Hearts, where rank and suit are both strings with " +
                "random capitalized letters throughout: tHRee, dIamOnDS";
        int expected = 3;
        Card myCard = new Card("tHRee", "dIamOnDS");
        int actual = myCard.getRank();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetSuitofInt5ofIntSpades() {
        String msg = "Test the get suit method of Card for an Ace of Hearts, where rank and suit are integers. Rank = 5, " +
                "Suit = 0 (Spades)";
        String expected = "Spades";
        Card myCard = new Card(5, 0);
        String actual = myCard.getSuit();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testGetRankofInt5ofIntSpades() {
        String msg = "Test the get suit method of Card for an Ace of Hearts, where rank and suit are integers. Rank = " +
                "11 (Jack), Suit = 1 (Hearts)";
        int expected = 11;
        Card myCard = new Card(11, 1);
        int actual = myCard.getRank();
        Testing.assertEquals(msg, expected, actual);
    }

//    private static void testDefaultCardCase(){
//        String msg = "Test what happens when invalid parameters are put into Card creation. Ex (Axe of Clades). When" +
//                "this occurs, default to Ace of Spades";
//        Card defaultCard = new Card("Axe", "Clades");
//        int actualRank = defaultCard.getRank();
//        String actualSuit = defaultCard.getSuit();
//        int expectedRank = 14;
//        String expectedSuit = "Spades";
//        Testing.assertEquals(msg, expectedRank, actualRank);
//        Testing.assertEquals(msg, expectedSuit, actualSuit);
//
//    }
}