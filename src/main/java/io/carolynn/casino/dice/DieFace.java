package io.carolynn.casino.dice;

public enum DieFace {

    ONE(1,"\u2680"), TWO(2,"\u2681"), THREE(3,"\u2682"), FOUR(4,"\u2683"), FIVE(5,"\u2684"), SIX(6,"\u2685");

    private Integer value;
    private String picture;

    DieFace(Integer value, String picture){
        this.value = value;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }
}
