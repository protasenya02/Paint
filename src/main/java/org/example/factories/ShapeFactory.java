package org.example.factories;

import org.example.Color;
import org.example.shapes.Shape;

public interface ShapeFactory {

    Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor, int lineWidth);

}
