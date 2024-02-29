public class Bonus {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // Create adjacency matrix
        int[][] adjacencyMatrix = new int[n][n];

        // Mark connections for the hub
        for (int i = 1; i < n; i++) {
            adjacencyMatrix[0][i] = 1;
            adjacencyMatrix[i][0] = 1;
        }

        // Mark connections for the spokes
        for (int i = 1; i < n - 1; i++) {
            adjacencyMatrix[i][i + 1] = 1;
            adjacencyMatrix[i + 1][i] = 1;
        }
        adjacencyMatrix[n - 1][1] = 1;
        adjacencyMatrix[1][n - 1] = 1;

        // Display the adjacency matrix
        displayMatrix(adjacencyMatrix);
    }

    // Method to display the adjacency matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
