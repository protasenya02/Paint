package org.example;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line implements Shape {

    private final Color lineColor;
    private final int lineWidth;
    private final Point[] pointsArr;

    public Line(Color lineColor, boolean isFill, Color fillColor, int lineWidth, Point[] pointsArr) {
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
        this.pointsArr = pointsArr;
    }

    @Override
    public void draw(GraphicsContext gc){};
}
