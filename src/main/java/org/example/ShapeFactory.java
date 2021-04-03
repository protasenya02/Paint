package org.example;

import javafx.scene.paint.Color;

public interface ShapeFactory {
    Shape createShape(Color lineColor, boolean isFill, Color fillColor, int lineWidth);

}
