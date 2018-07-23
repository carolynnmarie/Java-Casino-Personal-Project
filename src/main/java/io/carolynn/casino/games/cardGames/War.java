package io.carolynn.casino.games.cardGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.cards.Card;
import io.carolynn.casino.cards.Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class War extends CardGame {

    private Deck houseDeck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;

    public War(Person player){
        super(player);
        this.houseDeck = new Deck();
        this.playerHand = houseDeck.dealHand(26);
        this.dealerHand = houseDeck.getDeck();
    }

    @Override
    public Deck getHouseDeck() {
        return houseDeck;
    }

    @Override
    public void setHouseDeck(Deck houseDeck) {
        this.houseDeck = houseDeck;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    @Override
    public void start() {
        String answer = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to WAR!\nEnter\"exit\" at any time to exit the game.\nPress enter to flip your card");
        do {
            answer = scan.nextLine();
            if(!answer.equals("exit")) {
                runGame();
            }
        } while(!checkIfEitherAreEmpty()&& !answer.equals("exit"));
        declareWinner();
    }


    public void runGame() {
        ArrayList<Card> table = new ArrayList<>();
        Card playerCard = playerHand.remove(0);
        Card dealerCard = dealerHand.remove(0);
        table.add(playerCard);
        table.add(dealerCard);
        System.out.println("Your card: " + playerCard.toString() + "\nDealer's card: " + dealerCard.toString());
        if (playerCard.getRank() > dealerCard.getRank()) {
            playerHand.addAll(table);
            System.out.println("You won the round!\nYou have " + playerHand.size() + " cards, dealer has " +
                    dealerHand.size()+ " cards.");
        } else if (playerCard.getRank() < dealerCard.getRank()) {
            dealerHand.addAll(table);
            System.out.println("Dealer won the round!\nYou have " + playerHand.size() + " cards, dealer has " +
                    dealerHand.size()+ " cards.");
        } else {
            if (!checkIfEitherAreEmpty()) {
                System.out.println("It's a tie!  \n***I Declare War!***\n");
                try{
                    Thread.sleep(750);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(iDeclareWar()){
                    playerHand.addAll(table);
                } else {
                    dealerHand.addAll(table);
                }
                System.out.println("You have " + playerHand.size() + " cards, dealer has " + dealerHand.size()+ " cards.");
            }
        }
    }


    public boolean iDeclareWar(){
        ArrayList<Card> warPile = new ArrayList<>();
        boolean whoWon = true;
        Card topDealerCard = dealerHand.get(0);
        Card topPlayerCard = playerHand.get(0);
        do{
            int numOfCards = determineNumberOfCardsPlayed(playerHand,dealerHand);
            topDealerCard = dealerHand.get(numOfCards - 1);
            topPlayerCard = playerHand.get(numOfCards - 1);
            System.out.println("Dealer's top card: " + topDealerCard.toString() + ".\nYour top card: " +
                    topPlayerCard.toString());
            warPile.addAll(createWarTablePile(numOfCards));
            if (topDealerCard.getRank() > topPlayerCard.getRank()) {
                System.out.println("Dealer won!");
                dealerHand.addAll(warPile);
                whoWon = false;
            } else if (topDealerCard.getRank() < topPlayerCard.getRank()) {
                System.out.println("You won!");
                playerHand.addAll(warPile);
            } else {
                System.out.println("It's a tie, I Declare War again!");
            }
        } while (topDealerCard == topPlayerCard && !checkIfEitherAreEmpty());
        return whoWon;
    }

    public ArrayList<Card> createWarTablePile(int numberOfCards){
        ArrayList<Card> warWin = new ArrayList<>();
        for(int i = 0; i<numberOfCards; i++){
            warWin.add(playerHand.remove(0));
            warWin.add(dealerHand.remove(0));
        }
        return warWin;
    }

    public int determineNumberOfCardsPlayed(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        return (playerHand.size() >= 3 && dealerHand.size() >= 3) ? 3 :
                (playerHand.size()>=3 && dealerHand.size()<3) ? dealerHand.size() :
                        (dealerHand.size()>=3 && playerHand.size()<3)?playerHand.size() :
                                (dealerHand.size() < playerHand.size())? dealerHand.size(): playerHand.size();
    }

    public boolean checkIfEitherAreEmpty(){
        if(playerHand.size() == 0 || dealerHand.size() == 0){
            return true;
        }
        return false;
    }


    public void declareWinner(){
        String winner = "And the winner is ";
        winner += (playerHand.size() < dealerHand.size())? "the dealer!": getPlayer().getName();
        System.out.println(winner);
        end();
    }

    public void end() {
        Scanner input = new Scanner(System.in);
        playerHand.clear();
        playerHand.clear();
        System.out.println("If you want to play again, enter 'yes', or enter anything else to return to the casino");
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

