package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Rank;
import io.carolynn.casino.cards.Suit;
import io.carolynn.casino.games.cardGames.War;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

//public class WarTest {
//
//    Person player = new Person("James");
//    War war = new War(player);
//    Card card1 = new Card(Rank.TWO, Suit.HEARTS);
//    Card card2 = new Card(Rank.JACK, Suit.HEARTS);
//    Card card3 = new Card(Rank.TEN, Suit.HEARTS);
//    Card card4 = new Card(Rank.NINE, Suit.HEARTS);
//    Card card5 = new Card(Rank.KING, Suit.CLUBS);
//    Card card6 = new Card(Rank.QUEEN, Suit.CLUBS);
//    Card card7 = new Card(Rank.JACK, Suit.CLUBS);
//    Card card8 = new Card(Rank.TEN, Suit.CLUBS);
//    Card card9 = new Card(Rank.KING, Suit.SPADES);
//    Card card10 = new Card(Rank.KING, Suit.CLUBS);
//
//    @Test
//    public void constructorTest(){
//        int expected = 26;
//        int actual = war.getDealerHand().size();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testRunGame(){
//        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card1,card2,card3,card4,card5));
//        ArrayList<Card> dealerHand = new ArrayList<>(Arrays.asList(card6,card7,card8,card9,card10));
//        war.setDealerHand(dealerHand);
//        war.setPlayerHand(playerHand);
//        war.runGame();
//        String actual = war.getDealerHand().toString();
//        String expected = new ArrayList<>(Arrays.asList(card7,card8,card9,card10,card1,card6)).toString();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testIDeclareWar(){
//        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card2,card3,card4,card5));
//        ArrayList<Card> dealerHand = new ArrayList<>(Arrays.asList(card7,card8,card9,card10));
//        ArrayList<Card> table = new ArrayList<>(Arrays.asList(card1,card6));
//        war.setPlayerHand(playerHand);
//        war.setDealerHand(dealerHand);
//        war.iDeclareWar(table);
//        int expected = 1;
//        int actual = war.getPlayerHand().size();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testCreateWarTablePile(){
//        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card1,card2,card3,card4,card5));
//        ArrayList<Card> dealerHand = new ArrayList<>(Arrays.asList(card6,card7,card8,card9,card10));
//        war.setDealerHand(dealerHand);
//        war.setPlayerHand(playerHand);
//        ArrayList<Card> expectedList = new ArrayList<>(Arrays.asList(card1,card6,card2,card7,card3,card8));
//        ArrayList<Card> actualList = war.createWarTablePile(3);
//        String expected = expectedList.toString();
//        String actual = actualList.toString();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testCheckIfEitherAreEmpty(){
//        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card1,card2,card3,card4,card5));
//        ArrayList<Card> dealerHand = new ArrayList<>();
//        war.setPlayerHand(playerHand);
//        war.setDealerHand(dealerHand);
//        Assert.assertTrue(war.checkIfEitherAreEmpty());
//    }
//
//    @Test
//    public void testDeclareWinner(){
//        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card1,card2,card3,card4,card5));
//        ArrayList<Card> dealerHand = new ArrayList<>();
//        war.setPlayerHand(playerHand);
//        war.setDealerHand(dealerHand);
//        String expected = "And the winner is " + player.getName();
//        String actual = war.declareWinner();
//        Assert.assertEquals(expected, actual);
//    }
//}
