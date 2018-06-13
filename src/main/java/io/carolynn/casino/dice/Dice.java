package io.carolynn.casino.dice;


public class Dice {

    protected DieFace dieFace;

    public Dice(){
        this.dieFace = null;
        int x =  (int) Math.ceil(Math.random() * 6);
        this.dieFace = (x==0)?DieFace.ONE: (x==1)?DieFace.ONE: (x==2)?DieFace.TWO: (x==3)?DieFace.THREE: (x==4)?DieFace.FOUR:
                (x==5)? DieFace.FIVE: DieFace.SIX;
    }

    public Dice(DieFace dieFace){
        this.dieFace = dieFace;
    }

    public Integer getDieValue(){
        return this.dieFace.getFaceValue();
    }

    public void setDieFace(DieFace dieFace){
        this.dieFace = dieFace;
    }

    public void setFaceValue(Integer faceValue){
        this.dieFace.setValue(faceValue);
    }




}
