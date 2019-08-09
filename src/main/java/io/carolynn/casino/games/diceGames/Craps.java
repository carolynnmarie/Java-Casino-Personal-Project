package io.carolynn.casino.games.diceGames;

import io.carolynn.casino.Person;
import io.carolynn.casino.dice.DiceManager;
import io.carolynn.casino.games.Game;

import java.util.*;

public class Craps extends Game {

    private DiceManager diceManager;
    private int point;
    private int diceValue;
    private int bet;
    private Scanner scanner;
    private HashMap<String, Integer> lineComeBets;
    private HashMap<Integer, Integer> fieldBets;
    private HashMap<String,Integer> passDontPassOddsBets;
    private HashMap<String, HashMap<Integer, Integer>> placeBets;
    private HashMap<Integer, Integer> comePointOddsBets;
    private HashMap<Integer, Integer> dontComePointOddsBets;
    private CrapsBetPayouts payouts;

    public Craps(Person player){
        super(player);
        this.diceManager = new DiceManager(2);
        this.point = 0;
        this.bet = 0;
        this.diceValue = 0;
        this.scanner = new Scanner(System.in);
        this.lineComeBets = new HashMap<>();
        this.fieldBets = new HashMap<>();
        this.placeBets = new HashMap<>();
        this.passDontPassOddsBets = new HashMap<>();
        this.comePointOddsBets = new HashMap<>();
        this.payouts = new CrapsBetPayouts();

    }

    @Override
    public void start() {
        System.out.println("Welcome to Craps!\n  Minimum bet amount is 5 chips.  If at anytime your available chip amount goes" +
                "below 5, you will be booted from the game and returned to the Main Menu to replenish your chips");
        if(!insufficientFunds()){
            runGame();
        }
        end();
    }

    @Override
    public void runGame() {
        do{
            placeInitialBet();
            comeOutRoll();
            if(point!=0){
                phaseTwoRoll();
            }
        } while (keepPlaying() && !insufficientFunds());
    }


    public void rollDice(){
        diceManager.rollDice(2);
        diceValue = diceManager.totalValue();
        System.out.println(diceManager.toStringPictures() + "Total value: " + diceValue);
    }

    public void comeOutRoll(){
        System.out.println("Make your first roll!\n");
        rollDice();
        StringBuilder builder = new StringBuilder();
        if(diceValue==2 || diceValue == 3){
            builder.append(". You crapped out. Pass Line bets lose and Don't Pass Line bets win.\n")
                    .append(passComeFieldResult("pass",false))
                    .append(passComeFieldResult("don't pass", true));
        } else if(diceValue == 7 || diceValue == 11){
            builder.append(". You rolled a natural! Pass Line bets win and Don't Pass loses.\n")
                    .append(passComeFieldResult("pass",true))
                    .append(passComeFieldResult("don't pass", false));
        } else if(diceValue == 12) {
            builder.append(". Pass Line looses and Don't Pass bets are pushed to next round.\n")
                    .append(passComeFieldResult("pass",false));
        } else {
            builder.append(". The point is now ")
                    .append(diceValue);
            point = diceValue;
        }
        System.out.println(builder.toString());
    }

    public void placeInitialBet(){
        String answer = "";
        do{
            System.out.println("You must place an initial Pass Line Bet. To make a bet on the Pass Line, type 'pass'. " +
                    "To make a bet on the Don't Pass Line, type 'don't pass'.");
            answer = scanner.nextLine().toLowerCase();
            if(!insufficientFunds()){
                getBetAmount();
            }
            if(answer.equals("pass") || answer.equals("don't pass")){
                lineComeBets.put(answer,bet);
            } else {
                System.out.println("Invalid Input");
            }
        } while (!answer.equals("pass") && !answer.equals("don't pass"));
    }

    public void phaseTwoRoll(){
        String betType = getPhaseTwoBetType();
        if(!insufficientFunds()){
            getBetAmount();
            makePhaseTwoBet(betType);
            rollDice();

        }
    }

    public void getBetAmount(){
        do {
            System.out.println("How many chips would you like to bet?");
            bet = scanner.nextInt();
            scanner.nextLine();
            if (bet > player.getChips()) {
                System.out.println("Insufficient funds. You have " + player.getChips() + " chips.");
            } else if (bet < 5) {
                System.out.println("Your bet amount is too low. Minimum bet is 5.");
            }
        } while(bet > player.getChips() || bet < 5);

    }

