package org.example.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    private final Color lineColor;
    private final boolean isLine;
    private final boolean isFill;
    private final Color fillColor;
    private final int lineWidth;
    private Point firstPoint;
    private Point secondPoint;
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

            secondPoint = point;
            fill(gc);

            return false;
        }

        firstPoint = point;
        firstDrawCall = false;

        return true;
    }

    @Override
    public void fill(GraphicsContext gc) {

        gc.setStroke(lineColor);
        gc.setLineWidth(lineWidth);
        gc.setFill(fillColor);

        double width = Math.abs(secondPoint.getX() - firstPoint.getX());
        double height = Math.abs(secondPoint.getY() - firstPoint.getY());

        double startPointX = Math.min(firstPoint.getX(), secondPoint.getX());
        double startPointY = Math.min(firstPoint.getY(), secondPoint.getY());

        if (isFill) {

            gc.fillRect(startPointX, startPointY, width, height);

            if (isLine) {

                gc.strokeRect(startPointX, startPointY, width, height);

            }

        } else {

            gc.strokeRect(startPointX, startPointY, width, height);

        }
    }

    @Override
    public void deleteLastPoint() {

    }
}