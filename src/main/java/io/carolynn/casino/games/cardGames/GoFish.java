package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

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


    public Person getPlayer() {
        return super.getPlayer();
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Person getDealer() {
        return dealer;
    }

    public void setDealer(Person dealer) {
        this.dealer = dealer;
    }

    public Deck getHouseDeck() {
        return houseDeck;
    }

    public void setHouseDeck(Deck houseDeck) {
        this.houseDeck = houseDeck;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand() {
        player.setHand(houseDeck.dealHand(7));
        this.playerHand = player.getHand();
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand() {
        dealer.setHand(houseDeck.dealHand(7));
        this.dealerHand = dealer.getHand();
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
        setPlayerHand();
        setDealerHand();
        System.out.println("**Welcome to Go Fish!**\nWhen choosing card enter 1 for Ace, 11 for Jack, 12 for Queen, 13 for King");
        runGame();

    }

    @Override
    public void runGame() {
        do {
            userTurn();
            dealerTurn();
        } while(houseDeck.getDeckSize()>0 && playerHand.size()>0 && dealerHand.size()>0);
    }

    public void userTurn(){
        int choice = userCardChoice();
        userAsks(choice);
        if (bookCountCheck(choice, playerHand)) {
            System.out.println("Congratulations, you now have 4 " + choice + "s! You scored a book!");
            setPlayerBook(playerBook+1);
        }
    }

    public int userCardChoice(){
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        do{
            System.out.println("Your turn! Your hand is: " + displayCards(playerHand) + "\nWhat card value do you want to" +
                    "request from the dealer?");
            userChoice = scanner.nextInt();

        } while(userChoice>13 || userChoice<1);
        return userChoice;
    }

    public void userAsks(int choice){
        int hasCard = doYouHaveCard(choice, dealerHand);
        do{
            if(hasCard == 1){
                System.out.println("Dealer has a " + choice);
                swapCards(choice,dealerHand,playerHand);
            } else if(hasCard>1){
                System.out.println("Dealer has " + hasCard + " cards with a value of " + choice);
                swapCards(choice,dealerHand,playerHand);
            } else {
                System.out.println("Dealer has no cards with a value of " + choice + ". Go Fish!");
                goFishTurn(choice, playerHand);
            }
        } while(doYouHaveCard(choice,dealerHand) !=0);
    }

    public void dealerTurn(){

    }

    public int doYouHaveCard(int cardValue, ArrayList<Card> hand) {
        int howManyCards = 0;
        for (int i = 0; i < checkNumberOfCards(hand); i++) {
            if (cardValue == hand.get(i).getRank()) {
                howManyCards++;
            }
        }
        return howManyCards;
    }

    public void swapCards(int userInput, ArrayList<Card> giver, ArrayList<Card> receiver){
        for(int i = 0; i< checkNumberOfCards(giver); i++){
            if(userInput == giver.get(i).getRank()){
                receiver.add(giver.get(i));
                giver.remove(i);
            }
        }
        handCountCheck(giver);
    }

    private int goFishTurn(int desiredCard, ArrayList<Card> hand){
        checkIfDeckEmpty();
        int wish = 0;
        Card card = houseDeck.drawCard();
        hand.add(card);
        System.out.println("Card fished: " + card.toString());
        if (card.getRank() == desiredCard) {
            wish = 1;
            System.out.println("You fished your wish! You get to take another turn");
        }
        return wish;
    }


    private boolean bookCountCheck(int CardValue, ArrayList<Card> hand){
        for(int i = 0; i<hand.size(); i++){
            if(duplicateCardCount(CardValue, hand) == 4) {
                return true;
            }
        }
        return false;
    }

    public int duplicateCardCount(int cardValue, ArrayList<Card> hand){
        int count = 0;
        for(int i = 0; i<hand.size(); i++){
            if(hand.get(i).getRank().equals(cardValue))count++;
        }
        return count;
    }

    public void checkIfDeckEmpty(){
        if(houseDeck.getDeckSize() == 0){
            System.out.println("There are no more cards in the deck, time to determine the winner!");
            whoWonTheGame();
        }
    }

    public void handCountCheck(ArrayList<Card> person){
        if (checkNumberOfCards(person) == 0){
            System.out.println("Giver is out of cards! Time to determine the winner!");
            whoWonTheGame();
        }
    }

    public void handCountCheck(ArrayList<Card> person, ArrayList<Card> dealer){
        if (houseDeck.getDeckSize() == 0 || checkNumberOfCards(person) == 0 || checkNumberOfCards(dealer)==0){
            System.out.println("Out of cards!");
            whoWonTheGame();
        }
    }

    public void whoWonTheGame(){
        if (playerBook > dealerBook){
            System.out.println("*************************  You Won!  *************************" +
                    "You won the game with a total Book Score of " + playerBook + "!\n" +
                    "Dealer lost game with a total Book Score of " + dealerBook + "!\n" +
                    "*************************  You Won!  *************************\n");
        } else if (playerBook == dealerBook) {
            System.out.println("*************************  You Tied!  *************************"+
                    "Both Players Tied with a total Book Score of " + player.getBook()+ "!\n"+
                    "*************************  You Tied!  *************************\n");
        } else {
            System.out.println("*************************  You Lost!  *************************"+
                    "           You Lost! Dealer had a Book Score of " + dealerBook + "!\n" +
                    "                 You had a Book Score of " + playerBook + "!\n"+
                    "*************************  You Lost!  *************************\n");
        }
        end();
    }

    public void end() {
        player.setBook(0);
        dealer.setBook(0);
        playerHand.clear();
        dealerHand.clear();
        Scanner anotherRoundScanner = new Scanner(System.in);
        System.out.println("Play another round? yes or no...");
        if (anotherRoundScanner.nextLine().equalsIgnoreCase("yes")) {
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

    public int checkNumberOfCards(ArrayList<Card> hand){
        return hand.size();
    }

    public String displayCards(ArrayList<Card> hand){
        String stringHand = "";
        for(Card card: hand){
            stringHand += card.toString() + " ";
        }
        return stringHand; }


}

