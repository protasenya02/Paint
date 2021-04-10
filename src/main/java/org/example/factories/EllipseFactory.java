package org.example.factories;

import org.example.Color;
import org.example.shapes.Shape;
import org.example.shapes.Ellipse;

public class EllipseFactory implements ShapeFactory {

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Ellipse(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
