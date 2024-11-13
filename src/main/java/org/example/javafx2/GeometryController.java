package org.example.javafx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class GeometryController {

    Random r = new Random();

    private GraphicsContext gc;

    @FXML
    private AnchorPane paneMain;

    @FXML
    private Canvas canvas;

    @FXML
    private Button btnCircle;

    @FXML
    private Button btnRect;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
    }

    @FXML
    void circleAct(ActionEvent event) {
        int x = r.nextInt((int) paneMain.getWidth());
        int y = r.nextInt((int) paneMain.getHeight());
        int radius = r.nextInt(50) + 10;
        gc.fillOval(x, y, radius, radius);
    }

    @FXML
    void rectAct(ActionEvent event) {
        int x = r.nextInt((int) paneMain.getWidth());
        int y = r.nextInt((int) paneMain.getHeight());
        int radius = r.nextInt(50) + 10;
        gc.fillRect(x, y, radius, radius);

    }
}
