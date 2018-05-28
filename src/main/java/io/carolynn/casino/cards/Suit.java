package io.carolynn.casino.cards;

public enum Suit {
    CLUBS("clubs"), DIAMONDS("diamonds"), SPADES("spades"), HEARTS("hearts");

    final String suit;

    Suit(String suit){
        this.suit= suit;
    }

    public String getSuit(){
        return this.suit;
    }
}
