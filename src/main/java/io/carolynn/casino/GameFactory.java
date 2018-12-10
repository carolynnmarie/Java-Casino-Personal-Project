package io.carolynn.casino;

import io.carolynn.casino.games.cardGames.BlackJack;
import io.carolynn.casino.games.diceGames.Craps;
import io.carolynn.casino.games.Game;
import io.carolynn.casino.games.cardGames.GoFish;
import io.carolynn.casino.games.cardGames.War;
import io.carolynn.casino.games.slots.SlotMachine;

public class GameFactory {

    public static Game goToGame(String gameChoice, Person person){
        Game game;
        if(gameChoice.equals("blackjack")) {
            game = new BlackJack(person);
//        } else if(gameChoice.equals("craps")) {
//            game = new Craps(person);
        } else if(gameChoice.equals("go fish")) {
            game = new GoFish(person);
        } else if(gameChoice.equals("war")) {
            game = new War(person);
        } else if(gameChoice.equals("slot machine")){
            game = new SlotMachine(person);
        } else {
            game = null;
        }
        return game;
    }

}
