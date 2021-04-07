package org.example;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;

// интерфейс для всех фигур
interface Shape {

    boolean draw(GraphicsContext gc, Point point);

    void fill(GraphicsContext gc);

    void deleteLastPoint();

}





