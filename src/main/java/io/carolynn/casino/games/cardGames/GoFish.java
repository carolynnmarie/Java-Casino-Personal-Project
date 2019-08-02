package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;
import io.carolynn.casino.cards.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class GoFish extends CardGame {


    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private int playerBook;
    private int dealerBook;


    public GoFish(Person player){
        super(player);
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
        this.playerBook = 0;
        this.dealerBook = 0;
    }


    public Person getPlayer() { return super.getPlayer(); }

    public ArrayList<Card> getPlayerHand() { return playerHand; }

    public void setPlayerHand(ArrayList<Card> playerHand) { this.playerHand = playerHand; }

    public void setDealerHand(ArrayList<Card> dealerHand) { this.dealerHand = dealerHand; }

    public void setPlayerBook(int playerBook) { this.playerBook = playerBook; }

    public void setDealerBook(int dealerBook) { this.dealerBook = dealerBook; }

    @Override
    public void start() {
        System.out.println("**Welcome to Go Fish!**");
        playerHand = houseDeck.dealHand(7);
        dealerHand = houseDeck.dealHand(7);
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
        determineWinner();
        end();
    }

    public void userTurn(){
        int hasCard = 0;
        do{
            int choice = (playerCardChoice());
            hasCard = doYouHaveCard(choice, dealerHand);
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
        }while(hasCard != 0 && cardCountCheck());
    }

    public int playerCardChoice(){
        Scanner scanner = new Scanner(System.in);
        Integer numberValue = 0;
        do {
            System.out.println("Your turn! Your hand is: " + displayCards(playerHand) + "\nWhat card value do you want to " +
                    "request from the dealer?");
            String userChoice = scanner.nextLine();
            numberValue = Rank.inputValueConversion(userChoice);
        } while(numberValue == 0);
        return numberValue;
    }


    public int playerGoFish(int desiredCard, ArrayList<Card> hand){
        cardCountCheck();
        int wish;
        Card card = houseDeck.drawCard();
        hand.add(card);
        System.out.println();
        StringBuilder builder = new StringBuilder("\nCard fished: " + card.toString());
        if (card.getRank() == desiredCard) {
            wish = 1;
            builder.append("You fished your wish! You get to take another turn");
        } else {
            builder.append("You didn't fish your wish.");
            wish = 0;
        }
        System.out.println(builder.toString());
        playerBookRemoval(card.getRank());
        return wish;
    }

    public void playerBookRemoval(int cardValue){
        if (bookCountCheck(cardValue, playerHand)) {
            System.out.println("Congratulations, you now have 4 " + cardValue + "s! You scored a book!");
            setPlayerBook(playerBook + 1);
            List<Card> book = playerHand.stream().filter(card -> card.getRank()==cardValue).collect(Collectors.toList());
            playerHand.removeAll(book);
        }
    }

    public void dealerTurn(){
        int cards = 0;
        do {
            Collections.shuffle(dealerHand);
            int dealerCard = dealerHand.get(0).getRank();
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
            List<Card> book = dealerHand.stream().filter(card -> card.getRank() == cardValue).collect(Collectors.toList());
            dealerHand.removeAll(book);
        }
    }

    public int doYouHaveCard(int cardValue, ArrayList<Card> hand) {
        return (int)hand.stream().filter(card -> card.getRank()==cardValue).count();
    }

    public void swapCards(int userInput, ArrayList<Card> giver, ArrayList<Card> receiver){
        List<Card> cards = giver.stream().filter(card -> card.getRank()==userInput).collect(Collectors.toList());
        giver.removeAll(cards);
        receiver.addAll(cards);
    }


    private boolean bookCountCheck(int cardValue, ArrayList<Card> hand){
        int count = (int) hand.stream().filter(card->card.getRank()==cardValue).count();
        if(count == 4) return true;
        return false;
    }

    private boolean cardCountCheck(){
        if(houseDeck.getDeckSize()>0 && playerHand.size()>0 && dealerHand.size()>0) return true;
        return false;
    }


    public String displayCards(ArrayList<Card> hand){
        StringBuilder builder = new StringBuilder();
        hand.stream().forEach(card -> builder.append(card.toString()).append(" "));
        return builder.toString();
    }


    public void determineWinner(){
        if (playerBook > dealerBook){
            System.out.println("**You Won!**\nYou won the game with a Book Score of " + playerBook +
                    "!\nDealer had a Book Score of " + dealerBook + "!");
        } else if (playerBook == dealerBook) {
            System.out.println("**You Tied!**\n"+ "You both had a Book Score of " + playerBook+ "!");
        } else {
            System.out.println("**You Lost!**\nDealer won with a Book Score of " + dealerBook + "!\nYou had a Book Score of "
                    + playerBook + "!");
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
