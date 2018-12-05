package io.carolynn.casino.games.slots;

public enum SlotReelSymbols {
    CHERRY("\uD83C\uDF52", 7),
    APPLE("\uD83C\uDF4E", 7),
    GRAPE("\uD83C\uDF47", 7),
    LEMON("\uD83C\uDF4B", 7),
    BANANA("\uD83C\uDF4C", 7),
    MELON("\uD83C\uDF49", 7),
    ORANGE("\uD83C\uDF4A", 7),
    BAR("\u3374", 10),
    SEVEN("7", 15);

    private String symbol;
    private int payout;

    SlotReelSymbols(String symbol, int payout){
        this.symbol = symbol;
        this.payout = payout;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPayout(){
        return payout;
    }
}
