package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Deck;

public abstract class Game {

    private Person player;
    private Person dealer;


    public Game(Person player){
        this.player = player;
        this.dealer = new Person("Dealer");
    }

    public abstract void start();
    public abstract void end();
    public abstract void runGame();
}
