package org.example.factories;

import org.example.shapeOptions.Color;
import org.example.shapes.Shape;
import org.example.shapes.Polygon;

public class PolygonFactory implements ShapeFactory {

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Polygon(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
