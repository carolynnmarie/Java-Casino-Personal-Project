package io.carolynn.casino.games;

import io.carolynn.casino.Person;
import io.carolynn.casino.dice.DiceManager;

import java.util.*;

public class Craps extends Game {

    private DiceManager diceManager;
    private Person player;
    private int point;
    private int diceValue;
    private CrapsBetPayouts betPayouts;
    private CrapsBetTypes[] betTypes;
    private ArrayList<Integer> fieldValues;
    private ArrayList<Integer> winLosePlaceValues;
    private LinkedHashMap<String, Integer> lineComeFieldBets;
    private LinkedHashMap<String, HashMap<Integer, Integer>> oddsPlaceBets;
    private LinkedHashMap<String, HashMap<Integer, Integer>> pointsBets;




    public Craps(Person player){
        this.player = player;
        this.diceManager = new DiceManager(2);
        this.point = 0;
        this.diceValue = 0;
        this.betPayouts = new CrapsBetPayouts();
        this.fieldValues = new ArrayList<>(Arrays.asList(2, 3, 4, 9, 10, 11, 12));
        this.winLosePlaceValues = new ArrayList<>(Arrays.asList(4, 5, 6, 8, 9, 10));
        this.lineComeFieldBets = new LinkedHashMap<>();
        lineComeFieldBets.put("pass", 0);
        lineComeFieldBets.put("don't pass", 0);
        lineComeFieldBets.put("come", 0);
        lineComeFieldBets.put("don't come", 0);
        lineComeFieldBets.put("field", 0);
        lineComeFieldBets.put("come odds", 0);
        lineComeFieldBets.put("don't come odds",0);
        this.oddsPlaceBets = new LinkedHashMap<>();
        oddsPlaceBets.put("come", new HashMap<>());
        oddsPlaceBets.put("don't come", new HashMap<>());
        oddsPlaceBets.put("place win", new HashMap<>());
        oddsPlaceBets.put("place win", new HashMap<>());
        this.pointsBets = new LinkedHashMap<>();
        pointsBets.put("come", new HashMap<>());
        pointsBets.put("don't come", new HashMap<>());

    }

    @Override
    public void start() {

    }

    @Override
    public void runGame() {

    }


    public int rollDice(){
        getDiceManager().rollDice(2);
        setDiceValue(getDiceManager().totalValue());
        return getDiceValue();
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
        } while (!answer.equals("come") || !answer.equals("don't come") || !answer.equals("pass line") || !answer.equals("don't pass")
                || !answer.equals("odds")|| !answer.equals("field") || !answer.equals("place win") ||!answer.equals("place lose"));
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

    public String getOddsType(){
        Scanner scan = new Scanner(System.in);
        String type = "";
        do{
            System.out.println("What type of odds would you like to place? ?\nPass\nDon't Pass\nCome\nDon't Come");
            type = scan.nextLine().toLowerCase();
        } while(!type.equals("pass")||!type.equals("don't pass")||!type.equals("come")||!type.equals("don't come"));
        return type;
    }

    public int betOnPoint(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What number would you like to place your bet on?");
        return scan.nextInt();
    }

    public void placeBet(String betType){
        int bet = betAmount();
        for(Map.Entry<String,Integer> entry: getLineComeFieldBets().entrySet()){
            if(entry.getKey().equals(betType)){
                entry.setValue(bet);
            }
        }
    }

//    public void placeOddsBet(String oddsType){
//        int bet = betAmount();
//        int point = betOnPoint();
//        for(Map.Entry<String,HashMap<Integer,Integer>> entry: getOddsPlaceBets().entrySet()){
//            if(oddsType.equals(entry.getKey())){
//                for(Map.Entry<Integer,Integer> valueEntry: entry.getValue().entrySet()){
//                    entry.getValue().put()
//                }
//            }
//        }
//
//    }

    public int checkWallet(){
        return player.getChips();
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

    public CrapsBetTypes[] getBetTypes() {
        return betTypes;
    }
    public void setBetTypes(CrapsBetTypes[] betTypes) {
        this.betTypes = betTypes;
    }

    public void setPoint(int point) { this.point = point; }
    public int getPoint() { return point; }

    public int getDiceValue() { return diceValue; }
    public void setDiceValue(int diceValue) { this.diceValue = diceValue; }

    public ArrayList<Integer> getFieldValues() { return fieldValues; }
    public void setFieldValues(ArrayList<Integer> fieldValues) { this.fieldValues = fieldValues; }

    public ArrayList<Integer> getWinLosePlaceValues() { return winLosePlaceValues; }
    public void setWinLosePlaceValues(ArrayList<Integer> winLosePlaceValues) { this.winLosePlaceValues = winLosePlaceValues; }

    public LinkedHashMap<String, Integer> getLineComeFieldBets() { return lineComeFieldBets; }
    public void setLineComeFieldBets(LinkedHashMap<String, Integer> lineComeFieldBets) { this.lineComeFieldBets = lineComeFieldBets; }

    public LinkedHashMap<String, HashMap<Integer, Integer>> getOddsPlaceBets() { return oddsPlaceBets; }
    public void setOddsPlaceBets(LinkedHashMap<String, HashMap<Integer, Integer>> oddsPlaceBets) { this.oddsPlaceBets = oddsPlaceBets; }

    public CrapsBetPayouts getBetPayouts() { return betPayouts; }
    public void setBetPayouts(CrapsBetPayouts betPayouts) { this.betPayouts = betPayouts; }

    public LinkedHashMap<String, HashMap<Integer, Integer>> getPointsBets() { return pointsBets; }
    public void setPointsBets(LinkedHashMap<String, HashMap<Integer, Integer>> pointsBets) { this.pointsBets = pointsBets; }

}
