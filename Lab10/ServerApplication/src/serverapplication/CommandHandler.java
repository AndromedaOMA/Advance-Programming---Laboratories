package serverapplication;

public class CommandHandler {
    private final GameServer server;

    public CommandHandler(GameServer server) {
        this.server = server;
    }

    public String handleCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "create":
                int gameId = server.createGame();
                return "Game created with ID: " + gameId;
            case "join":
                if (parts.length < 3) {
                    return "Invalid join command";
                }
                int joinGameId = Integer.parseInt(parts[1]);
                Player player = new Player(parts[2]);
                GameSession session = server.getGameSession(joinGameId);
                if (session != null) {
                    return session.joinGame(player);
                } else {
                    return "Game not found";
                }
            case "move":
                if (parts.length < 4) {
                    return "Invalid move command";
                }
                int moveGameId = Integer.parseInt(parts[1]);
                String playerId = parts[2];
                String move = parts[3];
                GameSession moveSession = server.getGameSession(moveGameId);
                if (moveSession != null) {
                    return moveSession.submitMove(playerId, move);
                } else {
                    return "Game not found";
                }
            case "stop":
                return "Server stopped";
            default:
                return "Unknown command";
        }
    }
}
