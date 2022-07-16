package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.UnicodeCard;
import io.carolynn.casino.cards.UnicodeDeck;

import java.util.ArrayList;
import java.util.Scanner;

public class War extends CardGame {

    private UnicodeDeck playerHand;
    private UnicodeDeck dealerHand;
    private ArrayList<UnicodeCard> tableCards;
    private ArrayList<UnicodeCard> playerDiscard;
    private ArrayList<UnicodeCard> dealerDiscard;
    private UnicodeDeck houseDeck;


    public War(Person player){
        super(player);
        this.playerHand = new UnicodeDeck();
        this.dealerHand = new UnicodeDeck();
        this.tableCards = new ArrayList<>();
        this.playerDiscard = new ArrayList<>();
        this.dealerDiscard = new ArrayList<>();
        this.houseDeck = new UnicodeDeck();
    }

    @Override
    public void start() {
        String answer = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to WAR!\nEnter\"exit\" at any time to exit the game.\nPress enter to flip your card");
        dealHands();
        do {
            answer = scan.nextLine();
            if(!answer.equals("exit")) {
                runGame();
            }
        } while(!checkIfEitherAreEmpty()&& !answer.equals("exit"));
        end();
    }

    public void dealHands(){
        playerHand.setDeck(houseDeck.dealCards(26));
        dealerHand.setDeck(houseDeck.getDeck());
    }

    public void runGame() {
        UnicodeCard playerCard = playerHand.removeCard(0);
        UnicodeCard dealerCard = dealerHand.removeCard(0);
        tableCards.add(playerCard);
        tableCards.add(dealerCard);
        System.out.println("Your card: " + playerCard.toString() + "  Dealer's card: " + dealerCard.toString());
        if (playerCard.getValue() > dealerCard.getValue()) {
            playerHand.addCards(tableCards);
            System.out.println("You won the round!\nYou have " + playerHand.getDeckSize() + " cards, dealer has "
                    + dealerHand.getDeckSize()+ " cards.");
        } else if (playerCard.getValue() < dealerCard.getValue()) {
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
        UnicodeCard topDealerCard;
        UnicodeCard topPlayerCard;
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
            String winnings = printWarWinnings(tableCards);
            if (topDealerCard.getValue() > topPlayerCard.getValue()) {
                System.out.println("Dealer won!  Dealer won the following cards: " + winnings);
                dealerHand.addCards(tableCards);
            } else if (topDealerCard.getValue() < topPlayerCard.getValue()) {
                System.out.println("You won! You won the following cards: " + winnings);
                playerHand.addCards(tableCards);
            } else {
                System.out.println("It's a tie, I Declare War again!");
            }
        } while (topDealerCard.getValue() == topPlayerCard.getValue() && !checkIfEitherAreEmpty());
    }

    private String printWarWinnings(ArrayList<UnicodeCard> cards){
        StringBuilder builder = new StringBuilder();
        for(UnicodeCard card: cards){
            builder.append(card.toString()).append(" ");
        }
        return builder.toString().trim();
    }
//
//    public int checkQuantityOfRank(int rank){
//
//    }




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

