package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackTest {

    private Deck houseDeck = new Deck();
    private Person player = new Person("Player");
    @Before public void setup(){
        player.setChips(500);
    }

    @Test
    public void setBetTest(){
        int expected = 50;
        player.setChips(50);
        int actual = player.getChips();
        Assert.assertEquals(actual,expected);
    }


}
