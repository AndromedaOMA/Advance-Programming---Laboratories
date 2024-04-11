package org.example;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class GridGenerator {
    void createBoard(GridPane gridPane, int gridSize) {
        gridPane.getChildren().clear();

        for (int a = 0; a < gridSize; a++) {
            for (int j = 0; j < gridSize; j++) {
                Pane cell = new Pane();
                cell.setStyle("-fx-border-color: black");
                cell.setPrefSize(40, 40);

                Circle topLeft = new Circle(10, Color.TRANSPARENT);
                topLeft.setStroke(Color.BLACK);
                topLeft.setTranslateX(0);
                topLeft.setTranslateY(0);
                Circle topRight = new Circle(10, Color.TRANSPARENT);
                topRight.setStroke(Color.BLACK);
                topRight.setTranslateX(40);
                topRight.setTranslateY(0);
                Circle bottomLeft = new Circle(10, Color.TRANSPARENT);
                bottomLeft.setStroke(Color.BLACK);
                bottomLeft.setTranslateX(0);
                bottomLeft.setTranslateY(40);
                Circle bottomRight = new Circle(10, Color.TRANSPARENT);
                bottomRight.setStroke(Color.BLACK);
                bottomRight.setTranslateX(40);
                bottomRight.setTranslateY(40);

                cell.getChildren().addAll(topLeft, topRight, bottomLeft, bottomRight);
                gridPane.add(cell, j, a);

                Random random = new Random();
                for (int k = 0; k < gridSize; k++) {
                    for (int l = 0; l < gridSize; l++) {
                        // Create horizontal line on top edge
                        Rectangle topLine = new Rectangle(40, 3, Color.BLACK);
                        topLine.setTranslateX(l * 40 - 40);
                        topLine.setTranslateY(k * 40);

                        // Create horizontal line on bottom edge
                        Rectangle bottomLine = new Rectangle(40, 3, Color.BLACK);
                        bottomLine.setTranslateX(l * 40 - 40);
                        bottomLine.setTranslateY(k * 40);

                        // Create vertical line on right edge
                        Rectangle rightLine = new Rectangle(3, 40, Color.BLACK);
                        rightLine.setTranslateX((l + 1) * 40);
                        rightLine.setTranslateY(k * 40 - 40);

                        // Randomly choose whether to add lines on top, bottom, or right edge
                        if (random.nextBoolean()) {
                            gridPane.getChildren().add(topLine);
                        }
                        if (random.nextBoolean()) {
                            gridPane.getChildren().add(bottomLine);
                        }
                        if (random.nextBoolean() && l < gridSize - 1) { // Avoid adding right edge for the last column
                            gridPane.getChildren().add(rightLine);
                        }
                    }
                }
            }
        }
    }
}
