package org.example;


import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

// класс круга
public class Circle extends AbstractShape {

    Color fillColor;
    Color borderColor;
    int borderWidth;
    Point center;
    Point radius;
    boolean fill;

    @Override
    void changeProperties(ShapeProperties shapeProperties) {

        fillColor = shapeProperties.fillColor;
        borderColor = shapeProperties.lineColor;
        borderWidth = shapeProperties.lineWidth;
        center = shapeProperties.startPoint;
        radius = shapeProperties.endPoint;
        fill = shapeProperties.isFill;
    };

    @Override
    void draw(Canvas canvas){};
}