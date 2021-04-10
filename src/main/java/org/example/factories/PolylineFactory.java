package org.example.factories;

import javafx.scene.paint.Color;
import org.example.shapes.Shape;
import org.example.shapes.Polyline;

public class PolylineFactory implements ShapeFactory {

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Polyline(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
