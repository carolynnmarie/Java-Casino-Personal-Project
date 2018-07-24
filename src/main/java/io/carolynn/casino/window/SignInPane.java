package io.carolynn.casino.window;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class SignInPane extends JPanel {

    public static final int MESSAGE_ONE = 200;
    public static final int MESSAGE_TWO = 200;

    public SignInPane(){ }

    public void paintComponent(Graphics graphic1){
        Graphics2D graphic = (Graphics2D) graphic1;

        //format text message
        Font appleChancery = new Font("Apple Chancery",Font.PLAIN,24);
        graphic.setFont(appleChancery);
        String message = "Welcome to the Casino!";

        //center text message in window
        FontRenderContext context = graphic.getFontRenderContext();
        Rectangle2D size = appleChancery.getStringBounds(message,context);
        float x =(float) (getWidth()-size.getWidth())/2;
        float y = (float)(getHeight()-size.getHeight())/2;
        float accent =(float) -size.getY();
        float baseY = y + accent;

        //display text message
        graphic.drawString(message, x, baseY);
    }
}
