package io.carolynn.casino.cards;

import java.util.*;

public class UnicodeDeck {

    ArrayList<UnicodeCard> deck;

    public UnicodeDeck(){
        this.deck = new ArrayList<>();
        for(UnicodeCard card: UnicodeCard.values()){
            deck.add(card);
        }
        Collections.shuffle(deck);
    }

    public UnicodeDeck(ArrayList<UnicodeCard> deck){
        this.deck = deck;
    }

    public ArrayList<UnicodeCard> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<UnicodeCard> deck) {
        this.deck = deck;
    }

    public void addCard(UnicodeCard card){
        deck.add(card);
    }

    public void addCards(ArrayList<UnicodeCard> cards){
        deck.addAll(cards);
    }

    public UnicodeCard drawCard(){
        return deck.remove(0);
    }

    public UnicodeCard seeCard(int index){
        return deck.get(index);
    }

    public ArrayList<UnicodeCard> dealCards(int numberOfCards){
        ArrayList<UnicodeCard> cards = new ArrayList<>();
        for(int i = 0; i<numberOfCards; i++){
            cards.add(deck.remove(i));
            setDeck(deck);
        }
        return cards;
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public void clearDeck(){
        deck.clear();
    }

    public Integer getDeckSize(){
        return deck.size();
    }

    public boolean matches(UnicodeCard card){
        if(deck.contains(card)) return true;
        return false;
    }

    public UnicodeCard removeCard(int index){
        return deck.remove(index);
    }

    public ArrayList<UnicodeCard> removeCards(ArrayList<UnicodeCard> cards){
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

    public String seeFullDeck(){
        StringBuilder builder = new StringBuilder();
        for(UnicodeCard card: deck){
            builder.append(card.getUnicodePicture())
                    .append(" ");
        }
        return builder.toString().trim();
    }

    @Override
    public String toString(){
        StringBuilder x = new StringBuilder();
        for(UnicodeCard card: deck){
            x.append(card.toString()).append("\n");
        }
        String cardString = x.toString();
        return cardString.trim();

    }


}
