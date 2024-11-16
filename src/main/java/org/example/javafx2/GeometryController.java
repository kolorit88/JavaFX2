package org.example.javafx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.example.javafx2.geometry2d.*;

import java.util.*;
import java.util.Random;

public class GeometryController {

    Random r = new Random();

    private final List<Figure> allFigures = new ArrayList<>();
    private Figure selectedFigure;
    double correctionCatchX, correctionCatchY;

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

        canvas.setOnMousePressed(this::MousePressed);
        canvas.setOnMouseReleased(this::MouseReleased);
        canvas.setOnMouseDragged(this::MouseDragged);

    }

    @FXML
    void circleAct(ActionEvent event) {
        List<Double> param = randomParameters();
        Circle circle = new Circle(param.get(0), param.get(1), param.get(2));
        allFigures.addFirst(circle);
        circle.draw(canvas);
    }

    @FXML
    void rectAct(ActionEvent event) {
        List<Double> param = randomParameters();
        Rectangle rectangle = new Rectangle(param.get(0), param.get(1), param.get(2), param.get(2));
        allFigures.addFirst(rectangle);
        rectangle.draw(canvas);
    }

    private List<Double> randomParameters() {
        double x = r.nextInt((int) paneMain.getWidth());
        double y = r.nextInt((int) paneMain.getHeight());
        double size = r.nextInt(70) + 50;
        return List.of(x, y, size);
    }

    private void MousePressed(MouseEvent event) {
        for(Figure figure : allFigures) {
            if(figure.intersection(event.getX(), event.getY())) {
                if(event.isPrimaryButtonDown()) {
                    selectedFigure = figure;
                    allFigures.remove(selectedFigure);
                    allFigures.addFirst(selectedFigure);
                    correctionCatchX = event.getX() - selectedFigure.getX();
                    correctionCatchY = event.getY() - selectedFigure.getY();
                    updateCanvas();
                    break;
                }
                else if(event.isSecondaryButtonDown()) {
                    Random random = new Random();
                    figure.setColor(Color.color(random.nextDouble(1), random.nextDouble(1), random.nextDouble(1)));
                    updateCanvas();
                    break;
                }
            }
        }
    }

    private void MouseReleased(MouseEvent mouseEvent) {
        selectedFigure = null;
    }

    private void MouseDragged(MouseEvent mouseEvent) {
        if(selectedFigure != null) {
            selectedFigure.moveTo(mouseEvent.getX() - correctionCatchX, mouseEvent.getY() - correctionCatchY);
            updateCanvas();
        }
    }

    private void updateCanvas(){
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for(Figure figure : allFigures.reversed()) {
            figure.draw(canvas);
        }
    }


}
