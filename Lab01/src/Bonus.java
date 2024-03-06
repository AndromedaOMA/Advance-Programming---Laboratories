import java.util.ArrayList;
import java.util.List;

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

        int expectedCycles = n * n - 3 * n + 3;
        List<List<Integer>> cycles = findCycles(n);
        System.out.println("Number of cycles: " + cycles.size());
        System.out.println("Expected number of cycles: " + expectedCycles);
        System.out.println("Cycles:");
        for (List<Integer> cycle : cycles) {
            System.out.print("[");
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print(cycle.get(i));
                if (i < cycle.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
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

    public static List<List<Integer>> findCycles(int n) {
        List<List<Integer>> cycles = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            List<Integer> cycle = new ArrayList<>();
            cycle.add(1); // Central vertex
            cycle.add(i);
            cycle.add(i % n + 1);
            cycles.add(cycle);
        }

        for (int i = 2; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                List<Integer> cycle = new ArrayList<>();
                cycle.add(1); // Central vertex
                cycle.add(i);
                cycle.add(j);
                cycle.add(j % n + 1);
                cycles.add(cycle);
            }
        }

        return cycles;
    }
}
