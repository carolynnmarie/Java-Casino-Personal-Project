package io.carolynn.casino.games.diceGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.dice.DiceManager;
import io.carolynn.casino.games.Game;

import java.util.*;

public class Craps extends Game {

    private DiceManager diceManager;
    private int point;
    private int diceValue;
    private ArrayList<Integer> fieldValues;
    private ArrayList<Integer> winLosePlaceValues;
    private LinkedHashMap<String, Integer> lineComeFieldBets;
    private ArrayList<String> lineComeFieldNames;
    private LinkedHashMap<String, HashMap<Integer, Integer>> oddsPlaceBets;
    private ArrayList<String> oddsPlaceNames;
    private LinkedHashMap<String, HashMap<Integer, Integer>> pointsBets;
    private HashMap<Integer, Double> placeWinPayout;
    private HashMap<Integer, Double> placeLosePayout;
    private HashMap<Integer, Double> passLineComeBetOddsPayout;
    private HashMap<Integer, Double> dontPassLineDontComeOddsPayout;
    private HashMap<Integer, Double> fieldBetPayout;
    private ArrayList<HashMap<Integer,Double>> betPayouts;


    public Craps(Person player){
        super(player);
        this.diceManager = new DiceManager(2);
        this.point = 0;
        this.diceValue = 0;
        this.fieldValues = new ArrayList<>(Arrays.asList(2, 3, 4, 9, 10, 11, 12));
        this.winLosePlaceValues = new ArrayList<>(Arrays.asList(4, 5, 6, 8, 9, 10));
        this.lineComeFieldBets = new LinkedHashMap<>();
        this.lineComeFieldNames = new ArrayList<>(Arrays.asList("pass","don't pass", "come","don't come", "field","come odds",
                "don't come odds"));
        lineComeFieldNames.stream().forEach(e->lineComeFieldBets.put(e,0));
        this.oddsPlaceNames = new ArrayList<>(Arrays.asList("come","don't come", "place win","don't place lose"));
        this.oddsPlaceBets = new LinkedHashMap<>();
        oddsPlaceNames.forEach(e->oddsPlaceBets.put(e,new HashMap<>()));
        this.pointsBets = new LinkedHashMap<>();
        pointsBets.put("come", new HashMap<>());
        pointsBets.put("don't come", new HashMap<>());

        this.placeLosePayout = new HashMap<>();
        placeLosePayout.put(6, 0.8);
        placeLosePayout.put(8, 0.8);
        placeLosePayout.put(5, 0.62);
        placeLosePayout.put(9, 0.62);
        placeLosePayout.put(4, 0.45);
        placeLosePayout.put(10, 0.45);

        this.placeWinPayout = new HashMap<>();
        placeWinPayout.put(6, 1.16);
        placeWinPayout.put(8, 1.16);
        placeWinPayout.put(5, 1.4);
        placeWinPayout.put(9, 1.4);
        placeWinPayout.put(4, 1.8);
        placeWinPayout.put(10, 1.8);

        this.passLineComeBetOddsPayout = new HashMap<>();
        passLineComeBetOddsPayout.put(4, 2.0);
        passLineComeBetOddsPayout.put(10, 2.0);
        passLineComeBetOddsPayout.put(5, 1.5);
        passLineComeBetOddsPayout.put(9, 1.5);
        passLineComeBetOddsPayout.put(6, 1.2);
        passLineComeBetOddsPayout.put(8, 1.2);

        this.dontPassLineDontComeOddsPayout = new HashMap<>();
        dontPassLineDontComeOddsPayout.put(4, .5);
        dontPassLineDontComeOddsPayout.put(10, .5);
        dontPassLineDontComeOddsPayout.put(5, .66);
        dontPassLineDontComeOddsPayout.put(9, .66);
        dontPassLineDontComeOddsPayout.put(6, .83);
        dontPassLineDontComeOddsPayout.put(8, .83);

        this.fieldBetPayout = new HashMap<>();
        fieldBetPayout.put(3, 1.0);
        fieldBetPayout.put(4, 1.0);
        fieldBetPayout.put(9, 1.0);
        fieldBetPayout.put(10, 1.0);
        fieldBetPayout.put(11, 1.0);
        fieldBetPayout.put(2, 2.0);
        fieldBetPayout.put(12, 2.0);

        this.betPayouts = new ArrayList<>(Arrays.asList(placeLosePayout,placeWinPayout,
                passLineComeBetOddsPayout,dontPassLineDontComeOddsPayout,fieldBetPayout));
    }

    @Override
    public void start() {

    }

    @Override
    public void runGame() {

    }


    public int rollDice(){
        diceManager.rollDice(2);
        setDiceValue(diceManager.totalValue());
        return getDiceValue();
    }

    public String getPlayerBetType(){
        Scanner scan = new Scanner(System.in);
        String answer = "";
        do {
            System.out.println("What type of bet would you like to place? " +
                    "Your options are: come, don't come, pass line, don't pass line, field, odds, place win, and place lose");
            answer = scan.nextLine().toLowerCase();
        } while (!lineComeFieldNames.contains(answer));
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
            } else if (bet < 5) {
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
        } while(!oddsPlaceNames.contains(type));
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


    public void setPoint(int point) { this.point = point; }
    public int getPoint() { return point; }

    public int getDiceValue() { return diceValue; }
    public void setDiceValue(int diceValue) { this.diceValue = diceValue; }

    public ArrayList<Integer> getFieldValues() { return fieldValues; }
    public void setFieldValues(ArrayList<Integer> fieldValues) { this.fieldValues = fieldValues; }

    public ArrayList<Integer> getWinLosePlaceValues() { return winLosePlaceValues; }
    public void setWinLosePlaceValues(ArrayList<Integer> winLosePlaceValues) {
        this.winLosePlaceValues = winLosePlaceValues;
    }

    public LinkedHashMap<String, Integer> getLineComeFieldBets() { return lineComeFieldBets; }
    public void setLineComeFieldBets(LinkedHashMap<String, Integer> lineComeFieldBets) {
        this.lineComeFieldBets = lineComeFieldBets;
    }

    public LinkedHashMap<String, HashMap<Integer, Integer>> getOddsPlaceBets() { return oddsPlaceBets; }
    public void setOddsPlaceBets(LinkedHashMap<String, HashMap<Integer, Integer>> oddsPlaceBets) {
        this.oddsPlaceBets = oddsPlaceBets;
    }

    public ArrayList<HashMap<Integer,Double>> getBetPayouts() { return betPayouts; }

    public LinkedHashMap<String, HashMap<Integer, Integer>> getPointsBets() { return pointsBets; }
    public void setPointsBets(LinkedHashMap<String, HashMap<Integer, Integer>> pointsBets) { this.pointsBets = pointsBets; }

}
