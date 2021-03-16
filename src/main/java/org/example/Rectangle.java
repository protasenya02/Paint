package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

// класс прямоугольника
public class Rectangle extends AbstractShape {

    Color fillColor;
    Color borderColor;
    int borderWidth;
    Point topLeft;
    Point bottomRight;
    boolean fill;

    @Override
    void changeProperties(ShapeProperties shapeProperties) {

        fillColor = shapeProperties.fillColor;
        borderColor = shapeProperties.lineColor;
        borderWidth = shapeProperties.lineWidth;
        topLeft = shapeProperties.startPoint;
        bottomRight = shapeProperties.endPoint;
        fill = shapeProperties.isFill;
    };

    @Override
    void draw(Canvas canvas){};
}