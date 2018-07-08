package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.dice.Dice;
import io.carolynn.casino.dice.DiceManager;

import static io.carolynn.casino.games.CrapsBetTypes.*;

import java.util.*;

public class Craps extends Game {

    private DiceManager diceManager;
    private Person player;
    private Integer bet;
    private Integer point;
    private CrapsBetTypes[] betTypes;


    public Craps(Person player){
        this.player = player;
        this.diceManager = new DiceManager(2);
        this.bet = 0;
        this.point = 0;
        this.betTypes = new CrapsBetTypes[]{PASS_LINE_BET,COME_BET,DONT_COME_BET,DONT_PASS_LINE_BET,PASS_LINE_ODDS_4_10,PASS_LINE_ODDS_5_9,
                PASS_LINE_ODDS_6_8,COME_BET_ODDS_4_10,COME_BET_ODDS_5_9,COME_BET_ODDS_6_8,DONT_PASS_LINE_ODDS_4_10,DONT_PASS_LINE_ODDS_5_9,
                DONT_PASS_LINE_ODDS_6_8,DONT_COME_BET_ODDS_4_10,DONT_COME_BET_ODDS_5_9,DONT_COME_BET_ODDS_6_8,FIELD_BET_3_4_9_10_11,FIELD_BET_2_12,
                PLACE_BET_4_10,PLACE_BET_5_9,PLACE_BET_6_8};
    }

    public CrapsBetTypes getBetType(int index){
        return betTypes[index];
    }

    public String getPlayerBetType(){
        Scanner scan = new Scanner(System.in);
        String answer = "";
        do{
            System.out.println("What type of bet would you like to place? " +
                    "Your options are: come, don't come, pass line, don't pass line, field, odds, place win, and place lose");
            answer = scan.nextLine().toLowerCase();
        } while (!answer.equals("come") || !answer.equals("don't come") || !answer.equals("pass line") || !answer.equals("don't pass") ||
                !answer.equals("field") || !answer.equals("place win") ||!answer.equals("place lose"));
        return answer;
    }

    public int betAmount(){
        Scanner scan = new Scanner(System.in);
        int bet = 0;
        do {
            System.out.println("How many chips would you like to bet?");
            bet = scan.nextInt();
            if (bet > checkWallet()) {
                System.out.println("Insufficient funds.");
            }
            if (bet < 5) {
                System.out.println("Your bet amount is too low. Minimum bet is 5.");
            }
        } while(bet> checkWallet() || bet<5);
        return bet;
    }

    public int checkWallet(){
        return player.getChips();
    }

    @Override
    public void start() {

    }

    @Override
    public void runGame() {

    }

    @Override
    public void end() {

    }

    public DiceManager getDiceManager() {
        return diceManager;
    }

    public void setDiceManager(DiceManager diceManager) {
        this.diceManager = diceManager;
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public CrapsBetTypes[] getBetTypes() {
        return betTypes;
    }

    public void setBetTypes(CrapsBetTypes[] betTypes) {
        this.betTypes = betTypes;
    }
}
