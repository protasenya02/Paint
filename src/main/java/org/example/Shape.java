package org.example;


import javafx.scene.canvas.GraphicsContext;

// интерфейс для всех фигур
interface Shape {

    // отрисовка фигуры на канве
    void draw(GraphicsContext gc, Point point);

    void draw(GraphicsContext gc);


}





