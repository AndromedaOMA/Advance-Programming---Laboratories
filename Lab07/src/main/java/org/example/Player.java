package org.example;

import java.util.ArrayList;
import java.util.List;

class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Token> tiles = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            List<Token> pickedTiles = game.bag.extractTiles(1);
            for (Token token : pickedTiles) {
                tiles.add(token);
                System.out.println(name + " picked tile: " + token);
            }

            if (tiles.size() >= 3) {
                for (int i = 0; i <= tiles.size() - 3; i++) {
                    Token tile1 = tiles.get(i);
                    Token tile2 = tiles.get(i + 1);
                    Token tile3 = tiles.get(i + 2);
                    if (tile1.getNumber2() == tile2.getNumber1() && tile2.getNumber2() == tile3.getNumber1()) {
                        System.out.println(name + " formed a sequence: " + tile1 + ", " + tile2 + ", " + tile3);
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}