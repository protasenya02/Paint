package org.example;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line implements Shape {

    private final Color lineColor;
    private final int lineWidth;
    private Point[] pointsArr;

    public Line(Color lineColor, boolean isFill, Color fillColor, int lineWidth) {
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
    }

    @Override
    public void draw(GraphicsContext gc){

        gc.setStroke(lineColor);
        gc.setLineWidth(lineWidth);
        gc.strokeLine(pointsArr[0].getX(),pointsArr[0].getY(), pointsArr[1].getX(), pointsArr[1].getY());
    };


    @Override
    public void draw(GraphicsContext gc, Point point) {};



}
