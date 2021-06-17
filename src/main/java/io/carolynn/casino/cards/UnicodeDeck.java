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
        Collections.shuffle(deck);
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
/*

    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    public String seeFullDeck(){
        ArrayList<Card> deck2 = getDeck();
        String deckString = "";
        for(Card card: deck2){
            deckString+= card.toString();
        }
        return deckString;
    }

    public ArrayList<Card> removeCards(List<Card> cards){
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

    public Card removeCard(int index){
        return deck.remove(index);
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
 */