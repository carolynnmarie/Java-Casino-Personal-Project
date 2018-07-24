package io.carolynn.casino;

import io.carolynn.casino.games.Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Casino {

    GameFactory factory;

    public Casino(){
        this.factory = new GameFactory();
    }

    public Person createPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Casino!  Please type in your name");
        Person player = new Person(scanner.nextLine());
        System.out.println("How many chips would you like to start off with?");
        player.setChips(scanner.nextInt());
        return player;
    }

    public void startCasino(){
        Scanner scanner = new Scanner(System.in);
        Person player = createPlayer();
        boolean again = true;
        do {
            System.out.println("What game would you like to play?  Please pick from the following options:" +
                    "\nBlackJack\nGo Fish\nWar");
            String gameChoice = scanner.nextLine().toLowerCase();
            while(gameChoice.equals("blackjack")||gameChoice.equals("go fish")||gameChoice.equals("war")) {
                Game game = GameFactory.goToGame(gameChoice, player);
                game.start();
            }
            again = startAnotherGame();
        }while(again);
        System.out.println("Good bye, thank you for playing!");
    }

    public boolean startAnotherGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you would like to play another game, type y.  If you wish to exit the casino, type " +
                "any other key");
        String answer = scanner.nextLine();
        if(answer.equals("y")){
            return true;
        }
        return false;
    }

}
