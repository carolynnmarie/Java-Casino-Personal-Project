package io.carolynn.casino.cards;


public enum UnicodeCard {
    ACE_OF_SPADES("A\u2660", 1, "\uD83C\uDCA1"), TWO_OF_SPADES("2\u2660", 2, "\uD83C\uDCA2"),
    THREE_OF_SPADES("3\u2660",3,"\uD83C\uDCA3"), FOUR_OF_SPADES("4\u2660",4, "\uD83C\uDCA4"),
    FIVE_OF_SPADES("5\u2660", 5, "\uD83C\uDCA5"), SIX_OF_SPADES("6\u2660",6,"\uD83C\uDCA6"),
    SEVEN_OF_SPADES("7\u2660",7,"\uD83C\uDCA7"), EIGHT_OF_SPADES("8\u2660",8,"\uD83C\uDCA8"),
    NINE_OF_SPADES("9\u2660",9,"\uD83C\uDCA9"), TEN_OF_SPADES("10\u2660",10,"\uD83C\uDCAA"),
    JACK_OF_SPADES("J\u2660",11,"\uD83C\uDCAB"), QUEEN_OF_SPADES("Q\u2660",12,"\uD83C\uDCAD"),
    KING_OF_SPADES("K\u2660",13,	"\uD83C\uDCAE"),

    ACE_OF_HEARTS("A\u2665",1,"\uD83C\uDCB1"), TWO_OF_HEARTS("2\u2665",2, "\uD83C\uDCB2"),
    THREE_OF_HEARTS("3\u2665",3,"\uD83C\uDCB3"), FOUR_OF_HEARTS("4\u2665",4,"\uD83C\uDCB4"),
    FIVE_OF_HEARTS("5\u2665",5,"\uD83C\uDCB5"), SIX_OF_HEARTS("6\u2665",6,"\uD83C\uDCB6"),
    SEVEN_OF_HEARTS("7\u2665", 7, "\uD83C\uDCB7"), EIGHT_OF_HEARTS("8\u2665",8,"\uD83C\uDCB8"),
    NINE_OF_HEARTS("9\u2665",9,"\uD83C\uDCB9"), TEN_OF_HEARTS("10\u2665", 10,"\uD83C\uDCBA"),
    JACK_OF_HEARTS("J\u2665",11,"\uD83C\uDCBB"), QUEEN_OF_HEARTS("Q\u2665",12,"\uD83C\uDCBD"),
    KING_OF_HEARTS("K\u2665",13,"\uD83C\uDCBE"),

    ACE_OF_DIAMONDS("A\u2666",1,"\uD83C\uDCC1"), TWO_OF_DIAMONDS("2\u2666",2,"\uD83C\uDCC2"),
    THREE_OF_DIAMONDS("3\u2666",3,"\uD83C\uDCC3"), FOUR_OF_DIAMONDS("4\u2666",4, "\uD83C\uDCC4"),
    FIVE_OF_DIAMONDS("5\u2666",5,"\uD83C\uDCC5"), SIX_OF_DIAMONDS("6\u2666",6,"\uD83C\uDCC6"),
    SEVEN_OF_DIAMONDS("7\u2666",7,"\uD83C\uDCC7"), EIGHT_OF_DIAMONDS("8\u2666",8,"\uD83C\uDCC8"),
    NINE_OF_DIAMONDS("9\u2666",9,"\uD83C\uDCC9"), TEN_OF_DIAMONDS("10\u2666",10,"\uD83C\uDCCA"),
    JACK_OF_DIAMONDS("J\u2666",11,"\uD83C\uDCCB"), QUEEN_OF_DIAMONDS("Q\u2666",12,"\uD83C\uDCCD"),
    KING_OF_DIAMONDS("K\u2666",13,"\uD83C\uDCCE"),

    ACE_OF_CLUBS("A\u2663",1,"\uD83C\uDCD1"), TWO_OF_CLUBS("2\u2663",2,"\uD83C\uDCD2"),
    THREE_OF_CLUBS("3\u2663",3,"\uD83C\uDCD3"), FOUR_OF_CLUBS("4\u2663s",4,"\uD83C\uDCD4"),
    FIVE_OF_CLUBS("5\u2663",5,"\uD83C\uDCD5"), SIX_OF_CLUBS("6\u2663",6,"\uD83C\uDCD6"),
    SEVEN_OF_CLUBS("7\u2663",7,"\uD83C\uDCD7"), EIGHT_OF_CLUBS("8\u2663",8,"\uD83C\uDCD8"),
    NINE_OF_CLUBS("9\u2663",9,"\uD83C\uDCD9"), TEN_OF_CLUBS("10\u2663",10,"\uD83C\uDCDA"),
    JACK_OF_CLUBS("J\u2663",11,"\uD83C\uDCDB"), QUEEN_OF_CLUBS("Q\u2663",12,"\uD83C\uDCDD"),
    KING_OF_CLUBS("K\u2663",13,"\uD83C\uDCDE");


    final String name;
    final Integer value;
    final String unicodePicture;

    UnicodeCard(String name, Integer value, String unicodePicture) {
        this.name = name;
        this.value = value;
        this.unicodePicture = unicodePicture;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public String getUnicodePicture() {
        return unicodePicture;
    }

    @Override
    public String toString() {
        return unicodePicture + " " + name;
    }


}

//To print the name the right size:
//JLabel label = new JLabel(name.getUnicodePicture());
//label.setFont(getFont.deriveFont(64.0f)