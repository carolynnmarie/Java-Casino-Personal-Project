package io.carolynn.casino.games.slots;

import io.carolynn.casino.Person;
import io.carolynn.casino.games.Game;
import static io.carolynn.casino.games.slots.SlotReelSymbols.*;
import java.util.*;

public class SlotMachine extends Game {

    private SlotReelSymbols [] fruits;

    public SlotMachine(Person player){
        super(player);
        this.fruits = new SlotReelSymbols[]{CHERRY,APPLE,GRAPE,LEMON,BANANA,MELON,ORANGE,BAR,SEVEN};
    }

    public void start(){
        System.out.println("This is a 3 reel single line slot machine.  Each spin is 1 chip.\n  The payout for 3 of " +
                "the same fruit in a line is 21 chips.\n  The payout for three bars in a line is 30 chips.\n  " +
                "The payout for three 7's in a line is 45 chips");
        boolean play = pullMachine();
        while(play){
            runGame();
            play = pullMachine();
        }
        end();
    }

    public boolean pullMachine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current chip balance is" + player.getChips() + "\nPress enter to play slots. Type any other key" +
                "to exit.");
        String play = scanner.nextLine();
        if(play.equals("")) return true;
        return false;
    }

    @Override
    public void runGame() {
        player.removeChips(1);
        int payout = 0;
        String result = "";
        String [] spinResults = Spin();
        StringBuilder payoutResult = new StringBuilder();
        payoutResult.append("Your spin was: ")
                .append(spinResults[0] + ", ")
                .append(spinResults[1] + ", ")
                .append(spinResults[2] + ", ");
        if(spinResults[0].equals(spinResults[1]) && spinResults[0].equals(spinResults[2])){
            result = spinResults[0];
            payout = getPayout(result);
            payoutResult.append("\nYou got 3 " + result + " in a row!")
                    .append("Your payout is " + payout)
                    .append("! Your balance is " + player.getChips());
            player.addChips(payout);
        } else {
            payoutResult.append("\nSorry, you did not get 3 in a row.  Your balance is now ")
                    .append(player.getChips());
        }
        System.out.println(payoutResult);
    }

    public String [] Spin(){
        int fruit1Index = (int)Math.round(Math.random()*(fruits.length-1));
        String fruit1 = fruits[fruit1Index].getSymbol();
        int fruit2Index = (int)Math.round(Math.random()*(fruits.length-1));
        String fruit2 = fruits[fruit2Index].getSymbol();
        int fruit3Index = (int)Math.round(Math.random()*(fruits.length-1));
        String fruit3 = fruits[fruit3Index].getSymbol();
        String [] fruitLine = {fruit1, fruit2, fruit3};
        return fruitLine;
    }

    public int getPayout(String fruitSymbol){
        int payout = -1;
        for(SlotReelSymbols fruit: fruits){
            if(fruit.getSymbol().equals(fruitSymbol)){
                payout = fruit.getPayout()*3;
            }
        }
        return payout;
    }

    @Override
    public void end() {
        System.out.println("Thank you for playing the slot machine.  Going back to the main menu");
    }


}
