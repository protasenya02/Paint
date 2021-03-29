package org.example;

import javafx.scene.paint.Color;

public class PolylineFactory implements ShapeFactory{

    @Override
    public Shape createShape(Color lineColor, boolean isFill, Color fillColor, int lineWidth, double[] pointsArr) {
        return new Polyline(lineColor, isFill, fillColor, lineWidth, pointsArr);
    }
}
