package org.example.javafx2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.javafx2.geometry2d.Figure;
import static java.lang.Math.*;

public class Circle extends Figure {
    protected double diameter;

    public Circle(double x, double y, double diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public Circle(double x, double y, double diameter, Color color) {
        super(x, y, color);
        this.diameter = diameter;
    }

    @Override
    public boolean intersection(double x, double y) {
        double DistanceMouseToCenterX = Math.abs((this.diameter / 2 + this.x) - x);
        double DistanceMouseToCenterY = Math.abs((this.diameter / 2 + this.y) - y);
        double distance = round(sqrt(DistanceMouseToCenterY  *  DistanceMouseToCenterY
                + DistanceMouseToCenterX * DistanceMouseToCenterX));
        return  distance <= diameter / 2;
    }

    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillOval(x - 5, y - 5, diameter + 10, diameter + 10);
        gc.setFill(color);
        gc.fillOval(x, y, diameter, diameter);
    }

}
