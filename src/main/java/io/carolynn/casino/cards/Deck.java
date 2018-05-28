package io.carolynn.casino.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<>();
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                deck.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
    }


    public Deck(ArrayList<Card> deck){
        this.deck = deck;
    }

    public ArrayList<Card> getDeck(){
        return this.deck;
    }

    public void addCard(Card card){
      deck.add(card);
    }

    public Card drawCard(){
        return deck.remove(0);
    }

    public void clearDeck(){
        deck.clear();
    }

    @Override
    public String toString(){
        StringBuilder x = new StringBuilder();
        for(Card card: deck){
            x.append(card.toString()).append(" ");
        }
        String cardString = x.toString();
        return cardString.trim();

    }

}
