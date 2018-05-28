package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

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
    public abstract void runGame();
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
}
