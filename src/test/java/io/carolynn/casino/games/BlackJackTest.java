package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;
import io.carolynn.casino.cards.Rank;
import io.carolynn.casino.cards.Suit;
import io.carolynn.casino.games.cardGames.BlackJack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackJackTest {

    private Person player = new Person("Luis");
    private BlackJack blackJack = new BlackJack(player);

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

    @Test
    public void valueSumTest(){
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.TWO, Suit.HEARTS)));
        Deck deck = new Deck(cards);
        Integer expected = 17;
        Integer actual = blackJack.valueSum(deck);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerTurnTest(){
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.SEVEN, Suit.HEARTS)));
        Deck deck = new Deck(cards);
        Integer expected = 18;
        Integer actual = blackJack.valueSum(blackJack.dealerTurn(deck));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bustOrBlackJackTest(){
        String expected = "Your total card value is 16";
        String actual = blackJack.bustOrBlackJack(16);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void determineWinnerTest(){
        blackJack.setBet(50);
        String expected = "Congratulations, " + blackJack.getPlayerName() + "You won! You keep the chips you bet and get "
                + blackJack.getWinnings() + " more chips.\n";
        String actual = blackJack.determineWinner(20,18);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinningsTest(){
        blackJack.setBet(50);
        Integer expected = 25;
        Integer actual = blackJack.getWinnings();
        Assert.assertEquals(expected, actual);
    }

}
