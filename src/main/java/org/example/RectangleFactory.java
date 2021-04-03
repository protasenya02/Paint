package org.example;

import javafx.scene.paint.Color;

public class RectangleFactory implements ShapeFactory{

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Rectangle(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
