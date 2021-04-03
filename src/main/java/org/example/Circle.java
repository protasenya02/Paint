package org.example;


import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;
import static java.lang.Math.*;

// класс круга
public class Circle implements Shape {

    private final Color lineColor;
    private final boolean isLine;
    private final boolean isFill;
    private final Color fillColor;
    private final int lineWidth;
    private Point centerPoint;
    private Point radiusPoint;
    private boolean firstDrawCall = true;

    public Circle(Color lineColor, boolean isLine, boolean isFill, Color fillColor, int lineWidth) {

        this.lineColor = lineColor;
        this.isLine = isLine;
        this.isFill = isFill;
        this.fillColor = fillColor;
        this.lineWidth = lineWidth;

    };

    @Override
    public boolean draw(GraphicsContext gc, Point point){

        if (!firstDrawCall) {

            gc.setStroke(lineColor);
            gc.setLineWidth(lineWidth);
            gc.setFill(fillColor);

            radiusPoint = point;

            double radius = sqrt(pow((radiusPoint.getX()- centerPoint.getX()), 2)
                + pow((radiusPoint.getY() - centerPoint.getY()), 2));
            double diameter  = radius*2;

            if (isFill) {

               gc.fillOval(centerPoint.getX() - radius, centerPoint.getY() - radius,
                   diameter , diameter );

                if (isLine) {

                gc.strokeOval(centerPoint.getX() - radius, centerPoint.getY() - radius,
                    diameter, diameter);

                }

            } else {

                gc.strokeOval(centerPoint.getX() - radius, centerPoint.getY() - radius,
                    diameter , diameter );

            }
            return false;
        }

        centerPoint = point;
        firstDrawCall = false;
        return true;
    };

    @Override
    public void draw(GraphicsContext gc) {

        gc.setStroke(lineColor);
        gc.setLineWidth(lineWidth);
        gc.setFill(fillColor);

        double radius = sqrt(pow((radiusPoint.getX()- centerPoint.getX()), 2)
            + pow((radiusPoint.getY() - centerPoint.getY()), 2));
        double diameter  = radius*2;

        if (isFill) {

            gc.fillOval(centerPoint.getX() - radius, centerPoint.getY() - radius,
                diameter , diameter );

            if (isLine) {

                gc.strokeOval(centerPoint.getX() - radius, centerPoint.getY() - radius,
                    diameter , diameter );

            }

        } else {

            gc.strokeOval(centerPoint.getX() - radius, centerPoint.getY() - radius,
                diameter , diameter );

        }

    };


}