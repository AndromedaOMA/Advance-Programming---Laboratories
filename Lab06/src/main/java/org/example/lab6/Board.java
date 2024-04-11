package org.example.lab6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {
    int trunPlayer;
    Node matrix[][];
    int width;
    int height;
    List<Node> avalible;
    int circleDiameter;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new Node[width][height];
        for (int x = 0; x < this.width; x++)
            for (int y = 0; y < this.height; y++)
                matrix[x][y] = new Node(0, 0, 0);
        //connections
        for (int x = 0; x < this.width; x++)
            for (int y = 0; y < this.height; y++) {
                ///x+1
                if (Math.random() > 0.5 && x < this.width - 1)
                    matrix[x][y].addConnection(matrix[x + 1][y]);
                ///y+1
                if (Math.random() > 0.5 && y < this.height - 1)
                    matrix[x][y].addConnection(matrix[x][y + 1]);
            }
        ///avalible
        avalible = new ArrayList<>();
        for (int x = 0; x < this.width; x++)
            for (int y = 0; y < this.height; y++) {
                if (matrix[x][y].nodeArray.size() == 1)
                    avalible.add(matrix[x][y]);
            }
    }

    public void mark(Node node) {
        avalible.remove(node);
    }
    public void setCircleDiameter(int circleDiameter) {
        this.circleDiameter = circleDiameter;
    }
    public int getTrunPlayer() {
        return trunPlayer;
    }
    public void setTrunPlayer(int trunPlayer) {
        this.trunPlayer = trunPlayer;
    }
}
