package io.carolynn.casino.games.slots;

public enum SlotReelSymbols {
    CHERRY("\uD83C\uDF52"),
    APPLE("\uD83C\uDF4E"),
    GRAPE("\uD83C\uDF47"),
    LEMON("\uD83C\uDF4B"),
    BANANA("\uD83C\uDF4C"),
    MELON("\uD83C\uDF49"),
    ORANGE("\uD83C\uDF4A"),
    BAR("\u3374"),
    SEVEN("7");

    private String symbol;

    SlotReelSymbols(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
