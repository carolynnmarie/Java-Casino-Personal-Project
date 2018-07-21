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
        } while(!answer.equalsIgnoreCase("exit") || !checkIfEitherAreEmpty(playerHand, dealerHand));
        declareWinner();
        end();
    }


    public void runGame() {
            while (checkIfEitherAreEmpty(playerHand, dealerHand)) {
                Card playerCard = playerHand.remove(0);
                Card dealerCard = dealerHand.remove(0);
                System.out.println("You played " + playerCard + " and the dealer played " + dealerCard);
                if (playerCard.getRank() == dealerCard.getRank()) {
                    warCardSwap(playerHand, dealerHand);
                    System.out.println("You now have " + playerHand.size() + " cards.  Dealer has " + dealerHand.size() + " cards.");
                } else if (playerCard.getRank() > dealerCard.getRank()) {
                    playerHand.add(playerCard);
                    playerHand.add(dealerCard);
                    System.out.println("You won the round!  You now have " + playerHand.size() + " cards.  Dealer has "
                            + dealerHand.size() + " cards.");
                } else {
                    dealerHand.add(dealerCard);
                    dealerHand.add(playerCard);
                    System.out.println("Dealer won the round.  You now have" + playerHand.size() + " cards.  Dealer has "
                            +dealerHand.size() + " cards.");
                }
            }
    }

    public void warCardSwap(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        int winCard = 0;
        do {
            if (!checkIfEitherAreEmpty(playerHand, dealerHand)) {
                break;
            }else{
                winCard = iDeclareWar(playerHand, dealerHand);
                ArrayList<Card> warWin = getWarTablePile(playerHand, dealerHand);
                if (winCard == 1) {
                    playerHand.addAll(warWin);
                } else if (winCard == 2) {
                    dealerHand.addAll(warWin);
                }
            }
        } while (winCard == 0);
    }

    public int iDeclareWar(ArrayList<Card> player1, ArrayList<Card> dealer1) {
        int x = warCardsNumber(player1, dealer1);
        System.out.println("I D E C L A R E  W A R!!\nPlayer's top card: " + player1.get(x-1) + ". Dealer's top card: " +
                dealer1.get(x-1));
        int win = (player1.get(x).getRank() > dealer1.get(x).getRank()) ? 1:
                (player1.get(x).getRank() < dealer1.get(x).getRank())? 2: 0;
        return win;
    }

    public ArrayList<Card> getWarTablePile(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        ArrayList<Card> warWin = new ArrayList<>();
        int x= warCardsNumber(playerHand,dealerHand);
        for(int i = 0; i<x; i++){
            warWin.add(playerHand.remove(0));
            warWin.add(dealerHand.remove(0));
        }
        return warWin;
    }

    public int warCardsNumber(ArrayList<Card> playerHand, ArrayList<Card> dealerHand){
        int x = (playerHand.size()>=3 && dealerHand.size()>=3)? 3: Math.min(playerHand.size(), dealerHand.size());
        return x;
    }


    public boolean checkIfEitherAreEmpty(ArrayList<Card> playerHand, ArrayList<Card>dealerHand){
        if(playerHand.size() == 0 || dealerHand.size() == 0){
            return false;
        }
        return true;
    }


    public void declareWinner(){
        String winner = "And the winner is ";
        winner += (playerHand.size() < dealerHand.size())? "the dealer!": super.getPlayer().getName();
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

