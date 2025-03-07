package serverapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentHashMap;

public class GameServer {
    private final int port;
    private boolean running;
    private final ExecutorService pool;
    private final ConcurrentHashMap<Integer, GameSession> gameSessions;
    private int gameIdCounter = 1;

    public GameServer(int port) {
        this.port = port;
        this.pool = Executors.newCachedThreadPool();
        this.gameSessions = new ConcurrentHashMap<>();
    }

    public void start() {
        running = true;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Game server started on port " + port);
            while (running) {
                Socket clientSocket = serverSocket.accept();
                pool.execute(new ClientThread(clientSocket, this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    public void stop() {
        running = false;
        pool.shutdown();
        System.out.println("Game server stopped");
    }

    public int createGame() {
        int gameId = gameIdCounter++;
        GameSession session = new GameSession(gameId);
        gameSessions.put(gameId, session);
        return gameId;
    }

    public GameSession getGameSession(int gameId) {
        return gameSessions.get(gameId);
    }

    public static void main(String[] args) {
        int port = 12345;
        GameServer server = new GameServer(port);
        server.start();
    }
}
