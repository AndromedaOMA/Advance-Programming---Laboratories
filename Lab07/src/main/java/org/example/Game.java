package org.example;


import java.util.List;

public class Game {
    public int maxSequenceLength = 3;
    private Player player1;
    private Player player2;
    private Player player3;
    public Timekeeper timekeeper;
    public boolean isRunning = true;

    public Timekeeper getTimekeeper() {
        return timekeeper;
    }

    public void setTimekeeper(Timekeeper timekeeper) {
        this.timekeeper = timekeeper;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public int getMaxSequencerLength(List<Token> tokenList) {
        int maxSequenceLength = 1;
        int currentSeqSize = 1;
        for (int i = 0; i < tokenList.size() - 1; ++i) {
            if (tokenList.get(i).getLastNumber() == tokenList.get(i + 1).getFirstNumber()) {
                currentSeqSize++;
                if (maxSequenceLength < currentSeqSize) {
                    maxSequenceLength = currentSeqSize;
                }
            } else {
                currentSeqSize = 1;
            }
        }

        return maxSequenceLength;
    }
}
