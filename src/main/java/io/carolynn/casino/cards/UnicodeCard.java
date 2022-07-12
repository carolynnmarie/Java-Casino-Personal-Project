package io.carolynn.casino.cards;


public enum UnicodeCard {
    ACE_OF_SPADES("Ace of Spades", 1, "\uD83C\uDCA1"), TWO_OF_SPADES("Two of Spades", 2, "\uD83C\uDCA2"),
    THREE_OF_SPADES("Three of Spades",3,"\uD83C\uDCA3"), FOUR_OF_SPADES("Four of Spades",4, "\uD83C\uDCA4"),
    FIVE_OF_SPADES("Five of Spades", 5, "\uD83C\uDCA5"), SIX_OF_SPADES("Six of Spades",6,"\uD83C\uDCA6"),
    SEVEN_OF_SPADES("Seven of Spades",7,"\uD83C\uDCA7"), EIGHT_OF_SPADES("Eight of Spades",8,"\uD83C\uDCA8"),
    NINE_OF_SPADES("Nine of Spades",9,"\uD83C\uDCA9"), TEN_OF_SPADES("Ten of Spades",10,	"\uD83C\uDCAA"),
    JACK_OF_SPADES("Jack of Spades",11,	"\uD83C\uDCAB"), QUEEN_OF_SPADES("Queen of Spades",12,"\uD83C\uDCAD"),
    KING_OF_SPADES("King of Spades",13,	"\uD83C\uDCAE"),

    ACE_OF_HEARTS("Ace of Hearts",1,"\uD83C\uDCB1"), TWO_OF_HEARTS("Two of Hearts",2, "\uD83C\uDCB2"),
    THREE_OF_HEARTS("Three of Hearts",3,"\uD83C\uDCB3"), FOUR_OF_HEARTS("Four of Hearts",4,"\uD83C\uDCB4"),
    FIVE_OF_HEARTS("Five of Hearts",5,"\uD83C\uDCB5"), SIX_OF_HEARTS("Six of Hearts",6,"\uD83C\uDCB6"),
    SEVEN_OF_HEARTS("Seven of Hearts", 7, "\uD83C\uDCB7"), EIGHT_OF_HEARTS("Eight of Hearts",8,"\uD83C\uDCB8"),
    NINE_OF_HEARTS("Nine of Hearts",9,"\uD83C\uDCB9"), TEN_OF_HEARTS("Ten of Hearts", 10,	"\uD83C\uDCBA"),
    JACK_OF_HEARTS("Jack of Hearts",11,"\uD83C\uDCBB"), QUEEN_OF_HEARTS("Queen of Hearts",12,"\uD83C\uDCBD"),
    KING_OF_HEARTS("King of Hearts",13,"\uD83C\uDCBE"),

    ACE_OF_DIAMONDS("Ace of Diamonds",1,"\uD83C\uDCC1"), TWO_OF_DIAMONDS("Two of Diamonds",2,"\uD83C\uDCC2"),
    THREE_OF_DIAMONDS("Three of Diamonds",3,"\uD83C\uDCC3"), FOUR_OF_DIAMONDS("Four of Diamonds",4, "\uD83C\uDCC4"),
    FIVE_OF_DIAMONDS("Five of Diamonds",5,"\uD83C\uDCC5"), SIX_OF_DIAMONDS("Six of Diamonds",6,"\uD83C\uDCC6"),
    SEVEN_OF_DIAMONDS("Seven of Diamonds",7,"\uD83C\uDCC7"), EIGHT_OF_DIAMONDS("Eight of Diamonds",8,"\uD83C\uDCC8"),
    NINE_OF_DIAMONDS("Nine of Diamonds",9,"\uD83C\uDCC9"), TEN_OF_DIAMONDS("Ten of Diamonds",10,"\uD83C\uDCCA"),
    JACK_OF_DIAMONDS("Jack of Diamonds",11,"\uD83C\uDCCB"), QUEEN_OF_DIAMONDS("Queen of Diamonds",12,"\uD83C\uDCCD"),
    KING_OF_DIAMONDS("King of Diamonds",13,"\uD83C\uDCCE"),

    ACE_OF_CLUBS("Ace of Clubs",1,"\uD83C\uDCD1"), TWO_OF_CLUBS("Two of Clubs",2,"\uD83C\uDCD2"),
    THREE_OF_CLUBS("Three of Clubs",3,"\uD83C\uDCD3"), FOUR_OF_CLUBS("Four of Clubs",4,"\uD83C\uDCD4"),
    FIVE_OF_CLUBS("Five of Clubs",5,"\uD83C\uDCD5"), SIX_OF_CLUBS("Six of Clubs",6,"\uD83C\uDCD6"),
    SEVEN_OF_CLUBS("Seven of Clubs",7,"\uD83C\uDCD7"), EIGHT_OF_CLUBS("Eight of Clubs",8,"\uD83C\uDCD8"),
    NINE_OF_CLUBS("Nine of Clubs",9,"\uD83C\uDCD9"), TEN_OF_CLUBS("Ten of Clubs",10,"\uD83C\uDCDA"),
    JACK_OF_CLUBS("Jack of Clubs",11,"\uD83C\uDCDB"), QUEEN_OF_CLUBS("Queen of Clubs",12,"\uD83C\uDCDD"),
    KING_OF_CLUBS("King of Clubs",13,"\uD83C\uDCDE");


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