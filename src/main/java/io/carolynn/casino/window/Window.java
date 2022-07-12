package io.carolynn.casino.window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    private Toolkit toolkit;


    public Window(){
        this.toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        setSize(new Dimension(size.width/2, size.height/2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(20,20);
        setResizable(true);
    }

    public void addPanel(JPanel panel) {
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Window window = new Window();
            window.setTitle("Casino");
            window.addPanel(new SignInPane());
        });
    }


}
