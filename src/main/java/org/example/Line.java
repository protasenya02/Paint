package org.example;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line implements Shape {

    private final Color lineColor;
    private final int lineWidth;
    private final double[] pointsArr;

    public Line(Color lineColor, boolean isFill, Color fillColor, int lineWidth, double[] pointsArr) {
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
        this.pointsArr = pointsArr;
    }


    @Override
    public void draw(GraphicsContext gc){
        gc.setStroke(lineColor);
        gc.setLineWidth(lineWidth);
        gc.strokeLine(pointsArr[0],pointsArr[1], pointsArr[2], pointsArr[3]);
    };

}
