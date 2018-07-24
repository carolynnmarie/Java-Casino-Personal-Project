package io.carolynn.casino.cards;

public enum Suit {
    CLUBS("clubs","\u2663"),
    DIAMONDS("diamonds", "\u2666"),
    SPADES("spades", "\u2660"),
    HEARTS("hearts", "\u2665");

    final String suitWord;
    final String suitSymbol;

    Suit(String suitWord, String suitSymbol){
        this.suitWord= suitWord;
        this.suitSymbol = suitSymbol;
    }

    public String getSuitWord(){
        return this.suitWord;
    }

    public String getSuitSymbol(){
        return this.suitSymbol;
    }
}
