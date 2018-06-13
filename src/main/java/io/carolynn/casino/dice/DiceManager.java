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
            Integer face = (int) Math.ceil(Math.random() * 6);
            if (face.equals(0)) face = 1;
            if (face.equals(7)) face = 6;
            int x =  (int) Math.ceil(Math.random() * 6);
            DieFace die = (x==0)?DieFace.ONE: (x==1)?DieFace.ONE: (x==2)?DieFace.TWO: (x==3)?DieFace.THREE: (x==4)?DieFace.FOUR:
                    (x==5)? DieFace.FIVE: DieFace.SIX;
            this.dice[i].setDieFace(die);
        }
    }

    public Integer rollDie(int index){
        int x =  (int) Math.ceil(Math.random() * 6);
        DieFace die = (x==0)?DieFace.ONE: (x==1)?DieFace.ONE: (x==2)?DieFace.TWO: (x==3)?DieFace.THREE: (x==4)?DieFace.FOUR:
                (x==5)? DieFace.FIVE: DieFace.SIX;
        this.dice[index].setDieFace(die);
        return x;
    }

    public Dice[] getDice() {
        return dice;
    }

    public Integer totalValue(){
        Integer total = 0;
        for(Dice die: dice){
            total += die.getDieValue();
        }
        return total;
    }

    @Override
    public String toString() {
        String dicey = "Dice values rolled: ";
        for (Dice die : dice) {
            dicey += die.toString() + " ";
        }
        return dicey;
    }
}
