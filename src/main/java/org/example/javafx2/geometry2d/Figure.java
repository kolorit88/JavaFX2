package org.example.javafx2.geometry2d;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Figure {
    protected double x;
    protected double y;
    protected Color color;

    public Figure(double x, double y) {
        Random random = new Random();
        this.color = Color.color(random.nextDouble(1), random.nextDouble(1), random.nextDouble(1));
        this.x = x;
        this.y = y;
    }

    public Figure(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void moveTo(double x, double y){
        this.x = x;
        this.y = y;
    };


    public abstract void draw(Canvas canvas);

    public abstract boolean intersection(double x, double y);
}
