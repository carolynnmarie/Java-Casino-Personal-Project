package io.carolynn.casino.games;

import java.util.HashMap;

public class CrapsBetPayouts {

    private HashMap<Integer, Double> placeWinPayout;
    private HashMap<Integer, Double> placeLosePayout;
    private HashMap<Integer, Double> passLineComeBetOddsPayout;
    private HashMap<Integer, Double> dontPassLineDontComeOddsPayout;
    private HashMap<Integer, Double> fieldBetPayout;

    public CrapsBetPayouts(){
        this.placeLosePayout = new HashMap<>();
        placeLosePayout.put(6, 0.8);
        placeLosePayout.put(8, 0.8);
        placeLosePayout.put(5, 0.62);
        placeLosePayout.put(9, 0.62);
        placeLosePayout.put(4, 0.45);
        placeLosePayout.put(10, 0.45);

        this.placeWinPayout = new HashMap<>();
        placeWinPayout.put(6, 1.16);
        placeWinPayout.put(8, 1.16);
        placeWinPayout.put(5, 1.4);
        placeWinPayout.put(9, 1.4);
        placeWinPayout.put(4, 1.8);
        placeWinPayout.put(10, 1.8);

        this.passLineComeBetOddsPayout = new HashMap<>();
        passLineComeBetOddsPayout.put(4, 2.0);
        passLineComeBetOddsPayout.put(10, 2.0);
        passLineComeBetOddsPayout.put(5, 1.5);
        passLineComeBetOddsPayout.put(9, 1.5);
        passLineComeBetOddsPayout.put(6, 1.2);
        passLineComeBetOddsPayout.put(8, 1.2);

        this.dontPassLineDontComeOddsPayout = new HashMap<>();
        dontPassLineDontComeOddsPayout.put(4, .5);
        dontPassLineDontComeOddsPayout.put(10, .5);
        dontPassLineDontComeOddsPayout.put(5, .66);
        dontPassLineDontComeOddsPayout.put(9, .66);
        dontPassLineDontComeOddsPayout.put(6, .83);
        dontPassLineDontComeOddsPayout.put(8, .83);

        this.fieldBetPayout = new HashMap<>();
        fieldBetPayout.put(3, 1.0);
        fieldBetPayout.put(4, 1.0);
        fieldBetPayout.put(9, 1.0);
        fieldBetPayout.put(10, 1.0);
        fieldBetPayout.put(11, 1.0);
        fieldBetPayout.put(2, 2.0);
        fieldBetPayout.put(12, 2.0);
    }

    public void setPlaceWinBetPayout() {
        placeWinPayout.put(6, 1.16);
        placeWinPayout.put(8, 1.16);
        placeWinPayout.put(5, 1.4);
        placeWinPayout.put(9, 1.4);
        placeWinPayout.put(4, 1.8);
        placeWinPayout.put(10, 1.8);
    }

    public void setPlaceLoseBetPayout() {
        placeLosePayout.put(6, 0.8);
        placeLosePayout.put(8, 0.8);
        placeLosePayout.put(5, 0.62);
        placeLosePayout.put(9, 0.62);
        placeLosePayout.put(4, 0.45);
        placeLosePayout.put(10, 0.45);

    }

    public void setPassLineComeBetOddsPayout() {
        passLineComeBetOddsPayout.put(4, 2.0);
        passLineComeBetOddsPayout.put(10, 2.0);
        passLineComeBetOddsPayout.put(5, 1.5);
        passLineComeBetOddsPayout.put(9, 1.5);
        passLineComeBetOddsPayout.put(6, 1.2);
        passLineComeBetOddsPayout.put(8, 1.2);
    }

    public void setDontPassLineDontComeOddsPayout() {
        dontPassLineDontComeOddsPayout.put(4, .5);
        dontPassLineDontComeOddsPayout.put(10, .5);
        dontPassLineDontComeOddsPayout.put(5, .66);
        dontPassLineDontComeOddsPayout.put(9, .66);
        dontPassLineDontComeOddsPayout.put(6, .83);
        dontPassLineDontComeOddsPayout.put(8, .83);
    }

    public void setFieldBetPayout(){
        fieldBetPayout.put(3, 1.0);
        fieldBetPayout.put(4, 1.0);
        fieldBetPayout.put(9, 1.0);
        fieldBetPayout.put(10, 1.0);
        fieldBetPayout.put(11, 1.0);
        fieldBetPayout.put(2, 2.0);
        fieldBetPayout.put(12, 2.0);
    }

    public HashMap<Integer, Double> getPlaceWinPayout(){
        return placeWinPayout;
    }

    public HashMap<Integer, Double> getPlaceLosePayout() {
        return placeLosePayout;
    }

    public HashMap<Integer, Double> getPassLineComeBetOddsPayout() {
        return passLineComeBetOddsPayout;
    }

    public HashMap<Integer, Double> getDontPassLineDontComeOddsPayout() {
        return dontPassLineDontComeOddsPayout;
    }

    public HashMap<Integer, Double> getFieldBetPayout() {
        return fieldBetPayout;
    }
}
