package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// класс прямоугольника
public class Rectangle implements Shape {

    private final Color fillColor;
    private final Color lineColor;
    private final int lineWidth;
    private double[] pointsArr;
    private final boolean fill;

    public Rectangle(Color lineColor, boolean isFill, Color fillColor, int lineWidth, double[] pointsArr) {
        this.fillColor = fillColor;
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
        this.pointsArr = pointsArr;
        this.fill = isFill;
    }

    @Override
    public void draw(GraphicsContext gc){};
}