package io.carolynn.casino;

import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

import java.util.ArrayList;

public class Person {

    private String name;
    private int chips;


    public Person(String name){
        this.name = name;
        this.chips = 0;
    }

    public Person(){
        this.name = "";
        this.chips = 0;
    }

    public Person(String name, Integer chips){
        this.name = name;
        this.chips = chips;
    }

    public void setChips(int chips){
        this.chips = chips;
    }
    public int getChips(){
        return chips;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
