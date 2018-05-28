package io.carolynn.casino.cards;



public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit){
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit(){
        return this.suit.getSuit();
    }

    public Integer getRank(){
        return this.rank.rankValue();
    }

    @Override
    public String toString(){
        return rank + " of " + suit;
    }
}
