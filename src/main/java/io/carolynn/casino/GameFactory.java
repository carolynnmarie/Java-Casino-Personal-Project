package io.carolynn.casino;

import io.carolynn.casino.games.cardGames.BlackJack;
import io.carolynn.casino.games.diceGames.Craps;
import io.carolynn.casino.games.Game;
import io.carolynn.casino.games.cardGames.GoFish;
import io.carolynn.casino.games.cardGames.War;

public class GameFactory {

    public static Game goToGame(String gameChoice, Person person){
        Game game;
        if(gameChoice.equalsIgnoreCase("blackjack")) {
            game = new BlackJack(person);
        } else if(gameChoice.equalsIgnoreCase("craps")) {
            game = new Craps(person);
        } else if(gameChoice.equalsIgnoreCase("go fish")) {
            game = new GoFish(person);
        } else if(gameChoice.equalsIgnoreCase("war")){
            game = new War(person);
        } else {
            game = null;
        }
        return game;
    }

}
