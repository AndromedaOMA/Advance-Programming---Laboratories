package org.example.lab6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private int turnPlayer;
    private Board currentBoard;
    @FXML
    private Canvas canvasS;
    GraphicsContext graphicsContext;
    @FXML
    private Spinner<Integer> spinnerH;
    int currentValueSpinnerH;
    @FXML
    private Spinner<Integer> spinnerW;
    int currentValueSpinnerW;

    @FXML
    public void LoadClick(ActionEvent actionEvent) {
        try {
            FileInputStream fileIn = new FileInputStream("saved_board.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            currentBoard = (Board) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Game board loaded from 'saved_board.ser'.");

            this.graphicsContext.clearRect(0, 0, canvasS.getWidth(), canvasS.getHeight());
            DrawBoard();
            CollorDraw();
            this.turnPlayer = currentBoard.getTrunPlayer();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the game board: " + e.getMessage());
        }
    }

    @FXML
    public void SaveClick(ActionEvent actionEvent) {
        try {
            currentBoard.setTrunPlayer(turnPlayer);
            FileOutputStream fileOut = new FileOutputStream("saved_board.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(currentBoard);
            out.close();
            fileOut.close();
            System.out.println("Game board saved as 'saved_board.ser'.");
        } catch (IOException e) {
            System.out.println("Error saving the game board: " + e.getMessage());
        }
        exportGameBoardImage(canvasS);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactoryW = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 20, 2);
        spinnerW.setValueFactory(valueFactoryW);
        currentValueSpinnerW = spinnerW.getValue();

        SpinnerValueFactory<Integer> valueFactoryH = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 20, 2);
        spinnerH.setValueFactory(valueFactoryH);
        currentValueSpinnerH = spinnerH.getValue();
        this.graphicsContext = canvasS.getGraphicsContext2D();
        //graphicsContext.strokeLine(0,0,200,200);
        graphicsContext.setLineWidth(3);
        turnPlayer = 1;
    }

    public void DrawBoard() {
        int distanceOnX = (int) (canvasS.getWidth() / this.currentBoard.width);
        int distanceOnY = (int) (canvasS.getHeight() / this.currentBoard.height);

        ///Circles
        int circleDiameter = Math.min(distanceOnX, distanceOnY) / 2;
        this.currentBoard.setCircleDiameter(circleDiameter);
        for (int x = 0; x < this.currentBoard.width; x++) {
            for (int y = 0; y < this.currentBoard.height; y++) {
                int topLeftX = x * distanceOnX + (distanceOnX - circleDiameter) / 2;
                int topLeftY = y * distanceOnY + (distanceOnY - circleDiameter) / 2;
                this.currentBoard.matrix[x][y].setX(topLeftX);
                this.currentBoard.matrix[x][y].setY(topLeftY);
                graphicsContext.strokeOval(topLeftX, topLeftY, circleDiameter, circleDiameter);
            }
        }
        ///Lines
        for (int x = 0; x < this.currentBoard.width; x++)
            for (int y = 0; y < this.currentBoard.height; y++) {
                ///normal lines
                graphicsContext.setLineWidth(1);
                if (x < this.currentBoard.width - 1)
                    graphicsContext.strokeLine(this.currentBoard.matrix[x][y].getX() + circleDiameter / 2, this.currentBoard.matrix[x][y].getY() + circleDiameter / 2, this.currentBoard.matrix[x + 1][y].getX() + circleDiameter / 2, this.currentBoard.matrix[x + 1][y].getY() + circleDiameter / 2);
                if (y < this.currentBoard.height - 1)
                    graphicsContext.strokeLine(this.currentBoard.matrix[x][y].getX() + circleDiameter / 2, this.currentBoard.matrix[x][y].getY() + circleDiameter / 2, this.currentBoard.matrix[x][y + 1].getX() + circleDiameter / 2, this.currentBoard.matrix[x][y + 1].getY() + circleDiameter / 2);
                ///connections
                graphicsContext.setLineWidth(5);
                if (x < this.currentBoard.width - 1 && this.currentBoard.matrix[x][y].isConnected(this.currentBoard.matrix[x + 1][y]))
                    graphicsContext.strokeLine(this.currentBoard.matrix[x][y].getX() + circleDiameter / 2, this.currentBoard.matrix[x][y].getY() + circleDiameter / 2, this.currentBoard.matrix[x + 1][y].getX() + circleDiameter / 2, this.currentBoard.matrix[x + 1][y].getY() + circleDiameter / 2);
                if (y < this.currentBoard.height - 1 && this.currentBoard.matrix[x][y].isConnected(this.currentBoard.matrix[x][y + 1]))
                    graphicsContext.strokeLine(this.currentBoard.matrix[x][y].getX() + circleDiameter / 2, this.currentBoard.matrix[x][y].getY() + circleDiameter / 2, this.currentBoard.matrix[x][y + 1].getX() + circleDiameter / 2, this.currentBoard.matrix[x][y + 1].getY() + circleDiameter / 2);

                graphicsContext.setLineWidth(3);
            }
    }

    public void CollorDraw() {
        ///circles
        for (int x = 0; x < this.currentBoard.width; x++)
            for (int y = 0; y < this.currentBoard.height; y++) {
                if (currentBoard.matrix[x][y].getColor() == 1) {
                    graphicsContext.setFill(Color.RED);
                    graphicsContext.fillOval(currentBoard.matrix[x][y].getX(), currentBoard.matrix[x][y].getY(), currentBoard.circleDiameter, currentBoard.circleDiameter);
                }
                if (currentBoard.matrix[x][y].getColor() == 2) {
                    graphicsContext.setFill(Color.BLUE);
                    graphicsContext.fillOval(currentBoard.matrix[x][y].getX(), currentBoard.matrix[x][y].getY(), currentBoard.circleDiameter, currentBoard.circleDiameter);
                }
            }
    }

    @FXML
    public void CreateClick(ActionEvent actionEvent) {
        this.graphicsContext.clearRect(0, 0, canvasS.getWidth(), canvasS.getHeight());
        this.currentBoard = new Board(spinnerW.getValue(), spinnerH.getValue());
        //System.out.println("Width:"+this.currentBoard.getWidth()+" Height:"+this.currentBoard.getHeight());
        this.turnPlayer = 1;
        currentBoard.setTrunPlayer(turnPlayer);
        DrawBoard();
    }

    @FXML
    public void MarkCircle(MouseEvent mouseEvent) {
        double xMouse = mouseEvent.getX();
        double yMouse = mouseEvent.getY();

        for (int x = 0; x < this.currentBoard.width; x++)
            for (int y = 0; y < this.currentBoard.height; y++) {
                if (inCircle(xMouse, yMouse, currentBoard.matrix[x][y]) && currentBoard.matrix[x][y].getColor() == 0 && currentBoard.avalible.contains(currentBoard.matrix[x][y])) {
                    currentBoard.mark(currentBoard.matrix[x][y]);
                    if (this.turnPlayer == 1) {
                        System.out.println(" RED");
                        currentBoard.matrix[x][y].setColor(1);
                        if (currentBoard.avalible.isEmpty())
                            System.out.println("RED WINS");
                        turnPlayer = 2;
                        currentBoard.setTrunPlayer(turnPlayer);

                    } else {
                        System.out.println(" BLUE");
                        currentBoard.matrix[x][y].setColor(2);
                        if (currentBoard.avalible.isEmpty())
                            System.out.println("BLUE WINS");
                        turnPlayer = 1;
                        currentBoard.setTrunPlayer(turnPlayer);
                    }
                }
            }
        CollorDraw();
    }

    public boolean inCircle(double xM, double yM, Node node) {
        int radius = this.currentBoard.circleDiameter / 2;
        int circleCenterX = node.getX() + radius;
        int circleCenterY = node.getY() + radius;

        // distance between the mouse coordinates and the center of the circle
        double distance = Math.sqrt(Math.pow(xM - circleCenterX, 2) + Math.pow(yM - circleCenterY, 2));

        return distance <= radius;
    }

    public void exportGameBoardImage(Canvas canvas) {
        WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        canvas.snapshot(params, writableImage);

        BufferedImage bufferedImage = new BufferedImage((int) canvas.getWidth(), (int) canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
        PixelReader pixelReader = writableImage.getPixelReader();
        for (int x = 0; x < (int) canvas.getWidth(); x++) {
            for (int y = 0; y < (int) canvas.getHeight(); y++) {
                bufferedImage.setRGB(x, y, pixelReader.getArgb(x, y));
            }
        }


        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String dateInFilename = now.format(formatter);

        String filename = "game_board_" + dateInFilename + ".png";
        File file = new File(filename);

        try {
            ImageIO.write(bufferedImage, "png", file);
            System.out.println("Game board image exported as '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("Error exporting the game board image: " + e.getMessage());
        }
    }
}