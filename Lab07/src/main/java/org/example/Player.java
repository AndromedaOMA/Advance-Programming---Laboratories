package org.example;

import java.util.*;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    public final String name;
    public final Bag bag;
    public final Game game;
    private boolean isRunning = true;
    public List<Token> playerTokenList;

    public Player(String name, Bag bag, Game game) {
        this.name = name;
        this.bag = bag;
        this.game = game;
        playerTokenList = new ArrayList<>();
    }

    @Override
    public void run() {
        gameLoop:
        while (game.isRunning) {
            synchronized (game) {
                if (bag.isEmpty()) {
                    game.getTimekeeper().stopRunningThreads();
                    break;
                }

                //alegem un token din lista
                Token choosenToken = bag.getToken();
                boolean isAdded = false;
                for (int i = 0; i < playerTokenList.size(); ++i) {
                    if (choosenToken.getFirstNumber() == playerTokenList.get(i).getLastNumber()) {
                        isAdded = true;
                        playerTokenList.add(i + 1, choosenToken);
                        break;
                    }
                    if (choosenToken.getLastNumber() == playerTokenList.get(i).getFirstNumber()) {
                        isAdded = true;
                        playerTokenList.add(i, choosenToken);
                        break;
                    }
                }

                if (!isAdded) {
                    playerTokenList.add(choosenToken);
                }

                if (game.getMaxSequencerLength(playerTokenList) == game.maxSequenceLength) {
                    System.out.println("Jocul a fost castigat de catre " + name);
                    game.isRunning = false;
                    break;
                    //game.getTimekeeper().stopRunningThreads();
                }

                System.out.println(name + " a ales tokenul " + choosenToken);
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                game.notifyAll();

                try {
                    game.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Jocul s-a terminat, felicitari tuturor!");
                }
            }
        }
    }
}
