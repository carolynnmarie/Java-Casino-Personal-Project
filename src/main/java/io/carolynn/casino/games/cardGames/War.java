package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class War extends CardGame {

    private Deck playerHand;
    private Deck dealerHand;
    private ArrayList<Card> tableCards;


    public War(Person player){
        super(player);
        this.playerHand = new Deck();
        this.dealerHand = new Deck();
        this.tableCards = new ArrayList<>();
    }

    public void setPlayerHand(Deck playerHand){
        this.playerHand = playerHand;
    }

    public Deck getPlayerHand() {
        return playerHand;
    }

    public Deck getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(Deck dealerHand){
        this.dealerHand = dealerHand;

    }

    @Override
    public void start() {
        String answer = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to WAR!\nEnter\"exit\" at any time to exit the game.\nPress enter to flip your card");
        dealCards();
        do {
            answer = scan.nextLine();
            if(!answer.equals("exit")) {
                runGame();
            }
        } while(!checkIfEitherAreEmpty()&& !answer.equals("exit"));
        end();
    }

    public void dealCards(){
        playerHand = dealCards(26);
        dealerHand = getHouseDeck();
    }

    public void runGame() {
        Card playerCard = playerHand.removeCard(0);
        Card dealerCard = dealerHand.removeCard(0);
        tableCards.add(playerCard);
        tableCards.add(dealerCard);
        System.out.println("Your card: " + playerCard.toString() + "  Dealer's card: " + dealerCard.toString());
        if (playerCard.getRank() > dealerCard.getRank()) {
            playerHand.addCards(tableCards);
            System.out.println("You won the round!\nYou have " + playerHand.getDeckSize() + " cards, dealer has "
                    + dealerHand.getDeckSize()+ " cards.");
        } else if (playerCard.getRank() < dealerCard.getRank()) {
            dealerHand.addCards(tableCards);
            System.out.println("Dealer won the round!\nYou have " + playerHand.getDeckSize() + " cards, dealer has "
                    + dealerHand.getDeckSize()+ " cards.");
        } else {
            if (!checkIfEitherAreEmpty()) {
                System.out.println("It's a tie!\n\n***I Declare War!***");
                iDeclareWar();
                System.out.println("You have " + playerHand.getDeckSize() + " cards, dealer has " + dealerHand.getDeckSize()+ " cards.");
            }
        }
        tableCards.clear();
    }


    public void iDeclareWar(){
        Card topDealerCard;
        Card topPlayerCard;
        do{
            int numOfCards = (playerHand.getDeckSize() >= 3 && dealerHand.getDeckSize() >= 3) ? 3 :
                    (dealerHand.getDeckSize() < playerHand.getDeckSize())? dealerHand.getDeckSize(): playerHand.getDeckSize();
            topDealerCard = dealerHand.getDeck().get(numOfCards - 1);
            topPlayerCard = playerHand.getDeck().get(numOfCards - 1);
            System.out.println("Dealer's top card: " + topDealerCard.toString() + ".\nYour top card: " + topPlayerCard.toString());
            for(int i = 0; i<numOfCards; i++){
                tableCards.add(playerHand.removeCard(0));
                tableCards.add(dealerHand.removeCard(0));
            }
            if (topDealerCard.getRank() > topPlayerCard.getRank()) {
                System.out.println("Dealer won!");
                dealerHand.addCards(tableCards);
            } else if (topDealerCard.getRank() < topPlayerCard.getRank()) {
                System.out.println("You won!");
                playerHand.addCards(tableCards);
            } else {
                System.out.println("It's a tie, I Declare War again!");
            }
        } while (topDealerCard.getRank() == topPlayerCard.getRank() && !checkIfEitherAreEmpty());
    }


    public boolean checkIfEitherAreEmpty(){
        if(playerHand.getDeckSize() == 0 || dealerHand.getDeckSize() == 0){
            return true;
        }
        return false;
    }


    public void end() {
        String winner = "And the winner is ";
        winner += (playerHand.getDeckSize() < dealerHand.getDeckSize())? "the dealer!": getPlayerName();
        System.out.println(winner + "\nIf you want to play again, enter 'yes', or enter anything else to return to the casino");
        Scanner input = new Scanner(System.in);
        playerHand.clearDeck();
        dealerHand.clearDeck();
        if (input.nextLine().equalsIgnoreCase("yes")) {
            start();
        } else {
            System.out.println("Good bye ");
        }
    }

    public static void main(String[] args){
        War war = new War(new Person("Carolynn"));
        war.start();
    }
}

