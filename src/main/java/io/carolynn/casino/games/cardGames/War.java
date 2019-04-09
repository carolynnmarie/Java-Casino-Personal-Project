package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class War extends CardGame {

    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private ArrayList<Card> tableCards;


    public War(Person player){
        super(player);
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
        this.tableCards = new ArrayList<>();
    }

    public void setPlayerHand(ArrayList<Card> playerHand){
        this.playerHand = playerHand;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(ArrayList<Card> dealerHand){
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
        playerHand = houseDeck.dealHand(26);
        dealerHand = houseDeck.getDeck();
    }

    public void runGame() {
        Card playerCard = playerHand.remove(0);
        Card dealerCard = dealerHand.remove(0);

        tableCards.add(playerCard);
        tableCards.add(dealerCard);
        System.out.println("Your card: " + playerCard.toString() + "  Dealer's card: " + dealerCard.toString());
        if (playerCard.getRank() > dealerCard.getRank()) {
            playerHand.addAll(tableCards);
            System.out.println("You won the round!\nYou have " + playerHand.size() + " cards, dealer has "
                    + dealerHand.size()+ " cards.");
        } else if (playerCard.getRank() < dealerCard.getRank()) {
            dealerHand.addAll(tableCards);
            System.out.println("Dealer won the round!\nYou have " + playerHand.size() + " cards, dealer has "
                    + dealerHand.size()+ " cards.");
        } else {
            if (!checkIfEitherAreEmpty()) {
                System.out.println("It's a tie!\n\n***I Declare War!***");
                iDeclareWar();
                System.out.println("You have " + playerHand.size() + " cards, dealer has " + dealerHand.size()+ " cards.");
            }
        }
        tableCards.clear();
    }


    public void iDeclareWar(){
        Card topDealerCard;
        Card topPlayerCard;
        do{
            int numOfCards = getNumberOfCardsToPlay(playerHand,dealerHand);
            topDealerCard = dealerHand.get(numOfCards - 1);
            topPlayerCard = playerHand.get(numOfCards - 1);
            System.out.println("Dealer's top card: " + topDealerCard.toString() + ".\nYour top card: " + topPlayerCard.toString());
            for(int i = 0; i<numOfCards; i++){
                tableCards.add(playerHand.remove(0));
                tableCards.add(dealerHand.remove(0));
            }
            if (topDealerCard.getRank() > topPlayerCard.getRank()) {
                System.out.println("Dealer won!");
                dealerHand.addAll(tableCards);
            } else if (topDealerCard.getRank() < topPlayerCard.getRank()) {
                System.out.println("You won!");
                playerHand.addAll(tableCards);
            } else {
                System.out.println("It's a tie, I Declare War again!");
            }
        } while (topDealerCard.getRank() == topPlayerCard.getRank() && !checkIfEitherAreEmpty());
    }


    public int getNumberOfCardsToPlay(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        return (playerHand.size() >= 3 && dealerHand.size() >= 3) ? 3 :
                (dealerHand.size() < playerHand.size())? dealerHand.size(): playerHand.size();
    }

    public boolean checkIfEitherAreEmpty(){
        if(playerHand.size() == 0 || dealerHand.size() == 0){
            return true;
        }
        return false;
    }


    public void end() {
        String winner = "And the winner is ";
        winner += (playerHand.size() < dealerHand.size())? "the dealer!": getPlayerName();
        System.out.println(winner + "\nIf you want to play again, enter 'yes', or enter anything else to return to the casino");
        Scanner input = new Scanner(System.in);
        playerHand.clear();
        dealerHand.clear();
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

