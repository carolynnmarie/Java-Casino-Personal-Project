package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Deck;

public abstract class Game {

    protected Person player;

    public Game(){

    }

    public Game(Person player){
        this.player = player;

    }

    public abstract void start();
    public abstract void end();
    public abstract void runGame();

    public Person getPlayer(){
        return player;
    }

    public String getPlayerName(){
        return player.getName();
    }
}
