package org.example;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;


public class Polyline implements Shape {

    private final Color lineColor;
    private final int lineWidth;
    private ArrayList<Point> pointsArr = new ArrayList<>();
    private boolean firstDrawCall = true;

    public Polyline(Color lineColor,boolean isLine, boolean isFill, Color fillColor, int lineWidth) {

        this.lineColor = lineColor;
        this.lineWidth = lineWidth;

    };

    @Override
    public boolean draw(GraphicsContext gc, Point point) {

        pointsArr.add(point);
        fill(gc);

        return true;
    };

    @Override
    public void fill(GraphicsContext gc){

        if (pointsArr.size() > 2 ) {

            gc.setStroke(lineColor);
            gc.setLineWidth(lineWidth);
            gc.setLineCap(StrokeLineCap.ROUND);
            gc.setLineJoin(StrokeLineJoin.ROUND);

            int nPoints = pointsArr.size();
            double[] xPoints = new double[nPoints];
            double[] yPoints = new double[nPoints];

            for (int i = 0; i < pointsArr.size(); i++) {
                xPoints[i] = pointsArr.get(i).getX();
                yPoints[i] = pointsArr.get(i).getY();
            }

            gc.strokePolyline(xPoints, yPoints, nPoints);
        }
    };

    @Override
    public void deleteLastPoint() {

        if (pointsArr.size() > 2) {

            pointsArr.remove(pointsArr.size() - 1);

        }
    };

}
