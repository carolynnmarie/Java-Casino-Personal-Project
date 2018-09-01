package io.carolynn.casino.window;

import io.carolynn.casino.GameFactory;
import io.carolynn.casino.Person;
import io.carolynn.casino.games.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasinoMenuPane extends JPanel {

    private JPanel panel;
    private Person player;
    private JButton blackJack;
    private JButton goFish;
    private JButton war;
    private JButton craps;

    public CasinoMenuPane(Person player){
        this.player = player;
        setVisible(true);

        ActionListener listener = new chooseGame();

        JLabel nameLabel = new JLabel("Welcome, " + player.getName() + "! Get ready to have some fun!");
        JLabel chipNumber = new JLabel("Starting chip amount is: " + player.getChips());
        JLabel choose = new JLabel("What game would you like to play?");

        this.panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new GridLayout(7,1));

        panel.add(nameLabel);
        panel.add(chipNumber);
        panel.add(choose);

        this.blackJack = new JButton("BlackJack");
        blackJack.addActionListener(listener);
        panel.add(blackJack);

        this.goFish = new JButton("Go Fish");
        goFish.addActionListener(listener);
        panel.add(goFish);

        this.war = new JButton("War");
        war.addActionListener(listener);
        panel.add(war);

        this.craps = new JButton("Craps");
        craps.addActionListener(listener);
        panel.add(craps);

        add(panel);


    }

    private class chooseGame implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            String gameChoice = e.getActionCommand();
            while(gameChoice.equals("blackjack")||gameChoice.equals("go fish")||gameChoice.equals("war")) {
                Game game = GameFactory.goToGame(gameChoice, player);
                game.start();
            }
        }
    }
}
