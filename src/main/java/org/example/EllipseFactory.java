package org.example;

import javafx.scene.paint.Color;

public class EllipseFactory implements ShapeFactory{

    @Override
    public Shape createShape(Color lineColor, boolean isFill, Color fillColor, int lineWidth) {
        return new Ellipse(lineColor, isFill, fillColor, lineWidth);
    }
}
