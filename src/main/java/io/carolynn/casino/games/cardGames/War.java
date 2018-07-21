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
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to WAR!\nEnter \"exit\" at any time to exit the game");
            answer = scan.nextLine();
            runGame();
        } while(!answer.equalsIgnoreCase("exit") || !checkIfEitherAreEmpty());
        declareWinner();
        end();
    }


    public void runGame() {
        while (!checkIfEitherAreEmpty()) {
            Card playerCard = playerHand.get(0);
            Card dealerCard = dealerHand.get(0);
            System.out.println("You played " + playerCard + " and the dealer played " + dealerCard);
            if (playerCard.getRank() > dealerCard.getRank()) {
                playerHand.add(dealerHand.remove(0));
                playerHand.add(playerHand.remove(0));
                System.out.println("You won the round!  You now have " + playerHand.size() + " cards.  Dealer has "
                        + dealerHand.size() + " cards.");
            } else if (playerCard.getRank() < dealerCard.getRank()) {
                dealerHand.add(playerHand.remove(0));
                System.out.println("Dealer won the round.  You now have" + playerHand.size() + " cards.  Dealer has "
                        + dealerHand.size() + " cards.");
            } else {
                if(!checkIfEitherAreEmpty()){
                    System.out.println("It's a tie!  I Declare War!");
                    iDeclareWar();
                    System.out.println("You now have " + playerHand.size() + " cards.  Dealer has " + dealerHand.size() + " cards.");
                }
            }
        }
    }

    public void iDeclareWar(){
        ArrayList<Card> warPile = new ArrayList<>();
        int topDealerCard = 0;
        int topPlayerCard = 0;
        do{
            int numOfCards = (playerHand.size() >= 3 && dealerHand.size() >= 3) ? 3 :
                    (playerHand.size() > dealerHand.size()) ? dealerHand.size() : playerHand.size();
            topDealerCard = dealerHand.get(numOfCards - 1).getRank();
            topPlayerCard = playerHand.get(numOfCards - 1).getRank();
            System.out.println("Dealer's top card is a " + topDealerCard + ".  Your top card is a " + topPlayerCard);
            warPile.addAll(createWarTablePile(numOfCards));
            if (topDealerCard > topPlayerCard) {
                dealerHand.addAll(warPile);
            } else if (topDealerCard < topPlayerCard) {
                playerHand.addAll(warPile);
            } else {
                System.out.println("It's a tie, I Declare War again!");
            }
        } while (topDealerCard == topPlayerCard && !checkIfEitherAreEmpty());
    }

    public ArrayList<Card> createWarTablePile(int numberOfCards){
        ArrayList<Card> warWin = new ArrayList<>();
        for(int i = 0; i<numberOfCards; i++){
            warWin.add(playerHand.remove(0));
            warWin.add(dealerHand.remove(0));
        }
        return warWin;
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
    }

    public void end() {
        Scanner input = new Scanner(System.in);
        playerHand.clear();
        playerHand.clear();
        System.out.println("If you want to play again, enter 'yes', or enter anything else to return to the casino");;
        if (input.nextLine().equalsIgnoreCase("yes")) {
            start();
        }
    }


}

