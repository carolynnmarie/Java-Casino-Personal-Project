package io.carolynn.casino;

import java.util.Scanner;

public class Casino {


    public Casino(){
    }

    public Person newPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Casino!  Please type in your name");
        String name = scanner.nextLine();
        Person player = new Person(name);
        System.out.println("How many chips would you like to start off with?");
        int chips = scanner.nextInt();
        player.setChips(chips);
        return player;
    }
}
