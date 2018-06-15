package io.carolynn.casino.cards;

import org.junit.Assert;
import org.junit.Test;

public class RankTest {

    @Test
    public void rankTest(){
        Card card = new Card(Rank.QUEEN, Suit.HEARTS);
        Integer expected = 12;
        Integer actual = card.getRank();
        Assert.assertEquals(expected, actual);
    }
}
