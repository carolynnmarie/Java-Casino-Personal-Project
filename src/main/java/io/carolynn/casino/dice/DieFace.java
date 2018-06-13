package io.carolynn.casino.dice;

public enum DieFace {

    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

    private Integer value;

    DieFace(Integer value){
        this.value = value;
    }

    DieFace(){
        this.value = null;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getFaceValue(){
        return this.value;
    }



}
