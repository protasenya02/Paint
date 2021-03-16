package org.example;


import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

// класс линии
public class Line extends AbstractShape {

    Color lineColor;
    int lineWidth;
    Point start;
    Point end;

    @Override
    void changeProperties(ShapeProperties shapeProperties) {

        lineColor = shapeProperties.lineColor;
        lineWidth = shapeProperties.lineWidth;
        end = shapeProperties.endPoint;
        start = shapeProperties.startPoint;
    };

    @Override
    void draw(Canvas canvas){};

}