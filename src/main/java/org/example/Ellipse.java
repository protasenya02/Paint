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

            double height = countHeight();
            double width = countWidth();

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

        double height = countHeight();
        double width = countWidth();

        if (isFill) {

            gc.fillOval(topLeftPoint.getX(),topLeftPoint.getY() - (height/2), width, height);

            if (isLine) {

                gc.strokeOval(topLeftPoint.getX(), topLeftPoint.getY() - (height / 2), width, height);

            }

        } else {

            gc.strokeOval(topLeftPoint.getX(),topLeftPoint.getY() - (height/2), width, height);

        }

    };

    private double countWidth() {

        double width;

        if (bottomRightPoint.getX() > topLeftPoint.getX()) {

            width = bottomRightPoint.getY() - topLeftPoint.getY();

        } else {

            width = topLeftPoint.getX() - bottomRightPoint.getX();

        }

        return width;
    }


    private double countHeight() {

        double height;

        if (bottomRightPoint.getY() > topLeftPoint.getY()) {

            height = bottomRightPoint.getY() - topLeftPoint.getY();

        } else {

            height = topLeftPoint.getY() - bottomRightPoint.getY();

        }

        return height;
    }

}
