package io.carolynn.casino;

import io.carolynn.casino.window.Window;

import javax.swing.*;
import java.awt.*;

public class WindowTest {

    public static void main(String[] args){
        EventQueue.invokeLater(()-> {
            Window window = new Window();
            window.setTitle("Casino");
        });
    }
}
