package io.carolynn.casino.games;

import io.carolynn.casino.Person;
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

    public CrapsBetTypes getSpecificType(int index){
        return betTypes[index];
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


}
