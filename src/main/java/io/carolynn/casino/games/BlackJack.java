package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends CardGame{

    private Person player;
    private Person dealer;
    private Deck houseDeck;
    private int bet;



    public BlackJack(Person player) {
        this.player = player;
        this.dealer = new Person("Dealer");
        this.houseDeck = new Deck();
        this.bet = 0;

    }

    public void setBet(int bet){
        this.bet = bet;
    }
    public int getBet(){
        return bet;
    }
    public String getPlayerName(){
        return  this.player.getName();
    }
    public Person getPlayer(){
        return this.player;
    }




    @Override
    public void start() {
        Scanner input = new Scanner(System.in);
        int chips = 0;
        do {
            System.out.println("Welcome to BlackJack, " + getPlayerName() + ". Please enter the number of chips for your starting bet");
            chips = input.nextInt();
            if (chips <= player.getChips()) {
                setBet(chips);
                player.setChips(player.getChips()-chips);
            } else {
                System.out.println("Insufficient funds.  You currently have: " + player.getChips() + "Enter new amount");
            }
        } while (chips > player.getChips());
        runGame();
    }

    @Override
    public void runGame() {
        Deck playerHand = dealHands(4);
        Deck dealerHand = dealHands(4);
        String dealerTwoCards = dealerHand.getDeck().get(0).toString() + dealerHand.getDeck().get(1).toString();
        System.out.println("Your cards: " + playerHand.toString() + ". Dealer's first two cards: " + dealerTwoCards);
        int playerCount = valueSum(playerHand);
        System.out.println(bustOrBlackJack(playerCount));
        if(playerCount<21) {
            playerHand = playerTurn(playerHand);
            playerCount = valueSum(playerHand);
        }
        if(playerCount<21){
            dealerHand = dealerTurn(dealerHand);
        }
        int dealerCount = valueSum(dealerHand);
        if(dealerCount<21){
            System.out.println(determineWinner(playerCount, dealerCount));
        }
        end();
    }

    public int valueSum(Deck deck){
        int cardValue;
        int totalValue = 0;
        int countAce = 0;
        for(Card card: deck.getDeck()){
            cardValue = card.getRank()==11? 10: card.getRank()==12? 10: card.getRank()==13? 10: card.getRank();
            totalValue += cardValue;
            if(card.getRank()==1) countAce++;
        }
        if(countAce==1 && totalValue<=11){
            totalValue+=10;
        }
        return totalValue;
    }

    public Deck playerTurn(Deck playerHand){
        Scanner scan = new Scanner(System.in);
        String answer = "";
        int playerSum = 0;
        do{
            System.out.println("Would you like to hit or stay? Press h for hit, any other key for stay");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("h")){
                playerHand.addCard(houseDeck.drawCard());
                playerSum = valueSum(playerHand);
                System.out.println(bustOrBlackJack(playerSum));
            } else {
                break;
            }
        } while(playerSum<21);
        return playerHand;
    }

    public Deck dealerTurn(Deck dealerHand){
        int dealerSum = valueSum(dealerHand);
        String d = "";
        while(dealerSum<16){
            System.out.println("Dealer's cards are: " + dealerHand.toString() + ". Dealer drawing a card.");
            dealerHand.addCard(houseDeck.drawCard());
            System.out.println("Dealer's cards are now: " + dealerHand.toString());
            dealerSum = valueSum(dealerHand);
        }
        if(dealerSum==21){
            d ="Dealer gets BlackJack! You lose your bet of " + getBet();
        } else if(dealerSum>21) {
            d = "Dealer busts!  You win " + getWinnings() + " chips.";
            player.addChips(getBet() + getWinnings());
        } else {
            d = "Dealer's cards value sum is " + dealerSum;
        }
        System.out.println(d);
        return dealerHand;
    }

    public String bustOrBlackJack(int handCount) {
        String bOrB = "";
        if (handCount > 21) {
            bOrB = "Bust! Your total card value is " + handCount + ". You lost " + getBet() + " chips.";
        } else if (handCount == 21) {
            bOrB = "BlackJack!  You keep your bet amount and get " + getWinnings() + " more chips.";
            getPlayer().addChips(getBet() + getWinnings());
        } else {
            bOrB = "Your total card value is " + handCount;
        }
        return bOrB;
    }

    public String determineWinner(int playerCount, int dealerCount){
        String winner = "";
        if(playerCount == dealerCount){
            winner = "It's a tie! You keep the chips you bet\n";
        } else if(playerCount>dealerCount){
            winner = "Congratulations, " + getPlayerName() + "You won! You keep the chips you bet and get " + getWinnings() + " more chips.\n";
            getPlayer().addChips(getBet() + getWinnings());
        } else {
            winner = "Dealer wins! You lost your bet of " + getBet() + " chips.\n";
        }
        return winner;
    }

    public int getWinnings(){
        return (int)Math.round(bet * .5);
    }

    @Override
    public void end() {
        houseDeck = new Deck();
        setBet(0);
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play again? Type y to play again, or press other key to exit the game");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            start();
        }else {
            System.out.println("Thank you for playing BlackJack. You will now return to the main menu.");
        }
    }

}
