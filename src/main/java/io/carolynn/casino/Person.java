package io.carolynn.casino;

import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Person {

    private String name;
    private int chips;
    private ArrayList<Card> hand;
    private int book;


    public Person(String name){
        this.name = name;
        this.chips = 0;
        this.hand = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setChips(int chips){
        this.chips = chips;
    }

    public int getChips(){
        return chips;
    }

    public void addChips(int chips){
        this.chips += chips;
    }

    public void removeChips(int chips){
        this.chips -= chips;
    }

    public ArrayList<Card> getHand() { return hand; }

    public void setHand(ArrayList<Card> hand) { this.hand = hand; }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

}
