package org.example;


import javafx.scene.canvas.GraphicsContext;

// интерфейс для всех фигур
@FunctionalInterface
interface Shape {

    // отрисовка фигуры на канве
    void draw(GraphicsContext gc);
}





