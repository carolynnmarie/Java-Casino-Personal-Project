package io.carolynn.casino.dice;

import java.util.ArrayList;

public class DiceManager {

    Dice[] dice;


    public DiceManager(){
        this.dice = new Dice[]{};
    }

    public DiceManager(int nDice){
        this.dice = new Dice[nDice];
    }

    public void rollDice(Integer nDice){
        for(int i = 0; i<nDice; i++) {
            int x =  (int) Math.ceil(Math.random() * 6);
            DieFace die = (x==0)?DieFace.ONE: (x==1)?DieFace.ONE: (x==2)?DieFace.TWO: (x==3)?DieFace.THREE: (x==4)?DieFace.FOUR:
                    (x==5)? DieFace.FIVE: DieFace.SIX;
            dice[i].setDieFace(die);
        }
    }

    public Integer rollDie(int index){
        int x =  (int) Math.ceil(Math.random() * 6);
        DieFace die = (x==0)?DieFace.ONE: (x==1)?DieFace.ONE: (x==2)?DieFace.TWO: (x==3)?DieFace.THREE: (x==4)?DieFace.FOUR:
                (x==5)? DieFace.FIVE: DieFace.SIX;
        dice[index].setDieFace(die);
        return x;
    }

    public Dice[] getDice() {
        return dice;
    }

    public void setDice(Dice[] dice){
        this.dice = dice;
    }

    public Integer totalValue(){
        Integer total = 0;
        for(Dice die: dice){
            total += die.getDieValue();
        }
        return total;
    }


    public String toStringValues() {
        StringBuilder builder = new StringBuilder("Dice values rolled: ");
        for (Dice die : dice) {
            builder.append(die.getDieValue())
                    .append(", ");
        }
        return builder.toString();
    }

    public String toStringPictures(){
        StringBuilder builder = new StringBuilder();
        for(Dice die: dice){
            builder.append(die.dieFace.getPicture())
                    .append(" ");
        }
        return builder.toString();
    }
}
