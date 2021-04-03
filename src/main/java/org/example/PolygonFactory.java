package org.example;

import javafx.scene.paint.Color;

public class PolygonFactory implements ShapeFactory{
    @Override
    public Shape createShape(Color lineColor, boolean isFill, Color fillColor, int lineWidth) {
      return new Polygon(lineColor, isFill, fillColor, lineWidth);
    }
}
