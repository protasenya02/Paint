package org.example;

import javafx.scene.paint.Color;

public class CircleFactory implements ShapeFactory {

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Circle(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
