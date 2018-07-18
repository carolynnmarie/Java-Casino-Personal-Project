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


    public GoFish(Person player){
        super(player);
        this.dealer = new Person("Dealer");
        this.houseDeck = new Deck();
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
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



    @Override
    public void start() {
        setPlayerHand();
        setDealerHand();
        System.out.println("**Welcome to Go Fish!**\nWhen choosing card enter 1 for Ace, 11 for Jack, 12 for Queen, 13 for King");
        runGame();
    }

    @Override
    public void runGame() {

    }


    public void userTurn(){
        Scanner input = new Scanner(System.in);
        int fish = 0;
        int userChoice = 0;
        do {
            do{
                System.out.println("****Player's Turn****\n Your current hand: " +
                        displayCards(getPlayerHand()) + "\nChoose a card value to request from dealer\n");
                while(!input.hasNextInt()) input.next();
                userChoice = input.nextInt();
            } while (userChoice <=0 || userChoice>13);
            fish = turn(getPlayer(), getDealer(), userChoice);
        } while (fish == 1);
        dealerTurn();
    }

    public void dealerTurn(){
        int fish = 0;
        do{
            System.out.println("****Dealer's turn****");
            int random = (int)Math.round(Math.random()*(getDealerHand().size()-1));
            int cardValue = getDealerHand().get(random).getRank();
            System.out.println("\nDo you have any " + cardValue + "'s?\n");
            fish = turn(getDealer(),getPlayer(),cardValue);

        } while(fish == 1);
        userTurn();
    }

    public int turn(Person personOne, Person personTwo, int cardValue){
        int fish = 0;
        if (doYouHaveCard(cardValue, personOne.getHand())) {
            System.out.println(personOne.getName() + " has a " + cardValue + "." + personTwo.getName() +  " gets the card and takes another turn. ");
            swapCards(cardValue, personOne.getHand(), personTwo.getHand());
            bookCountCheck(cardValue, personOne);
            fish = 1;
        } else {
            System.out.println(personOne.getName() + " doesn't have any " + cardValue + "'s. " + personTwo.getName() +  " has to go fish!");
            fish = goFishTurn(cardValue,personTwo.getHand());
            bookCountCheck(cardValue, personTwo);
        }
        cardCountCheck(personOne.getHand(), personTwo.getHand());
        return fish;
    }

    public boolean doYouHaveCard(int randomCard, ArrayList<Card> hand) {
        boolean yOrN = false;
        for (int i = 0; i < checkNumberOfCards(hand); i++) {
            if (randomCard == hand.get(i).getRank()) {
                yOrN = true;
                break;
            }
        }
        return yOrN;
    }

    public void swapCards(int userInput, ArrayList<Card> giver, ArrayList<Card> receiver){
        for(int i = 0; i< checkNumberOfCards(giver); i++){
            if(userInput == giver.get(i).getRank()){
                receiver.add(giver.get(i));
                giver.remove(i);
            }
        }
        cardCountCheck(giver);
    }

    private int goFishTurn(int desiredCard, ArrayList<Card> pullsCard){
        int wish = 0;
        cardCountCheck(pullsCard);
        System.out.println("******************* Go Fish! ********************");
        houseDeck.shuffleDeck();
        Card card = houseDeck.drawCard();
        pullsCard.add(card);
        System.out.println("Card fished: " + card.toString());
        if (card.getRank() == desiredCard) {
            wish = 1;
            System.out.println("You fished your wish! You get to take another turn");
        }
        cardCountCheck(pullsCard);
        return wish;
    }


    private void bookCountCheck(int cardRank, Person person){
        ArrayList<Card> personHand = person.getHand();
        int num = 0;
        for(int i = 0; i < checkNumberOfCards(personHand); i++) {
            if (cardRank == personHand.get(i).getRank()) { num++; }
        }
        if (num == 4) {
            for (int j = checkNumberOfCards(personHand) - 1; j >= 0 ; j--) {
                if (cardRank == personHand.get(j).getRank()){
                    personHand.remove(personHand.get(j));
                }
            }
            person.setBook(person.getBook()+1);
            System.out.println("\nYou Scored a Book! (Four of a kind)\nYour Book Total: " + person.getBook());
        }
    }

    public void cardCountCheck(ArrayList<Card> person){
        if (houseDeck.getDeckSize() == 0 || checkNumberOfCards(person) == 0){
            System.out.println("Out of cards!");
            whoWonTheGame();
        }
    }

    public void cardCountCheck(ArrayList<Card> person, ArrayList<Card> dealer){
        if (houseDeck.getDeckSize() == 0 || checkNumberOfCards(person) == 0 || checkNumberOfCards(dealer)==0){
            System.out.println("Out of cards!");
            whoWonTheGame();
        }
    }

    public void whoWonTheGame(){
        if (player.getBook() > dealer.getBook()){
            System.out.println("*************************  You Won!  *************************" +
                    "You won the game with a total Book Score of " + player.getBook() + "!\n" +
                    "Dealer lost game with a total Book Score of " + dealer.getBook() + "!\n" +
                    "*************************  You Won!  *************************\n");
        } else if (player.getBook() == dealer.getBook()) {
            System.out.println("*************************  You Tied!  *************************"+
                    "Both Players Tied with a total Book Score of " + player.getBook()+ "!\n"+
                    "*************************  You Tied!  *************************\n");
        } else {
            System.out.println("*************************  You Lost!  *************************"+
                    "           You Lost! Dealer had a Book Score of " + dealer.getBook() + "!\n" +
                    "                 You had a Book Score of " + player.getBook() + "!\n"+
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

