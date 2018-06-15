package io.carolynn.casino.cards;

import org.junit.Assert;
import org.junit.Test;

public class SuitTest {

    @Test
    public void suitTest(){
        String expected = "hearts";
        Card card = new Card(Rank.QUEEN, Suit.HEARTS);
        String actual = card.getSuit();
        Assert.assertEquals(expected, actual);
    }
}
