package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;
import io.carolynn.casino.games.Game;

import java.util.ArrayList;

public abstract class CardGame extends Game {

    private Person player;
    private Person dealer;
    private Deck houseDeck;


    public CardGame(Person player){
        this.player = player;
        this.dealer = new Person("Dealer");
        this.houseDeck = new Deck();
    }

    public abstract void start();
    public abstract void end();
    public Integer checkDeckSize(ArrayList<Card> hand){
        return hand.size();
    }

    public Deck dealHands(Integer initialHand){
        ArrayList<Card> handCards = new ArrayList<>();
        for(int i = 0; i< initialHand; i++){
            handCards.add(houseDeck.getDeck().remove(i));
        }
        return new Deck(handCards);
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Person getDealer() {
        return dealer;
    }

    public void setDealer(Person dealer) {
        this.dealer = dealer;
    }

    public Deck getHouseDeck() {
        return houseDeck;
    }

    public void setHouseDeck(Deck houseDeck) {
        this.houseDeck = houseDeck;
    }
}