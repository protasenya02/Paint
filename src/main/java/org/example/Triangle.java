package org.example;


import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

// класс треугольника
public class Triangle extends AbstractShape {

    Color fillColor;
    Color borderColor;
    int borderWidth;
    Point start;
    Point end;
    boolean fill;

    @Override
    void changeProperties(ShapeProperties shapeProperties) {

        fillColor = shapeProperties.fillColor;
        borderColor = shapeProperties.lineColor;
        borderWidth = shapeProperties.lineWidth;
        start = shapeProperties.startPoint;
        end = shapeProperties.endPoint;
        fill = shapeProperties.isFill;
    };

    @Override
    void draw(Canvas canvas){};

}
