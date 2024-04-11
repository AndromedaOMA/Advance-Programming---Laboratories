package org.example;

//source: https://www.geeksforgeeks.org/javafx-button-with-examples/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

//command: mvn clean javafx:run

public class GridGame extends Application {

    @Override
    public void start(Stage scene) {
        scene.setTitle("GridGame");
        BorderPane root = new BorderPane();

        //navbar
        Button button = new Button("Create");
        Label label = new Label("button not clicked");
        Label welcomeText = new Label("Grid size: ");
        TextField textField = new TextField();


        VBox navbar = new VBox(5);
        navbar.getChildren().addAll(welcomeText, textField, button, label);
        navbar.setAlignment(Pos.CENTER);
        root.setTop(navbar);

        //grid
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        root.setCenter(gridPane);

        //bottom
        Button loadBtn = new Button("Load");
        Button saveBtn = new Button("Save");
        VBox bottom = new VBox(5);
        bottom.getChildren().addAll(loadBtn, saveBtn);
        bottom.setAlignment(Pos.CENTER);
        root.setBottom(bottom);

        //event
        EventHandler<ActionEvent> event = e -> {
            final String inputText = textField.getText();

            if (inputText == null || inputText.isEmpty()) {
                label.setText("String cannot be parsed, it is null or empty.");
            }

            try {
                assert inputText != null;
                int size = Integer.parseInt(inputText);
                label.setText("You entered: " + inputText);
                //grid
                GridGenerator grid = new GridGenerator();
                grid.createBoard(gridPane, size);

            } catch (NumberFormatException err) {
                label.setText("The input is not OK!");
            }
        };
        button.setOnAction(event);

        //final
        Scene sc = new Scene(root, 600, 700);
        scene.setScene(sc);
        scene.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


// Course example:

// //The main class extends Application
//public class HelloWorld extends Application {
//    @Override
//    public void start(Stage primaryStage) {
//        //The main entry point
//
//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
//        Button helloBtn = new Button();
//        helloBtn.setText("Hello World!");
//        FlowPane root = new FlowPane();
//        root.getChildren().add(helloBtn);
//        Scene scene = new Scene(root, 300, 250);
//        //The UI is defined by a stage and a scene.
//        // Stage class is the top-level JavaFX container.
//        // The Scene class is the container for all content.
//        primaryStage.setTitle("Hello World Application");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args); //not required for JavaFX applications...
//    }
//}