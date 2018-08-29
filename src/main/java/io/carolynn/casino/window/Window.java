package io.carolynn.casino.window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{


    private JPanel jPanel;
    private Toolkit toolkit;


    public Window(){
        this.toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        setSize(new Dimension(size.width-size.width/3, size.height-size.height/3));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.jPanel = new SignInPane();
        jPanel.setSize(size.width-size.width/3, size.height-size.height/3);
        Container contentPane = getContentPane();
        contentPane.add(jPanel);
        contentPane.setVisible(true);

    }

    public void setTitle(String title) {
        setTitle(title);
    }

    public void setBackground(){
        setBackground(Color.WHITE);
    }




}
