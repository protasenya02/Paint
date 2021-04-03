package org.example;

import javafx.scene.paint.Color;

public class EllipseFactory implements ShapeFactory{

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Ellipse(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
