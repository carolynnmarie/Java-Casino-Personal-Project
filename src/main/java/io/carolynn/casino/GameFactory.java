package io.carolynn.casino;

import io.carolynn.casino.games.BlackJack;
import io.carolynn.casino.games.Craps;
import io.carolynn.casino.games.Game;

public class GameFactory {

    public static Game goToGame(String gameChoice, Person person){
        Game game;
        if(gameChoice.equalsIgnoreCase("blackjack")) {
            game = new BlackJack(person);
        } else if(gameChoice.equalsIgnoreCase("craps")){
            game = new Craps(person);
        } else {
            game = null;
        }
        return game;
    }

}
