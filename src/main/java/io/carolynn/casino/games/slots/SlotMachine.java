package io.carolynn.casino.games.slots;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SlotMachine {

    public static void main(String[] args){
        SlotReelSymbols[] fruits = SlotReelSymbols.values();
        List<String> fruitChars = Arrays.stream(fruits).map(e-> e.getSymbol()).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        fruitChars.forEach(e->builder.append(e).append(" "));
        System.out.println(builder.toString());

    }

}
