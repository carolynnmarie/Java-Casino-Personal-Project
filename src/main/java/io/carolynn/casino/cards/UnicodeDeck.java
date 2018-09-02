package io.carolynn.casino.cards;

import java.util.ArrayList;
import java.util.Collections;

public class UnicodeDeck {

    ArrayList<UnicodeCard> deck;

    public UnicodeDeck(){
        this.deck = new ArrayList<>();
        for(UnicodeCard card: UnicodeCard.values()){
            deck.add(card);
        }
    }

    public UnicodeDeck(ArrayList<UnicodeCard> deck){
        this.deck = deck;
    }

    public ArrayList<UnicodeCard> getDeckUni() {
        return deck;
    }

    public void setDeckUni(ArrayList<UnicodeCard> deck) {
        this.deck = deck;
    }

    public void addCardUni(UnicodeCard card){
        deck.add(card);
    }

    public UnicodeCard drawCardUni(){
        return deck.remove(0);
    }

    public UnicodeCard seeCardUni(int index){
        return deck.get(index);
    }

    public ArrayList<UnicodeCard> dealHandUni(int numberOfCards){
        ArrayList<UnicodeCard> cards = new ArrayList<>();
        for(int i = 0; i<numberOfCards; i++){
            cards.add(deck.remove(i));
            setDeckUni(deck);
        }
        return cards;
    }

    public void shuffleDeckUni(){
        Collections.shuffle(deck);
    }

    public void clearDeckUni(){
        deck.clear();
    }

    public Integer getDeckSizeUni(){
        return deck.size();
    }

    public boolean matchesUni(UnicodeCard card){
        if(deck.contains(card)) return true;
        return false;
    }

    public ArrayList<UnicodeCard> removeAllUni(ArrayList<UnicodeCard> cards){
        ArrayList<UnicodeCard> list = new ArrayList<>();
        for(UnicodeCard card: deck){
            for(UnicodeCard hand: cards){
                if(card.getName().equals(hand.getName())){
                    list.add(hand);
                }
            }
        }
        deck.removeAll(list);
        return deck;
    }

}
