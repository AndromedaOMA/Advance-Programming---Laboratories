package org.example;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Grid {
    int edge;
    GridPane gridPane;

    public Grid(int value, GridPane gridPane) {
        edge = value;
        gridPane = gridPane;
    }

    public GridPane createGrid() {
        gridPane.getChildren().clear(); // Clear existing cells

        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                Pane cell = new Pane();
                cell.setStyle("-fx-border-color: black");
                cell.setPrefSize(30, 30); // Adjust size as needed
                gridPane.add(cell, j, i);
            }
        }
        return gridPane;
    }

}
