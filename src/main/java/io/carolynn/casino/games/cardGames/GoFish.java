package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;
import io.carolynn.casino.cards.Rank;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends CardGame {

    private Person player;
    private Person dealer;
    private Deck houseDeck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private int playerBook;
    private int dealerBook;


    public GoFish(Person player){
        super(player);
        this.dealer = new Person("Dealer");
        this.houseDeck = new Deck();
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
        this.playerBook = 0;
        this.dealerBook = 0;
    }


    public Person getPlayer() { return super.getPlayer(); }

    public void setPlayer(Person player1) { this.player = player1; }

    public Person getDealer() { return dealer; }

    public void setDealer(Person dealer) { this.dealer = dealer; }

    public Deck getHouseDeck() { return houseDeck; }

    public void setHouseDeck(Deck houseDeck) { this.houseDeck = houseDeck; }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(ArrayList<Card> playerHand) { this.playerHand = playerHand; }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(ArrayList<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public int getPlayerBook() {
        return playerBook;
    }

    public void setPlayerBook(int playerBook) {
        this.playerBook = playerBook;
    }

    public int getDealerBook() {
        return dealerBook;
    }

    public void setDealerBook(int dealerBook) {
        this.dealerBook = dealerBook;
    }

    @Override
    public void start() {
        playerHand = houseDeck.dealHand(7);
        dealerHand = houseDeck.dealHand(7);
        System.out.println("**Welcome to Go Fish!**\n" +
                "When choosing card enter 1 for Ace, 11 for Jack, 12 for Queen, 13 for King");
        runGame();
    }

    @Override
    public void runGame() {
        try {
            do {
                userTurn();
                Thread.sleep(1000);
                dealerTurn();
                Thread.sleep(1000);
            } while (cardCountCheck());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        whoWonTheGame();
        end();
    }

    public void userTurn(){
        int hasCard = 0;
        do{
            hasCard = playerAsks(playerCardChoice());
        }while(hasCard != 0 && cardCountCheck());

    }

    public int playerCardChoice(){
        Scanner scanner = new Scanner(System.in);
        Integer numberValue = 0;
        do {
            System.out.println("Your turn! Your hand is: " + displayCards(playerHand) + "\nWhat card value do you want to " +
                    "request from the dealer?");
            String userChoice = scanner.nextLine().toLowerCase();
            numberValue = Rank.inputValueConversion(userChoice);
        } while(numberValue == 0);
        return numberValue;
    }


    public int playerAsks(int choice){
        int hasCard = doYouHaveCard(choice, dealerHand);
        if(hasCard == 1){
            System.out.println("Dealer has a " + choice);
            swapCards(choice,dealerHand,playerHand);
        } else if(hasCard>1){
            System.out.println("Dealer has " + hasCard + " " + choice + "s.");
            swapCards(choice,dealerHand,playerHand);
        } else if(hasCard == 0) {
            System.out.println("Dealer has no " + choice + "s. Go Fish!");
            hasCard = playerGoFish(choice, playerHand);
        }
        playerBookRemoval(choice);
        return hasCard;
    }

    private int playerGoFish(int desiredCard, ArrayList<Card> hand){
        cardCountCheck();
        int wish = 0;
        Card card = houseDeck.drawCard();
        hand.add(card);
        System.out.println("\nCard fished: " + card.toString());
        if (card.getRank() == desiredCard) {
            wish = 1;
            System.out.println("You fished your wish! You get to take another turn");
        } else {
            System.out.println("You didn't fish your wish.");
        }
        playerBookRemoval(card.getRank());
        return wish;
    }

    private void playerBookRemoval(int cardValue){
        if (bookCountCheck(cardValue, playerHand)) {
            System.out.println("Congratulations, you now have 4 " + cardValue + "s! You scored a book!");
            setPlayerBook(playerBook + 1);
            ArrayList<Card> book = new ArrayList<>();
            for (Card card1 : playerHand) {
                if(card1.getRank() == cardValue) {
                    book.add(card1);
                }
            }
            playerHand.removeAll(book);
        }
    }

    public void dealerTurn(){
        int cards = 0;
        do {
            int dealerCard = dealerCardChoice();
            System.out.println("\nDealer's turn!  Do you have any " + dealerCard + "s?");
            cards = doYouHaveCard(dealerCard, playerHand);
            if(cards >= 1){
                System.out.println("Dealer takes your " + dealerCard + "s.");
                swapCards(dealerCard,playerHand,dealerHand);
            } else {
                System.out.println("Dealer has to Go Fish!\n");
                cards = dealerGoFish(dealerCard,dealerHand);
            }
            dealerBookRemoval(dealerCard);
        }while(cards != 0 && cardCountCheck());

    }

    public int dealerCardChoice(){
        int x = (int)Math.floor(Math.random()*dealerHand.size());
        return dealerHand.get(x).getRank();
    }

    private int dealerGoFish(int desiredCard, ArrayList<Card> hand){
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        int wish = 0;
        if(cardCountCheck()) {
            Card card = houseDeck.drawCard();
            if (card.getRank() == desiredCard) {
                wish = 1;
                System.out.println("Dealer fished his wish! Dealer gets another turn.");
            } else {
                System.out.println("Dealer didn't fish his wish.");
            }
            hand.add(card);
            dealerBookRemoval(card.getRank());
        }
        return wish;
    }

    private void dealerBookRemoval(int cardValue) {
        if (bookCountCheck(cardValue, dealerHand)) {
            System.out.println("Dealer now has 4 " + cardValue + "s! Dealer scored a book!");
            setDealerBook(dealerBook + 1);
            ArrayList<Card> book = new ArrayList<>();
            for (Card card1 : dealerHand) {
                if (card1.getRank() == cardValue)
                    book.add(card1);
            }
            dealerHand.removeAll(book);
        }
    }


    public int doYouHaveCard(int cardValue, ArrayList<Card> hand) {
        int howManyCards = 0;
        for (Card card: hand) {
            if (cardValue == card.getRank()) {
                howManyCards++;
            }
        }
        return howManyCards;
    }

    public void swapCards(int userInput, ArrayList<Card> giver, ArrayList<Card> receiver){
        ArrayList<Card> cards = new ArrayList<>();
        for(Card card:giver){
            if(userInput == card.getRank()){
                cards.add(card);
            }
        }
        giver.removeAll(cards);
        receiver.addAll(cards);
    }


    private boolean bookCountCheck(int cardValue, ArrayList<Card> hand){
        int count = 0;
        for(Card card:hand){
            if(card.getRank() == cardValue) count++;
        }
        if(count == 4) return true;
        return false;
    }

    public boolean cardCountCheck(){
        if(houseDeck.getDeckSize()>0 && playerHand.size()>0 && dealerHand.size()>0) return true;
        return false;
    }


    public String displayCards(ArrayList<Card> hand){
        StringBuilder builder = new StringBuilder();
        for(Card card: hand){
            builder.append(card.toString()).append(" ");
        }
        return builder.toString();
    }


    public void whoWonTheGame(){
        if (playerBook > dealerBook){
            System.out.println("**You Won!**\nYou won the game with a Book Score of " + playerBook + "!\nDealer had a Book Score of " + dealerBook + "!");
        } else if (playerBook == dealerBook) {
            System.out.println("**You Tied!**\n"+ "You both had a Book Score of " + playerBook+ "!");
        } else {
            System.out.println("**You Lost!**\nDealer won with a Book Score of " + dealerBook + "!\nYou had a Book Score of " + playerBook + "!");
        }
    }

    public void end() {
        Scanner anotherRoundScanner = new Scanner(System.in);
        System.out.println("Play another round? Type y for yes, press any other key to return to menu");
        if (anotherRoundScanner.nextLine().equalsIgnoreCase("y")) {
            start();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Luis");
        GoFish game = new GoFish(person);
        game.start();
    }

}
