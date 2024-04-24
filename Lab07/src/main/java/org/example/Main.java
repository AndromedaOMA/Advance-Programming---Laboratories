package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Bag bag = new Bag();
        Player player1 = new Player("Player 1", bag, game);
        Player player2 = new Player("Player 2", bag, game);
        Player player3 = new Player("Player 3", bag, game);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        Thread thread3 = new Thread(player3);

        List<Thread> threadList = new ArrayList<>();
        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);

        for (Thread thread : threadList) {
            thread.start();
        }


        Timekeeper timekeeperThread = new Timekeeper(thread1, thread2, thread3);
        timekeeperThread.setDaemon(true);
        timekeeperThread.start();
        game.setTimekeeper(timekeeperThread);

        try {
            sleep(5000);
            System.out.println(player1.name + ": " + player1.playerTokenList);
            System.out.println(player2.name + ": " + player2.playerTokenList);
            System.out.println(player3.name + ": " + player3.playerTokenList);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<Player> topPlayers = new ArrayList<>();
        topPlayers.add(player1);
        topPlayers.add(player2);
        topPlayers.add(player3);


        Comparator<Player> comparator = Comparator.comparingInt(p -> game.getMaxSequencerLength(p.playerTokenList));

        topPlayers.sort(comparator);

        System.out.println();
        System.out.println();

        int c = 3;
        for (Player player : topPlayers) {
            System.out.println("Locul " + c + ": " + player.name);
            c--;
        }
    }
}