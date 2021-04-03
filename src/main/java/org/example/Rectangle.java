package org.example;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;

// класс прямоугольника
public class Rectangle implements Shape {

    private final Color lineColor;
    private final boolean isLine;
    private final boolean isFill;
    private final Color fillColor;
    private final int lineWidth;
    private Point topLeftPoint;
    private Point bottomRightPoint;
    private boolean firstDrawCall = true;

    public Rectangle(Color lineColor, boolean isLine, boolean isFill, Color fillColor, int lineWidth) {

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

            double width = point.getX() - topLeftPoint.getX();
            double heigth = point.getY() - topLeftPoint.getY();

            if (isFill) {

                gc.fillRect(topLeftPoint.getX(),topLeftPoint.getY(), width, heigth);

                if (isLine) {

                    gc.strokeRect(topLeftPoint.getX(),topLeftPoint.getY(), width, heigth);

                }

            } else {

                gc.strokeRect(topLeftPoint.getX(),topLeftPoint.getY(), width, heigth);

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

        double width = bottomRightPoint.getX() - topLeftPoint.getX();
        double heigth = bottomRightPoint.getY() - topLeftPoint.getY();

        if (isFill) {

          gc.fillRect(topLeftPoint.getX(),topLeftPoint.getY(), width, heigth);

            if (isLine) {

                gc.strokeRect(topLeftPoint.getX(),topLeftPoint.getY(), width, heigth);

            }

        } else {

          gc.strokeRect(topLeftPoint.getX(),topLeftPoint.getY(), width, heigth);

        }
    };

}