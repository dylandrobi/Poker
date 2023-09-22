package proj4;

public class DeckTester {

    public static void main(String[] args) {
        Testing.startTests();
        testDeckSize52Undealt();
        testDeckSize47Undealt();
        testDeckSizeEmptyDeck();
        testisEmptyDeck1CardLeft();
        testisEmptyDeck0CardsLeft();
        testDeal1Card();
        testDeal3Cards();
        testDealCardWhenDeckEmpty();
        testShuffleNoLostCards();
        testGatherNoLostCards();
        testUnShuffledDeckAsString();
        testRandomnessOfShuffle();
        Testing.finishTests();
    }


    private static void testDeckSize52Undealt() {
        String msg = "Test the size() method for a deck of 52 undealt cards";
        Deck deckOfCards = new Deck();
        int expected = 52;
        int actual = deckOfCards.size();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testDeckSize47Undealt() {
        String msg = "Test the size() method for a deck of 47 undealt cards";
        Deck deckOfCards = new Deck();
        for (int cardsDealt = 0; cardsDealt < 5; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
        }
        int expected = 47;
        int actual = deckOfCards.size();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testDeckSizeEmptyDeck() {
        String msg = "Test the size() method for a deck of 0 undealt cards";
        Deck deckOfCards = new Deck();
        for (int cardsDealt = 0; cardsDealt < 52; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
        }
        int expected = 0;
        int actual = deckOfCards.size();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testisEmptyDeck1CardLeft() {
        String msg = "Test the isEmpty() method for a deck of 1 undealt cards";
        Deck deckOfCards = new Deck();
        for (int cardsDealt = 0; cardsDealt < 51; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
        }
        boolean expected = false;
        boolean actual = deckOfCards.isEmpty();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testisEmptyDeck0CardsLeft() {
        String msg = "Test the isEmpty() method for a deck of 1 undealt cards";
        Deck deckOfCards = new Deck();
        for (int cardsDealt = 0; cardsDealt < 52; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
        }
        boolean expected = true;
        boolean actual = deckOfCards.isEmpty();
        Testing.assertEquals(msg, expected, actual);
    }

    private static void testDeal1Card() {
        String msg = "Test the deal() method by dealing one card";
        Deck deckOfCards = new Deck();
        Card dealtCard = deckOfCards.deal();
        int expectedRank = 2;
        String expectedSuit = "Hearts";
        int actualRank = dealtCard.getRank();
        String actualSuit = dealtCard.getSuit();
        Testing.assertEquals(msg, expectedRank, actualRank);
        Testing.assertEquals(msg, expectedSuit, actualSuit);
    }

    private static void testDeal3Cards() {
        String msg = "Test the deal() method by dealing three cards";
        Deck deckOfCards = new Deck();
        Card dealtCard1 = deckOfCards.deal();
        Card dealtCard2 = deckOfCards.deal();
        Card dealtCard3 = deckOfCards.deal();
        int expectedRank1 = 2;
        String expectedSuit1 = "Hearts";
        int actualRank1 = dealtCard1.getRank();
        String actualSuit1 = dealtCard1.getSuit();
        int expectedRank2 = 3;
        String expectedSuit2 = "Hearts";
        int actualRank2 = dealtCard2.getRank();
        String actualSuit2 = dealtCard2.getSuit();
        int expectedRank3 = 4;
        String expectedSuit3 = "Hearts";
        int actualRank3 = dealtCard3.getRank();
        String actualSuit3 = dealtCard3.getSuit();
        Testing.assertEquals(msg, expectedRank1, actualRank1);
        Testing.assertEquals(msg, expectedSuit1, actualSuit1);
        Testing.assertEquals(msg, expectedRank2, actualRank2);
        Testing.assertEquals(msg, expectedSuit2, actualSuit2);
        Testing.assertEquals(msg, expectedRank3, actualRank3);
        Testing.assertEquals(msg, expectedSuit3, actualSuit3);
    }
    private static void testDealCardWhenDeckEmpty() {
        String msg = "Test the deal() method when the deck is empty";
        Deck deckOfCards = new Deck();
        for (int cardsDealt = 0; cardsDealt < 52; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
        }
        Card actualDealtCardAttempt = deckOfCards.deal();
        Card expectedDealtCardAttempt = null;
        Testing.assertEquals(msg, expectedDealtCardAttempt, actualDealtCardAttempt);
    }

    private static void testShuffleNoLostCards() {
        String msg = "Test the shuffle() method to make sure no cards are lost / repeated in the process";
        Deck deckOfCards = new Deck();
        deckOfCards.shuffle();
        int actualRank2 = 0;
        int actualRank3 = 0;
        int actualRank4 = 0;
        int actualRank5 = 0;
        int actualRank6 = 0;
        int actualRank7 = 0;
        int actualRank8 = 0;
        int actualRank9 = 0;
        int actualRank10 = 0;
        int actualRankJack= 0;
        int actualRankQueen = 0;
        int actualRankKing = 0;
        int actualRankAce = 0;
        int actualDiamonds = 0;
        int actualClubs = 0;
        int actualSpades = 0;
        int actualHearts = 0;
        int expectedDeckSize = 52;
        int actualDeckSize = deckOfCards.size();
        for (int cardsDealt = 0; cardsDealt < 52; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
            int cardRank = dealtCard.getRank();
            String cardSuit = dealtCard.getSuit();
            if (cardRank == 2){
                actualRank2 += 1;
            }
            else if (cardRank == 3){
                actualRank3 += 1;
            }
            else if (cardRank == 4){
                actualRank4 += 1;
            }
            else if (cardRank == 5){
                actualRank5 += 1;
            }
            else if (cardRank == 6){
                actualRank6 += 1;
            }
            else if (cardRank == 7){
                actualRank7 += 1;
            }
            else if (cardRank == 8){
                actualRank8 += 1;
            }
            else if (cardRank == 9){
                actualRank9 += 1;
            }
            else if (cardRank == 10){
                actualRank10 += 1;
            }
            else if (cardRank == 11){
                actualRankJack += 1;
            }
            else if (cardRank == 12){
                actualRankQueen += 1;
            }
            else if (cardRank == 13){
                actualRankKing += 1;
            }
            else if (cardRank == 14){
                actualRankAce += 1;
            }
            if (cardSuit == "Diamonds"){
                actualDiamonds += 1;
            }
            else if (cardSuit == "Spades"){
                actualSpades += 1;
            }
            else if (cardSuit == "Clubs"){
                actualClubs += 1;
            }
            else if (cardSuit == "Hearts"){
                actualHearts += 1;
            }
        }
        int expected2Count = 4;
        int expected3Count = 4;
        int expected4Count = 4;
        int expected5Count = 4;
        int expected6Count = 4;
        int expected7Count = 4;
        int expected8Count = 4;
        int expected9Count = 4;
        int expected10Count = 4;
        int expectedJackCount = 4;
        int expectedQueenCount = 4;
        int expectedKingCount = 4;
        int expectedAceCount = 4;
        int expectedDiamondsCount = 13;
        int expectedClubsCount = 13;
        int expectedSpadesCount = 13;
        int expectedHeartsCount = 13;
        Testing.assertEquals(msg, expectedDeckSize, actualDeckSize);
        Testing.assertEquals(msg, expected2Count, actualRank2);
        Testing.assertEquals(msg, expected3Count, actualRank3);
        Testing.assertEquals(msg, expected4Count, actualRank4);
        Testing.assertEquals(msg, expected5Count, actualRank5);
        Testing.assertEquals(msg, expected6Count, actualRank6);
        Testing.assertEquals(msg, expected7Count, actualRank7);
        Testing.assertEquals(msg, expected8Count, actualRank8);
        Testing.assertEquals(msg, expected9Count, actualRank9);
        Testing.assertEquals(msg, expected10Count, actualRank10);
        Testing.assertEquals(msg, expectedJackCount, actualRankJack);
        Testing.assertEquals(msg, expectedQueenCount, actualRankQueen);
        Testing.assertEquals(msg, expectedKingCount, actualRankKing);
        Testing.assertEquals(msg, expectedAceCount, actualRankAce);
        Testing.assertEquals(msg, expectedHeartsCount, actualHearts);
        Testing.assertEquals(msg, expectedSpadesCount, actualSpades);
        Testing.assertEquals(msg, expectedDiamondsCount, actualDiamonds);
        Testing.assertEquals(msg, expectedClubsCount, actualClubs);
    }

    private static void testGatherNoLostCards() {
        String msg = "Test the shuffle() method, deal out deck, then gather cards and make sure no cards are lost / " +
                "repeated in the process";
        Deck deckOfCards = new Deck();
        deckOfCards.shuffle();
        for (int cardsDealt = 0; cardsDealt < 52; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
        }
        deckOfCards.gather();
        int actualRank2 = 0;
        int actualRank3 = 0;
        int actualRank4 = 0;
        int actualRank5 = 0;
        int actualRank6 = 0;
        int actualRank7 = 0;
        int actualRank8 = 0;
        int actualRank9 = 0;
        int actualRank10 = 0;
        int actualRankJack= 0;
        int actualRankQueen = 0;
        int actualRankKing = 0;
        int actualRankAce = 0;
        int actualDiamonds = 0;
        int actualClubs = 0;
        int actualSpades = 0;
        int actualHearts = 0;
        int expectedDeckSize = 52;
        int actualDeckSize = deckOfCards.size();
        for (int cardsDealt = 0; cardsDealt < 52; cardsDealt++) {
            Card dealtCard = deckOfCards.deal();
            int cardRank = dealtCard.getRank();
            String cardSuit = dealtCard.getSuit();
            if (cardRank == 2){
                actualRank2 += 1;
            }
            else if (cardRank == 3){
                actualRank3 += 1;
            }
            else if (cardRank == 4){
                actualRank4 += 1;
            }
            else if (cardRank == 5){
                actualRank5 += 1;
            }
            else if (cardRank == 6){
                actualRank6 += 1;
            }
            else if (cardRank == 7){
                actualRank7 += 1;
            }
            else if (cardRank == 8){
                actualRank8 += 1;
            }
            else if (cardRank == 9){
                actualRank9 += 1;
            }
            else if (cardRank == 10){
                actualRank10 += 1;
            }
            else if (cardRank == 11){
                actualRankJack += 1;
            }
            else if (cardRank == 12){
                actualRankQueen += 1;
            }
            else if (cardRank == 13){
                actualRankKing += 1;
            }
            else if (cardRank == 14){
                actualRankAce += 1;
            }
            if (cardSuit == "Diamonds"){
                actualDiamonds += 1;
            }
            else if (cardSuit == "Spades"){
                actualSpades += 1;
            }
            else if (cardSuit == "Clubs"){
                actualClubs += 1;
            }
            else if (cardSuit == "Hearts"){
                actualHearts += 1;
            }
        }
        int expected2Count = 4;
        int expected3Count = 4;
        int expected4Count = 4;
        int expected5Count = 4;
        int expected6Count = 4;
        int expected7Count = 4;
        int expected8Count = 4;
        int expected9Count = 4;
        int expected10Count = 4;
        int expectedJackCount = 4;
        int expectedQueenCount = 4;
        int expectedKingCount = 4;
        int expectedAceCount = 4;
        int expectedDiamondsCount = 13;
        int expectedClubsCount = 13;
        int expectedSpadesCount = 13;
        int expectedHeartsCount = 13;
        Testing.assertEquals(msg, expectedDeckSize, actualDeckSize);
        Testing.assertEquals(msg, expected2Count, actualRank2);
        Testing.assertEquals(msg, expected3Count, actualRank3);
        Testing.assertEquals(msg, expected4Count, actualRank4);
        Testing.assertEquals(msg, expected5Count, actualRank5);
        Testing.assertEquals(msg, expected6Count, actualRank6);
        Testing.assertEquals(msg, expected7Count, actualRank7);
        Testing.assertEquals(msg, expected8Count, actualRank8);
        Testing.assertEquals(msg, expected9Count, actualRank9);
        Testing.assertEquals(msg, expected10Count, actualRank10);
        Testing.assertEquals(msg, expectedJackCount, actualRankJack);
        Testing.assertEquals(msg, expectedQueenCount, actualRankQueen);
        Testing.assertEquals(msg, expectedKingCount, actualRankKing);
        Testing.assertEquals(msg, expectedAceCount, actualRankAce);
        Testing.assertEquals(msg, expectedHeartsCount, actualHearts);
        Testing.assertEquals(msg, expectedSpadesCount, actualSpades);
        Testing.assertEquals(msg, expectedDiamondsCount, actualDiamonds);
        Testing.assertEquals(msg, expectedClubsCount, actualClubs);
    }

    // By nature, does not always pass because sometimes a card of the same rank/suit is randomly inserted into the same
    // position of the deck, as it previously was, after shuffling.
    private static void testRandomnessOfShuffle() {
        String msg = "Test the shuffle() method to ensure the first few cards are different before and after shuffling";
        Deck deckOfCards = new Deck();
        Card cardDealtPreShuffle1 = deckOfCards.deal();
        Card cardDealtPreShuffle2 = deckOfCards.deal();
        Card cardDealtPreShuffle3 = deckOfCards.deal();
        deckOfCards.gather();
        deckOfCards.shuffle();
        Card cardDealtPostShuffle1 = deckOfCards.deal();
        Card cardDealtPostShuffle2 = deckOfCards.deal();
        Card cardDealtPostShuffle3 = deckOfCards.deal();
        int cardRankOfPreShuffle1 = cardDealtPreShuffle1.getRank();
        int cardRankOfPreShuffle2 = cardDealtPreShuffle2.getRank();
        int cardRankOfPreShuffle3 = cardDealtPreShuffle3.getRank();
        String cardSuitOfPreShuffle1 = cardDealtPreShuffle1.getSuit();
        String cardSuitOfPreShuffle2 = cardDealtPreShuffle2.getSuit();
        String cardSuitOfPreShuffle3 = cardDealtPreShuffle3.getSuit();
        int cardRankOfPostShuffle1 = cardDealtPostShuffle1.getRank();
        int cardRankOfPostShuffle2 = cardDealtPostShuffle2.getRank();
        int cardRankOfPostShuffle3 = cardDealtPostShuffle3.getRank();
        String cardSuitOfPostShuffle1 = cardDealtPostShuffle1.getSuit();
        String cardSuitOfPostShuffle2 = cardDealtPostShuffle2.getSuit();
        String cardSuitOfPostShuffle3 = cardDealtPostShuffle3.getSuit();
        boolean cardsChangedRanks1 = cardRankOfPreShuffle1 != cardRankOfPostShuffle1;
        boolean cardsChangedRanks2 = cardRankOfPreShuffle2 != cardRankOfPostShuffle2;
        boolean cardsChangedRanks3 = cardRankOfPreShuffle3 != cardRankOfPostShuffle3;
        boolean cardsChangedSuits1 = cardSuitOfPreShuffle1 != cardSuitOfPostShuffle1;
        boolean cardsChangedSuits2 = cardSuitOfPreShuffle2 != cardSuitOfPostShuffle2;
        boolean cardsChangedSuits3 = cardSuitOfPreShuffle3 != cardSuitOfPostShuffle3;
        Testing.assertTrue(msg, cardsChangedRanks1);
        Testing.assertTrue(msg, cardsChangedRanks2);
        Testing.assertTrue(msg, cardsChangedRanks3);
        Testing.assertTrue(msg, cardsChangedSuits1);
        Testing.assertTrue(msg, cardsChangedSuits2);
        Testing.assertTrue(msg, cardsChangedSuits3);

    }

    private static void testUnShuffledDeckAsString(){
        String msg = "Test the toString() method for an un-shuffled full Deck";
        Deck deckOfCards = new Deck();
        String expected = "(2 of Hearts) (3 of Hearts) (4 of Hearts) (5 of Hearts) (6 of Hearts) (7 of Hearts) " +
                "(8 of Hearts) (9 of Hearts) (10 of Hearts) (Jack of Hearts) (Queen of Hearts) (King of Hearts) " +
                "(Ace of Hearts) (2 of Diamonds) (3 of Diamonds) (4 of Diamonds) (5 of Diamonds) (6 of Diamonds) " +
                "(7 of Diamonds) (8 of Diamonds) (9 of Diamonds) (10 of Diamonds) (Jack of Diamonds) (Queen of Diamonds)" +
                " (King of Diamonds) (Ace of Diamonds) (2 of Spades) (3 of Spades) (4 of Spades) (5 of Spades)" +
                " (6 of Spades) (7 of Spades) (8 of Spades) (9 of Spades) (10 of Spades) (Jack of Spades)" +
                " (Queen of Spades) (King of Spades) (Ace of Spades) (2 of Clubs) (3 of Clubs) (4 of Clubs)" +
                " (5 of Clubs) (6 of Clubs) (7 of Clubs) (8 of Clubs) (9 of Clubs) (10 of Clubs) (Jack of Clubs)" +
                " (Queen of Clubs) (King of Clubs) (Ace of Clubs) ";
        String actual = "" + deckOfCards;
        Testing.assertEquals(msg, expected, actual);
    }
}