package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;
import io.carolynn.casino.games.cardGames.GoFish;
import org.junit.Assert;
import org.junit.Test;

import java.net.CacheRequest;
import java.util.ArrayList;

public class GoFishTest {

    private Person player = new Person("Jack");
    private Person dealer = new Person("Dealer");
    private Deck houseDeck = new Deck();
    GoFish goFish = new GoFish(player);


    @Test
    public void testConstructor(){
        int expected = 52;
        int actual = houseDeck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2Constructor(){
        String expected = "Jack";
        String actual = goFish.getPlayer().getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealHand(){
        goFish.setDealerHand();
        goFish.setPlayerHand();
        int expected = 38;
        int actual = goFish.getHouseDeck().getDeckSize();
        Assert.assertEquals(expected, actual);
    }

}
