package io.carolynn.casino.cards;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckTest {

    Deck deck = new Deck();
    Card card1 = new Card(Rank.QUEEN, Suit.HEARTS);
    Card card2 = new Card(Rank.JACK, Suit.HEARTS);
    Card card3 = new Card(Rank.TEN, Suit.HEARTS);
    Deck deck2 = new Deck(new ArrayList<>(Arrays.asList(card1, card2, card3)));
    Card card = new Card(Rank.KING, Suit.HEARTS);

    @Test
    public void constructor1Test(){
        Integer expected = 52;
        Integer actual = deck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructor2Test(){
        String expected = new Card(Rank.QUEEN, Suit.HEARTS).toString();
        String actual = deck2.getDeck().get(0).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardTest(){
        deck2.addCard(card);
        String expected = new Card(Rank.KING, Suit.HEARTS).toString();
        String actual = deck2.getDeck().get(3).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drawCardTest(){
        deck2.drawCard();
        Integer expected = 2;
        Integer actual = deck2.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void seeCardTest(){
        deck.seeCard(0);
        Integer expected = 52;
        Integer actual = deck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleDeckTest(){
        Deck unshuffled = new Deck();
        deck.shuffleDeck();
        String notExpected = unshuffled.seeFullDeck();
        String actual = deck.seeFullDeck();
        System.out.println(actual);
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void matchesTest(){
        boolean actual = deck2.matches(card1);
        Assert.assertTrue(actual);
    }

    @Test
    public void clearDeckTest(){
        deck.clearDeck();
        Integer expected = 0;
        Integer actual = deck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

}