    public String getPhaseTwoBetType(){
        ArrayList<String> betTypes = new ArrayList<>(Arrays.asList("pass","don't pass","come","don't come","field","pass odds",
                "don't pass odds", "come point odds", "don't come point odds", "place win","place lose"));
        StringBuilder builder = new StringBuilder();
        betTypes.stream().forEach(e->builder.append(e).append(", "));
        String answer = "";
        do {
            System.out.println("What type of bet would you like to place for phase two? Your options are: " + builder.toString());
            answer = scanner.nextLine().toLowerCase();
            if(!betTypes.contains(answer)){
                System.out.println("Invalid input. ");
            }
        } while (!betTypes.contains(answer));
        return answer;
    }

    public void makePhaseTwoBet(String betType){
        if(betType.equals("pass")|| betType.equals("don't pass") || betType.equals("come")|| betType.equals("don't come")){
            lineComeBets.put(betType,bet);
        } else if (betType.equals("place win")|| betType.equals("place lose")){
            makePlaceBet(betType);
        } else if (betType.equals("pass odds") || betType.equals("don't pass odds")){
            passDontPassOddsBets.put(betType,bet);
        } else if (betType.equals("come point odds")) {
            comePointOddsBets = makeComeDontComeOddsBet(comePointOddsBets);
        } else if(betType.equals("don't come point odds")){
            dontComePointOddsBets = makeComeDontComeOddsBet(dontComePointOddsBets);
        } else if (betType.equals("field")){
            makeFieldBet();
        }
    }

    public void makePlaceBet(String oddsType){
        System.out.println("What number would you like to put your bet on? 4, 5, 6, 7, 8, 9, or 10");
        int point = scanner.nextInt();
        scanner.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(point, bet);
        placeBets.put(oddsType,map);
    }


    public HashMap<Integer,Integer> makeComeDontComeOddsBet(HashMap<Integer,Integer> map){
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            builder.append(entry.getKey())
                    .append(", ");
        }
        System.out.println("What come point would you like to bet on? Your options are: " + builder.toString());
        int answer = scanner.nextInt();
        scanner.nextLine();
        map.put(answer,bet);
        return map;
    }

    public void makeFieldBet(){
        int answer = 0;
        System.out.println("What number would you like to put your field bet on? 2, 3, 4, 9, 10, 11, or 12?");
        if(scanner.hasNextInt()){
            answer = scanner.nextInt();
            scanner.nextLine();
        }
        fieldBets.put(answer,bet);
    }

    public void phaseTwoRollResults(){

    }

    public String passComeFieldResult(String betType, boolean winLose){
        String result = "";
        int lCFBet = lineComeBets.get(betType);
        if(winLose && lCFBet!=0){
            result =  "You won " + lCFBet + " chips on your " + betType + " bet.\n";
            player.addChips(lCFBet*2);
        } else if (!winLose && lCFBet!=0){
            result = "You lost " + lCFBet + " chips on your " + betType + " bet.\n";
        }
        return result;
    }


    public boolean insufficientFunds(){
        if(player.getChips()<=5){
            System.out.println("You have insufficient funds.  Returning to main menu.");
            return false;
        } else {
            return true;
        }
    }

    public boolean keepPlaying(){
        System.out.println("Would you like to play again? yes/no");
        String answer = "";
        boolean play = true;
        do{
            answer = scanner.nextLine().toLowerCase();
            if(answer.equals("yes")){
                break;
            } else if (answer.equals("no")){
                play = false;
            } else {
                System.out.println("Invalid answer.  Please type 'yes' to play again or 'no' to return to the Main Menu.");
            }
        } while (!answer.equals("yes") && !answer.equals("no"));
        return play;
    }

    @Override
    public void end() {
        System.out.println("Thank you for playing Craps!");
    }

    public DiceManager getDiceManager() {
        return diceManager;
    }

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

//    public void setPoint(int point) { this.point = point; }
//    public int getPoint() { return point; }
//
//    public int getDiceValue() { return diceValue; }
//    public void setDiceValue(int diceValue) { this.diceValue = diceValue; }
//
//    public LinkedHashMap<String, Integer> getLineComeBets() { return lineComeBets; }
//
//    public LinkedHashMap<String, HashMap<Integer, Integer>> getPlaceBets() { return placeBets; }

}
