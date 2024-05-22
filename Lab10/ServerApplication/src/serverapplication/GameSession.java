package serverapplication;

import java.util.HashMap;
import java.util.Map;

public class GameSession {
    private final int gameId;
    private Player player1;
    private Player player2;
    private String[][] board1;
    private String[][] board2;
    private Map<String, String> playerBoards;
    private String currentPlayer;
    private boolean gameOver;

    private static final int BOARD_SIZE = 10;
    private static final String EMPTY = ".";
    private static final String SHIP = "S";
    private static final String HIT = "X";
    private static final String MISS = "O";

    public GameSession(int gameId) {
        this.gameId = gameId;
        this.board1 = initializeBoard();
        this.board2 = initializeBoard();
        this.playerBoards = new HashMap<>();
        this.currentPlayer = null;
        this.gameOver = false;
    }

    public int getGameId() {
        return gameId;
    }

    public synchronized String joinGame(Player player) {
        if (player1 == null) {
            player1 = player;
            playerBoards.put(player.getPlayerId(), "player1");
            currentPlayer = player.getPlayerId();
            return "Player 1 joined";
        } else if (player2 == null) {
            player2 = player;
            playerBoards.put(player.getPlayerId(), "player2");
            return "Player 2 joined";
        } else {
            return "Game full";
        }
    }

    private String[][] initializeBoard() {
        String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        //tge boat
        board[0][3] = SHIP;
        board[0][4] = SHIP;
        board[0][5] = SHIP;
        return board;
    }

    public synchronized String submitMove(String playerId, String move) {
        if (gameOver) {
            return "Game is over.";
        }
        if (!playerId.equals(currentPlayer)) {
            return "It's not your turn.";
        }
        String boardKey = playerBoards.get(playerId);
        if (boardKey == null) {
            return "Invalid player.";
        }
        String[][] opponentBoard = boardKey.equals("player1") ? board2 : board1;
        int row = move.charAt(0) - 'A';
        int col = Integer.parseInt(move.substring(1)) - 1;
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return "Invalid move.";
        }
        String result;
        if (opponentBoard[row][col].equals(SHIP)) {
            opponentBoard[row][col] = HIT;
            result = "Hit at " + move;
        } else if (opponentBoard[row][col].equals(EMPTY)) {
            opponentBoard[row][col] = MISS;
            result = "Miss at " + move;
        } else {
            result = "Already attacked this position.";
        }
        if (checkAllShipsSunk(opponentBoard)) {
            gameOver = true;
            result += " All ships sunk. " + playerId + " wins!";
        } else {
            currentPlayer = boardKey.equals("player1") ? player2.getPlayerId() : player1.getPlayerId();
        }
        return result;
    }

    private boolean checkAllShipsSunk(String[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].equals(SHIP)) {
                    return false;
                }
            }
        }
        return true;
    }
}
