package io.carolynn.casino.window;

import io.carolynn.casino.Person;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.text.NumberFormat;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SignInPane extends JPanel {


    private JPanel panel;
    private JButton signInButton;
    private JTextField userNameField;
    private JFormattedTextField chipsAmountField;
    private NumberFormat numberFormat;
    private JLabel userNameLabel;
    private JLabel chipAmntLabel;
    private Person player;


    public SignInPane(){
        setVisible(true);
        setSize(400,200);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        this.panel = new JPanel(new GridBagLayout());
        panel.setBorder(new LineBorder(Color.WHITE));
        panel.setBackground(Color.WHITE);


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


        this.userNameField = new JTextField(15);
        gBC.gridx = 1;
        gBC.gridy = 0;
        gBC.gridwidth = 2;
        panel.add(userNameField,gBC);

        this.numberFormat = NumberFormat.getIntegerInstance();
        numberFormat.setGroupingUsed(false);
        this.chipsAmountField = new JFormattedTextField(numberFormat);
        gBC.gridx = 1;
        gBC.gridy = 1;
        gBC.gridwidth = 2;
        panel.add(chipsAmountField,gBC);

        this.signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ButtonListener());
        signInButton.setBackground(Color.LIGHT_GRAY);
        panel.add(signInButton);
        add(panel);

    }

private class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(()-> {
            String name = userNameField.getText();
            player = new Person(name);
            Integer chips = Integer.parseInt(chipsAmountField.getText());
            player.setChips(chips);

            Window window = new Window(new CasinoMenuPane(player));
            window.setBackground(Color.WHITE);
            window.setTitle("Menu");
        });
    }
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
//        float fromSide =(float) (getWidth()-size.getWidth())/2;
//        float fromTop = 100;
//        float accent =(float) -size.getY();
//        float baseY = fromTop + accent;
//
//        //display text message
//        graphic.drawString(message, fromSide, baseY);
//    }
}
