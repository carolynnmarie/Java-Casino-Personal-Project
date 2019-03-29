package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

import java.util.Scanner;

public class BlackJack extends CardGame {


    private Deck houseDeck;
    private int bet;


    public BlackJack(Person player) {
        super(player);
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
        return  super.getPlayer().getName();
    }
    public Person getPlayer(){
        return super.getPlayer();
    }

    @Override
    public Deck getHouseDeck() {
        return houseDeck;
    }

    @Override
    public void start() {
        Scanner input = new Scanner(System.in);
        int chips = 0;
        do {
            System.out.println("Welcome to BlackJack, " + getPlayerName() + ". Your current chip total is " + getPlayer().getChips()
                    + ". Please enter the number of chips you would like to bet");
            chips = input.nextInt();
            if (chips <= getPlayer().getChips()) {
                setBet(chips);
                getPlayer().removeChips(getBet());
            } else {
                System.out.println("Insufficient funds.  You currently have: " + getPlayer().getChips() + "Enter new amount");
            }
        } while (chips > getPlayer().getChips());
        runGame();
    }

    @Override
    public void runGame() {
        Deck playerHand = dealHands(2);
        Deck dealerHand = dealHands(2);
        String dealerTwoCards = dealerHand.getDeck().get(0).toString() + dealerHand.getDeck().get(1).toString();
        System.out.println("Dealer's first two cards are: " + dealerTwoCards);
        int playerCount = playerTurn(playerHand);
        if(playerCount<21) {
            dealerHand = dealerTurn(dealerHand);
        }
        int dealerCount = valueSum(dealerHand);
        if(dealerCount<21 && playerCount<21){
            System.out.println(determineWinner(playerCount, dealerCount));
        }
        end();
    }



    public int playerTurn(Deck playerHand){
        Scanner scan = new Scanner(System.in);
        String answer = "";
        int playerSum = 0;
        do{
            System.out.println("Your cards are: " + playerHand.toString() + ". \n" +
                    "Would you like to hit or stay? Press h for hit, any other key for stay");
            answer = scan.nextLine();
            if(answer.equalsIgnoreCase("h")){
                Card card = getHouseDeck().drawCard();
                System.out.println("You drew a " + card.toString());
                playerHand.addCard(card);
                playerSum = valueSum(playerHand);
                System.out.println(bustOrBlackJack(playerSum));
            } else {
                break;
            }
        } while(playerSum<=21);
        return playerSum;
    }

    public Deck dealerTurn(Deck dealerHand){
        int dealerSum = valueSum(dealerHand);
        System.out.println("Dealer's cards are: " + dealerHand.toString() + "\nDealer's total is " + dealerSum);
        while(dealerSum<16){
            System.out.println("Dealer drawing a card.");
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            Card card = getHouseDeck().drawCard();
            dealerHand.addCard(card);
            dealerSum = valueSum(dealerHand);
            System.out.println("Dealer drew a " + card.toString() + ", for a new total of " + dealerSum);
        }
        dealerBustOrBlackJack(dealerSum);
        return dealerHand;
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
    private void dealerBustOrBlackJack(int dealerSum){
        String d = "";
        if(dealerSum==21){
            d ="Dealer gets BlackJack! You lose your bet of " + getBet();
        } else if(dealerSum>21) {
            d = "Dealer busts!  You keep your bet amount of " + getBet() + " and get " + getWinnings() + " more chips.";
            getPlayer().addChips(getBet() + getWinnings());
        } else {
            d = "Dealer's cards value sum is " + dealerSum;
        }
        System.out.println(d);
    }

    public String bustOrBlackJack( int handCount) {
        String bOrB = "";
        if (handCount > 21) {
            bOrB = "Bust!" + " total card value is " + handCount + ". You lost " + getBet() + " chips.";
        } else if (handCount == 21) {
            bOrB = "BlackJack!  You keep your bet amount of " + getBet() + " and get " + getWinnings() + " more chips.";
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
            winner = "Congratulations, " + getPlayerName() + ", you won! You keep the chips you bet and get " + getWinnings() +
                    " more chips.\n";
            getPlayer().addChips(getBet() + getWinnings());
        } else {
            winner = "Dealer wins! You lost your bet of " + getBet() + " chips.\n";
        }
        return winner;
    }

    public int getWinnings(){
        return (int)Math.round(getBet() * .5);
    }

    @Override
    public void end() {
        houseDeck = new Deck();
        setBet(0);
        Scanner input = new Scanner(System.in);
        System.out.println("Your currently have " + getPlayer().getChips() + " chips. Would you like to play another round " +
                "of Blackjack? Type y to play again, or press other key to exit the game");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            start();
        }else {
            System.out.println("Thank you for playing BlackJack. You will now return to the main menu.");
        }
    }

    public static void main(String[] args){
        Person person = new Person("Carolynn");
        person.setChips(200);
        BlackJack blackJack = new BlackJack(person);
        blackJack.start();
    }

}
