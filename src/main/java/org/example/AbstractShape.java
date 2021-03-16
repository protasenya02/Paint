package org.example;


import javafx.scene.canvas.Canvas;

// абстрактный класс для всех фигур
public abstract class AbstractShape {

    // изменение свойств фигур
    abstract void changeProperties(ShapeProperties shapeProperties);
    // отрисовка фигуры на канве
    abstract void draw(Canvas canvas);
}





