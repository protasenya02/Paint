package org.example;

import javafx.scene.paint.Color;

public class LineFactory implements ShapeFactory {

    @Override
    public Shape createShape(Color lineColor, boolean isFill, Color fillColor, int lineWidth) {
         return new Line(lineColor, isFill, fillColor, lineWidth);
    }
}