package org.example;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// класс круга
public class Circle implements Shape {

    private final Color fillColor;
    private final Color lineColor;
    private final int lineWidth;
    private final double[] pointsArr;
    private final boolean fill;

    public Circle(Color lineColor, boolean isFill, Color fillColor, int lineWidth, double[] pointsArr) {

        this.fillColor = fillColor;
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
        this.pointsArr = pointsArr;
        this.fill = isFill;
    };
    @Override
    public void draw(GraphicsContext gc){};
}