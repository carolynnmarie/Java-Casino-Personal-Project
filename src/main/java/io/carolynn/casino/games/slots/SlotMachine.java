package io.carolynn.casino.games.slots;

import io.carolynn.casino.Person;
import io.carolynn.casino.games.Game;
import java.util.*;

public class SlotMachine extends Game {

    private SlotReelSymbols [] fruits;

    public SlotMachine(Person player){
        super(player);
        this.fruits = SlotReelSymbols.values();
    }

    public void start(){
        boolean play = true;
        System.out.println("This is a 3 reel single line slot machine.  Each spin is 1 chip.\n  The payout for 3 of " +
                "the same fruit in a line is 21 chips.\n  The payout for three bars in a line is 30 chips.\n  " +
                "The payout for ");
        do{
            play = pullMachine();
            String [] spinResults = results();
        } while(play);
    }


    public boolean pullMachine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current chip balance is" + player.getChips() + "\nPress enter to play slots");
        String play = scanner.nextLine();
        if(play.equals("")) return true;
        return false;
    }

    public String [] results(){
        int fruit1Index = (int)Math.round(Math.random()*(fruits.length-1));
        String fruit1 = fruits[fruit1Index].getSymbol();
        int fruit2Index = (int)Math.round(Math.random()*(fruits.length-1));
        String fruit2 = fruits[fruit2Index].getSymbol();
        int fruit3Index = (int)Math.round(Math.random()*(fruits.length-1));
        String fruit3 = fruits[fruit3Index].getSymbol();
        String [] fruitLine = {fruit1, fruit2, fruit3};
        return fruitLine;
    }



    @Override
    public void end() {

    }

    @Override
    public void runGame() {

    }

//    public static void main(String[] args){
//        SlotReelSymbols[] fruits = SlotReelSymbols.values();
//        List<String> fruitChars = Arrays.stream(fruits).map(e-> e.getSymbol()).collect(Collectors.toList());
//        StringBuilder builder = new StringBuilder();
//        fruitChars.forEach(e->builder.append(e).append(" "));
//        System.out.println(builder.toString());
//
//    }
}
