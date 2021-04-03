package org.example;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse implements Shape {

    private final Color fillColor;
    private final Color lineColor;
    private final int lineWidth;
    private  Point[] pointsArr;
    private final boolean fill;

    public Ellipse(Color lineColor, boolean isFill, Color fillColor, int lineWidth) {
        this.lineColor = lineColor;
        this.fillColor = fillColor;
        this.fill = isFill;
        this.lineWidth = lineWidth;
    }

    @Override
    public void draw(GraphicsContext gc){};

    @Override
    public void draw(GraphicsContext gc, Point point) {};
}
