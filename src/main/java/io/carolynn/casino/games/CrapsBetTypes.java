package io.carolynn.casino.games;

public enum CrapsBetTypes {
    PASS_LINE_BET(1,1,"Pass Line Bet"),
    COME_BET(1,1,"Come Bet"),
    DONT_COME_BET(1,1, "Don't Come Bet"),
    DONT_PASS_LINE_BET(1,1, "Don't Pass Line Bet"),
    PASS_LINE_ODDS_4_10(2,1, "Pass Line Bet Odds"),
    PASS_LINE_ODDS_5_9(3,2, "Pass Line Bet Odds"),
    PASS_LINE_ODDS_6_8(6,5, "Pass Line Bet Odds"),
    COME_BET_ODDS_4_10(2,1, "Come Bet Odds"),
    COME_BET_ODDS_5_9(2,1, "Come Bet Odds"),
    COME_BET_ODDS_6_8(6,5, "Come Bet Odds"),
    DONT_PASS_LINE_ODDS_4_10(1,2, "Don't Pass Line Odds"),
    DONT_PASS_LINE_ODDS_5_9(2,3, "Don't Pass Line Odds"),
    DONT_PASS_LINE_ODDS_6_8(5,6, "Don't Pass Line Odds"),
    DONT_COME_BET_ODDS_4_10(1,2, "Don't Come Bet Odds"),
    DONT_COME_BET_ODDS_5_9(2,3, "Don't Come Bet Odds"),
    DONT_COME_BET_ODDS_6_8(5,6, "Don't Come Bet Odds"),
    FIELD_BET_3_4_9_10_11(1,1, "Field Bet"),
    FIELD_BET_2_12(2,1, "Field Bet"),
    PLACE_BET_4_10(9,5, "Place Bet"),
    PLACE_BET_5_9(7,5, "Place Bet"),
    PLACE_BET_6_8(7,6, "Place Bet");


    private Integer initialBet;
    private Integer payout;
    private String betType;


    CrapsBetTypes(Integer initialBet, Integer payout, String betType1){
        this.initialBet = initialBet;
        this.payout = payout;
        this.betType = betType1;
    }

    public Integer getInitialBet(){ return initialBet; }

    public Integer getPayout(){ return payout; }

    public String getBetType1(){ return betType; }

    public CrapsBetTypes[] getAll(){
        CrapsBetTypes[] all = new CrapsBetTypes[]{PASS_LINE_BET,COME_BET,DONT_COME_BET,DONT_PASS_LINE_BET,PASS_LINE_ODDS_4_10,PASS_LINE_ODDS_5_9,
                PASS_LINE_ODDS_6_8,COME_BET_ODDS_4_10,COME_BET_ODDS_5_9,COME_BET_ODDS_6_8,DONT_PASS_LINE_ODDS_4_10,DONT_PASS_LINE_ODDS_5_9,
                DONT_PASS_LINE_ODDS_6_8,DONT_COME_BET_ODDS_4_10,DONT_COME_BET_ODDS_5_9,DONT_COME_BET_ODDS_6_8,FIELD_BET_3_4_9_10_11,FIELD_BET_2_12,
                PLACE_BET_4_10,PLACE_BET_5_9,PLACE_BET_6_8};
        return all;
    }



}
