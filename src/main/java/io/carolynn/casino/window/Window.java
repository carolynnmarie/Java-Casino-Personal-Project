package io.carolynn.casino.window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    private JPanel panel;
    private Toolkit toolkit;


    public Window(JPanel panel){
        this.toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        setSize(new Dimension(size.width-size.width/3, size.height-size.height/3));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel text = new JPanel();
        text.setSize(400,200);
        text.setBackground(Color.WHITE);

        JLabel textLabel = new JLabel("Welcome to the Casino!");
        textLabel.setBackground(Color.WHITE);
        text.add(textLabel);
        getContentPane().add(text,"North");

        this.panel = panel;
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);

    }

    public JPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Window window = new Window(new SignInPane());
            window.setTitle("Casino");
            window.setBackground(Color.WHITE);
        });
    }


}
