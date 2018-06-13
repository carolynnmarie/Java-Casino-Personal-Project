package io.carolynn.casino.cards;



public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Rank rank, Suit suit){
        this.suit = suit;
        this.rank = rank;
    }

    public Card(){
        int x = (int)Math.ceil(Math.random()*13);
        this.rank = (x==1)? Rank.ACE: (x==2)? Rank.TWO: (x==3)?Rank.THREE: (x==4)?Rank.FOUR: (x==5)?Rank.FIVE:
                (x==6)?Rank.SIX: (x==7)?Rank.SEVEN: (x==8)?Rank.EIGHT: (x==9)? Rank.NINE: (x==10)? Rank.TEN:
                        (x==11)? Rank.JACK: (x==12)?Rank.QUEEN: Rank.KING;
        int y = (int)Math.ceil(Math.random()*4);
        this.suit = (y==1)?Suit.DIAMONDS: (y==2)?Suit.CLUBS: (y==3)?Suit.SPADES: Suit.HEARTS;
        }


    public String getSuit(){
        return suit.getSuit();
    }

    public Integer getRank(){
        return rank.rankValue();
    }

    @Override
    public String toString(){
        return rank.rankName() + " of " + suit.getSuit();
    }
}
