package org.example;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;

public class Ellipse implements Shape {

    private final Color lineColor;
    private final boolean isLine;
    private final boolean isFill;
    private final Color fillColor;
    private final int lineWidth;
    private Point topLeftPoint;
    private Point bottomRightPoint;
    private boolean firstDrawCall = true;

    public Ellipse(Color lineColor, boolean isLine, boolean isFill, Color fillColor, int lineWidth) {

        this.lineColor = lineColor;
        this.isLine = isLine;
        this.isFill = isFill;
        this.fillColor = fillColor;
        this.lineWidth = lineWidth;

    }

    @Override
    public boolean draw(GraphicsContext gc, Point point) {

        if (!firstDrawCall) {

            gc.setStroke(lineColor);
            gc.setLineWidth(lineWidth);
            gc.setFill(fillColor);

            bottomRightPoint = point;

            double height = (point.getY() > topLeftPoint.getY()) ? (point.getY() - topLeftPoint.getY()) :
                (topLeftPoint.getY() - point.getY());

            double width = (point.getX() > topLeftPoint.getX()) ? (point.getY() - topLeftPoint.getY()) :
                (topLeftPoint.getX() - point.getX());

            if (isFill) {

                gc.fillOval(topLeftPoint.getX(), topLeftPoint.getY() - (height / 2), width, height);

                if (isLine) {

                    gc.strokeOval(topLeftPoint.getX(), topLeftPoint.getY() - (height / 2), width, height);

                }

            } else {

                gc.strokeOval(topLeftPoint.getX(), topLeftPoint.getY() - (height / 2), width, height);

            }

            return false;
        }

        topLeftPoint = point;
        firstDrawCall = false;
        return true;

    };

    @Override
    public void draw(GraphicsContext gc) {

        gc.setStroke(lineColor);
        gc.setLineWidth(lineWidth);
        gc.setFill(fillColor);

        double height = (bottomRightPoint.getY() > topLeftPoint.getY()) ? (bottomRightPoint.getY() - topLeftPoint.getY()) :
            (topLeftPoint.getY() - bottomRightPoint.getY());

        double width = (bottomRightPoint.getX() > topLeftPoint.getX()) ? (bottomRightPoint.getY() - topLeftPoint.getY()) :
            (topLeftPoint.getX() - bottomRightPoint.getX());

        if (isFill) {

            gc.fillOval(topLeftPoint.getX(),topLeftPoint.getY() - (height/2), width, height);

            if (isLine) {

                gc.strokeOval(topLeftPoint.getX(), topLeftPoint.getY() - (height / 2), width, height);

            }

        } else {

            gc.strokeOval(topLeftPoint.getX(),topLeftPoint.getY() - (height/2), width, height);

        }

    };
}
