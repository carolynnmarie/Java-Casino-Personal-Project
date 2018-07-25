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

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void addCard(Card card){
      deck.add(card);
    }

    public Card drawCard(){
        return deck.remove(0);
    }

    public Card seeCard(int index){return deck.get(index);}

    public ArrayList<Card> dealHand(int numberOfCards){
        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0; i<numberOfCards; i++){
            cards.add(deck.remove(i));
            setDeck(deck);
        }
        return cards;
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public String seeFullDeck(){
        ArrayList<Card> deck2 = getDeck();
        String deckString = "";
        for(Card card: deck2){
            deckString+= card.toString();
        }
        return deckString;
    }

    public boolean matches(Card card){
        if(deck.contains(card)) return true;
        return false;
    }

    public void clearDeck(){
        deck.clear();
    }

    public Integer getDeckSize(){
        return deck.size();
    }

    public ArrayList<Card> remove(ArrayList<Card> cards){
        ArrayList<Card> list = new ArrayList<>();
        for(Card card: deck){
            for(Card hand: cards){
                if(card.getSuitWord().equals(hand.getSuitWord()) && card.getRank().equals(hand.getRank())){
                    list.add(card);
                }
            }
        }
        deck.removeAll(list);
        return deck;
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
