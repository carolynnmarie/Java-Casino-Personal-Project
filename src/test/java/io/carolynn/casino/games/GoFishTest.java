package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Rank;
import io.carolynn.casino.cards.Suit;
import io.carolynn.casino.games.cardGames.GoFish;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GoFishTest {

    private Person player = new Person("Jack");
    //private Deck houseDeck = new Deck();
    GoFish goFish = new GoFish(player);

    Card card1 = new Card(Rank.QUEEN, Suit.HEARTS);
    Card card2 = new Card(Rank.JACK, Suit.HEARTS);
    Card card3 = new Card(Rank.TEN, Suit.HEARTS);
    Card card4 = new Card(Rank.KING, Suit.HEARTS);
    Card card5 = new Card(Rank.KING, Suit.CLUBS);
    Card card6 = new Card(Rank.QUEEN, Suit.CLUBS);
    Card card7 = new Card(Rank.JACK, Suit.CLUBS);
    Card card8 = new Card(Rank.TEN, Suit.CLUBS);
    Card card9 = new Card(Rank.KING, Suit.SPADES);
    Card card10 = new Card(Rank.KING, Suit.CLUBS);

    @Test
    public void testConstructor(){
        int expected = 52;
        int actual = goFish.getHouseDeck().getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2Constructor(){
        String expected = "Jack";
        String actual = goFish.getPlayer().getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerAsks(){
        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card1, card2, card3, card4));
        ArrayList<Card> dealerHand = new ArrayList<>(Arrays.asList(card5, card6, card7, card8));
        goFish.setPlayerHand(playerHand);
        goFish.setDealerHand(dealerHand);
        int actual = goFish.playerAsks(11);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGoFish(){
        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5,card9));
        goFish.setPlayerHand(playerHand);
        goFish.getHouseDeck().removeCards(playerHand);
        int fish = goFish.playerGoFish(13, playerHand);
        int expected = 7;
        int actual = goFish.getPlayerHand().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerBookRemoval(){
        ArrayList<Card> playerHand = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card9, card10));
        goFish.setPlayerHand(playerHand);
        goFish.playerBookRemoval(13);
        int expected = 3;
        int actual = goFish.getPlayerHand().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealerAsks(){

    }

    @Test
    public void testDealerGoFish(){

    }

    @Test
    public void testDealerBookRemoval(){

    }

    @Test
    public void testDoYouHaveCard(){

    }

    @Test
    public void testSwapCards(){

    }

    @Test
    public void testDisplayCards(){

    }

    @Test
    public void testWhoWonTheGame(){

    }

}
