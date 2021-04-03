package org.example;


import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class Polygon implements Shape {

    private final Color fillColor;
    private final Color lineColor;
    private final int lineWidth;
    private final boolean isLine;
    private ArrayList<Point> pointsArr = new ArrayList<>();
    private final boolean isFill;
    private boolean firstDrawCall = true;
    private boolean fillShape = false;

    public Polygon(Color lineColor, boolean isLine, boolean isFill, Color fillColor, int lineWidth) {

        this.fillColor = fillColor;
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
        this.isFill = isFill;
        this.isLine = isLine;

    };

    @Override
    public boolean draw(GraphicsContext gc, Point point){

        if (!firstDrawCall) {

            gc.setStroke(lineColor);
            gc.setLineWidth(lineWidth);
            gc.setLineCap(StrokeLineCap.ROUND);
            gc.strokeLine(pointsArr.get(pointsArr.size()-1).getX(),pointsArr.get(pointsArr.size()-1).getY(),
                point.getX(), point.getY());


        }

        pointsArr.add(point);
        firstDrawCall = false;
        return true;

    };

    @Override
    public void draw(GraphicsContext gc){};
}
