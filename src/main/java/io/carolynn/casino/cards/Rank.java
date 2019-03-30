package io.carolynn.casino.cards;

public enum Rank {
    ACE("Ace", 1),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13);

    final String name;
    final Integer value;

    Rank(String name, Integer value){
        this.name = name;
        this.value = value;
    }

    public String rankName(){
        return this.name;
    }

    public Integer rankValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return rankName();
    }

    public static int inputValueConversion(String x){
        x = x.toLowerCase();
        return (x.equals("one") || x.equals("1") || x.equals("ace"))? 1:
                (x.equals("two") || x.equals("2"))? 2:
                 (x.equals("three")||x.equals("3"))? 3:
                  (x.equals("four")||x.equals("4"))? 4:
                   (x.equals("five")||x.equals("5"))? 5:
                    (x.equals("six")||x.equals("6"))? 6:
                     (x.equals("seven")||x.equals("7"))? 7:
                      (x.equals("eight")||x.equals("8"))? 8:
                       (x.equals("nine")||x.equals("9"))? 9:
                        (x.equals("ten")||x.equals("10"))? 10:
                         (x.equals("eleven")||x.equals("11")|| x.equals("jack"))?11:
                          (x.equals("twelve")||x.equals("12")|| x.equals("queen"))?12:
                           (x.equals("thirteen")||x.equals("13")|| x.equals("king"))?13: 0;
    }
}
