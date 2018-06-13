package io.carolynn.casino.cards;


import org.junit.Assert;
import org.junit.Test;

import static io.carolynn.casino.cards.Rank.*;
import static io.carolynn.casino.cards.Suit.*;

public class CardTest {

    Rank rank;
    Suit suit;
    Card card;

    @Test
    public void cardConstructorTest(){
        rank = KING;
        suit = HEARTS;
        card = new Card(rank, suit);
        String expected = "hearts";
        String actual = card.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest(){
        rank = QUEEN;
        suit = HEARTS;
        card = new Card(rank,suit);
        String expected = "Queen of hearts";
        String actual = card.toString();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getRankTest(){
        rank = FOUR;
        suit = SPADES;
        card = new Card(rank,suit);
        Integer expected = 4;
        Integer actual = card.getRank();
        Assert.assertEquals(expected,actual);
    }

}
