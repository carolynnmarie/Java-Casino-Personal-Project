package io.carolynn.casino.window;

import io.carolynn.casino.Person;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class SignInPane extends JDialog {

    private JPanel panel;
    private JButton signInButton;
    private JTextField userNameField;
    private JFormattedTextField chipsAmountField;
    private NumberFormat numberFormat;
    private JLabel userNameLabel;
    private JLabel chipAmntLabel;
    private Person player;


    public SignInPane(Frame parent){
        super(parent,"Login",true);
        this.panel = new JPanel(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.fill = GridBagConstraints.HORIZONTAL;

        this.userNameLabel = new JLabel("Username: ");
        gBC.gridx = 0;
        gBC.gridy = 0;
        gBC.gridwidth = 1;
        panel.add(userNameLabel,gBC);

        this.chipAmntLabel = new JLabel("Starting Chip Amount: ");
        gBC.gridx = 0;
        gBC.gridy = 1;
        gBC.gridwidth = 1;
        panel.add(chipAmntLabel,gBC);


        this.userNameField = new JTextField(25);
        gBC.gridx = 1;
        gBC.gridy = 0;
        gBC.gridwidth = 2;
        panel.add(userNameField,gBC);

        this.numberFormat = NumberFormat.getNumberInstance();
        this.chipsAmountField = new JFormattedTextField(numberFormat);
        gBC.gridx = 1;
        gBC.gridy = 1;
        gBC.gridwidth = 2;
        panel.add(chipsAmountField);
        panel.setBorder(new LineBorder(Color.DARK_GRAY));

        this.signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }


//    public void paintComponent(Graphics graphic1){
//        Graphics2D graphic = (Graphics2D) graphic1;
//
//        //format text message
//        Font appleChancery = new Font("Apple Chancery",Font.PLAIN,24);
//        graphic.setFont(appleChancery);
//        String message = "Welcome to the Casino!";
//
//        //center text message in window
//        FontRenderContext context = graphic.getFontRenderContext();
//        Rectangle2D size = appleChancery.getStringBounds(message,context);
//        float x =(float) (getWidth()-size.getWidth())/2;
//        float y = (float)(getHeight()-size.getHeight())/2;
//        float accent =(float) -size.getY();
//        float baseY = y + accent;
//
//        //display text message
//        graphic.drawString(message, x, baseY);
//    }
}
