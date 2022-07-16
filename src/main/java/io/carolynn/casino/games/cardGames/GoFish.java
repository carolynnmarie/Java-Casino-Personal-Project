package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;
import io.carolynn.casino.cards.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class GoFish extends CardGame {


    private Deck playerHand;
    private Deck dealerHand;
    private int playerBook;
    private int dealerBook;


    public GoFish(Person player){
        super(player);
        this.playerHand = new Deck();
        this.dealerHand = new Deck();
        this.playerBook = 0;
        this.dealerBook = 0;
    }


    public Person getPlayer() { return super.getPlayer(); }

    public Deck getPlayerHand() { return playerHand; }

    public void setPlayerHand(Deck playerHand) { this.playerHand = playerHand; }

    public void setDealerHand(Deck dealerHand) { this.dealerHand = dealerHand; }

    public void setPlayerBook(int playerBook) { this.playerBook = playerBook; }

    public void setDealerBook(int dealerBook) { this.dealerBook = dealerBook; }

    @Override
    public void start() {
        System.out.println("**Welcome to Go Fish!**");
        playerHand = dealCards(7);
        dealerHand = dealCards(7);
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
            String answer = "";
            if(hasCard == 1){
                answer ="Dealer has a " + choice;
                swapCards(choice,dealerHand,playerHand);
            } else if(hasCard>1){
                answer = "Dealer has " + hasCard + " " + choice + "s.";
                swapCards(choice,dealerHand,playerHand);
            } else {
                System.out.println("Dealer has no " + choice + "s. Go Fish!");
                hasCard = playerGoFish(choice, playerHand);
            }
            System.out.println(answer);
            playerBookRemoval(choice);
        }while(hasCard != 0 && cardCountCheck());
    }

    public int playerCardChoice(){
        Scanner scanner = new Scanner(System.in);
        Integer numberValue = 0;
        playerHand.sortCards();
        do {
            System.out.println("Your turn! Your hand is: " + playerHand.toString() + "\nWhat card value do you want to " +
                    "request from the dealer?");
            String userChoice = scanner.nextLine();
            numberValue = Rank.inputValueConversion(userChoice);
        } while(numberValue == 0);
        return numberValue;
    }


    public int playerGoFish(int desiredCard, Deck hand){
        cardCountCheck();
        int wish;
        Card card = houseDeck.drawCard();
        hand.addCard(card);
        StringBuilder builder = new StringBuilder("\nCard fished: " + card.toString());
        if (card.getRank() == desiredCard) {
            wish = 1;
            builder.append("You fished your wish! You get to take another turn");
        } else {
            builder.append(".  You didn't fish your wish.");
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
            List<Card> book = playerHand.getDeck().stream().filter(card -> card.getRank()==cardValue).collect(Collectors.toList());
            ArrayList<Card> list = new ArrayList<>(book);
            playerHand.removeCards(list);
        }
    }

    public void dealerTurn(){
        int cards = 0;
        String wish = "";
        do {
            Collections.shuffle(dealerHand.getDeck());
            int dealerCard = dealerHand.getDeck().get(0).getRank();
            cards = doYouHaveCard(dealerCard, playerHand);
            System.out.println("Dealer wants to know if you have any " + dealerCard + "s");
            if(cards >= 1){
                wish = "You do! Dealer takes your " + dealerCard + "s.";
                swapCards(dealerCard,playerHand,dealerHand);
            } else {
                System.out.println("You do not! Dealer has to Go Fish!");
                cards = dealerGoFish(dealerCard,dealerHand);
            }
            System.out.println(wish);
            dealerBookRemoval(dealerCard);
            wish = "";
        }while(cards != 0 && cardCountCheck());
    }


    private int dealerGoFish(int desiredCard, Deck hand){
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        int wish = 0;
        String fishWish = "";
        if(cardCountCheck()) {
            Card card = houseDeck.drawCard();
            if (card.getRank() == desiredCard) {
                wish = 1;
                fishWish ="Dealer fished his wish! Dealer gets another turn.";
            } else {
                fishWish ="Dealer didn't fish his wish.";
            }
            System.out.println(fishWish);
            hand.addCard(card);
            dealerBookRemoval(card.getRank());
        }
        return wish;
    }

    private void dealerBookRemoval(int cardValue) {
        if (bookCountCheck(cardValue, dealerHand)) {
            System.out.println("Dealer now has 4 " + cardValue + "s! Dealer scored a book!");
            setDealerBook(dealerBook + 1);
            List<Card> book = dealerHand.getDeck().stream().filter(card -> card.getRank() == cardValue).collect(Collectors.toList());
            dealerHand.removeCards(book);
        }
    }

    public int doYouHaveCard(int cardValue, Deck hand) {
        return (int)hand.getDeck().stream().filter(card -> card.getRank()==cardValue).count();
    }

    public void swapCards(int userInput, Deck giver, Deck receiver){
        List<Card> cards = giver.getDeck().stream().filter(card -> card.getRank()==userInput).collect(Collectors.toList());
        ArrayList<Card> list = new ArrayList(cards);
        giver.removeCards(list);
        receiver.addCards(list);
    }


    private boolean bookCountCheck(int cardValue, Deck hand){
        int count = 0;
        for(Card card: hand.getDeck()){
            if(card.getRank() == cardValue){
                count++;
            }
        }
        if(count == 4) return true;
        return false;
    }

    private boolean cardCountCheck(){
        if(houseDeck.getDeckSize()>0 && playerHand.getDeckSize()>0 && dealerHand.getDeckSize()>0) return true;
        return false;
    }

    public void determineWinner(){
        String winner = (playerBook > dealerBook)? "**You Won!**\nYou won the game with a Book Score of " + playerBook +
                    "!\nDealer had a Book Score of " + dealerBook + "!":
                (playerBook == dealerBook)? "**You Tied!**\n"+ "You both had a Book Score of " + playerBook+ "!":
                "**You Lost!**\nDealer won with a Book Score of " + dealerBook + "!\nYou had a Book Score of " + playerBook + "!";
        System.out.println(winner);
    }

    public void end() {
        Scanner anotherRound = new Scanner(System.in);
        System.out.println("Play another round? Type y for yes, press any other key to return to menu");
        if (anotherRound.nextLine().equalsIgnoreCase("y")) {
            start();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Carolynn");
        GoFish game = new GoFish(person);
        game.start();
    }

}
