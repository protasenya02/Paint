package org.example.factories;

import org.example.core.Color;
import org.example.core.Shape;
import org.example.core.ShapeFactory;
import org.example.shapes.Ellipse;

public class EllipseFactory implements ShapeFactory {

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Ellipse(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
