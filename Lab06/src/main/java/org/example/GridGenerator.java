package org.example;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GridGenerator {
    void createBoard(GridPane gridPane, int gridSize) {
        gridPane.getChildren().clear();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Pane cell = new Pane();
                cell.setStyle("-fx-border-color: black");
                cell.setPrefSize(40, 40);
                gridPane.add(cell, j, i);
            }
        }
    }
}
