package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;
import io.carolynn.casino.games.Game;

import java.util.ArrayList;

public abstract class CardGame extends Game {

    protected Deck houseDeck;
    protected Person dealer;

    public CardGame(Person player){
        super(player);
        this.dealer = new Person("Dealer");
        this.houseDeck = new Deck();
    }

    public abstract void start();
    public abstract void end();

    public Deck dealCards(Integer initialHand){
        ArrayList<Card> handCards = houseDeck.dealHand(initialHand);
        return new Deck(handCards);
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Deck getHouseDeck() {
        return houseDeck;
    }

    public Person getDealer(){
        return dealer;
    }

}
