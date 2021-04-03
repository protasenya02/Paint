package org.example;

import javafx.scene.paint.Color;

public interface ShapeFactory {

    Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
        int lineWidth);

}
