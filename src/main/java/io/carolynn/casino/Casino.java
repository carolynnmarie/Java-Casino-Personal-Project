package io.carolynn.casino;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

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

    public ArrayList<Integer> testing(Integer[] arrayX, Integer[] arrayY, Integer[] arrayZ){
        int x = 0;
        int y = 0;
        int z = 0;
        int i = arrayX.length;
        ArrayList<Integer> result = new ArrayList<>();
        while(x<i && y<i && z<i) {
            if (arrayX[x].equals(arrayY[y]) && arrayX[x].equals(arrayZ[z])) {
                result.add(arrayX[x]);
                x++;
                y++;
                z++;
            } else {
                if (arrayX[x] < arrayY[y]) {
                    x++;
                } else if (arrayY[y] < arrayZ[z]) {
                    y++;
                } else {
                    z++;
                }
            }
        }

        return result;
    }

}
