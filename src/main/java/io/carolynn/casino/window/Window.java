package io.carolynn.casino.window;

import javax.swing.*;
import java.awt.*;

public class Window{

    private JFrame jFrame;
    private JPanel jPanel;
    private Toolkit toolkit;


    public Window(){
        this.toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        this.jFrame = new JFrame();
        jFrame.setSize(new Dimension(size.width-size.width/3, size.height-size.height/3));
        this.jPanel = new SignInPane();
        jPanel.setSize(size.width-size.width/3, size.height-size.height/3);
        Container contentPane = jFrame.getContentPane();
        contentPane.add(jPanel);
        contentPane.setVisible(true);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
    }

    public void setTitle(String title) {
        jFrame.setTitle(title);
    }

    public void setBackground(){
        jFrame.setBackground(Color.WHITE);
    }

    //    Toolkit toolkit;
//    Dimension screenSize;
//    int height;
//    int width;
//    SignInPane signInComponent;
//
//    public Window() {
//        this.toolkit = Toolkit.getDefaultToolkit();
//        this.screenSize = toolkit.getScreenSize();
//        this.height = screenSize.height;
//        this.width = screenSize.width;
//        this.signInComponent = new SignInPane();
//
//        setSize(width -width/3,height-height/3);
//        setLocationByPlatform(true);
//        setBackground(Color.WHITE);
//        add(signInComponent);
//
//
//    }




}
