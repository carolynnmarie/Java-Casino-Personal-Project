package io.carolynn.casino.window;

import javax.swing.*;
import java.awt.*;

public class SignInPane extends JPanel {

    public static final int MESSAGE_ONE = 200;
    public static final int MESSAGE_TWO = 200;

    public SignInPane(){ }



    public void paintComponent(Graphics graphic){
        graphic.drawString("Welcome to the Casino!", 200, 200);
        graphic.drawString("Please enter your name and beginning chip amount", 200, 225);
    }
}
