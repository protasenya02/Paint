package org.example.factories;

import javafx.scene.paint.Color;
import org.example.shapes.Shape;
import org.example.shapes.Circle;

public class CircleFactory implements ShapeFactory {

    @Override
    public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth) {

        return new Circle(lineColor, isLine, isFill, fillColor, lineWidth);

    }
}
