package io.carolynn.casino;

public class Pair {

    private Integer key;
    private Double value;

    public Pair(Integer key, Double value){
        this.key=key;
        this.value = value;
    }

    public Integer getKey(){
        return key;
    }

    public Double getValue(){
        return value;
    }
}
