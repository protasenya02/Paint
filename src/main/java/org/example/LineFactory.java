package org.example;

public class LineFactory implements ShapeFactory {

    @Override
    public Shape createShape() {
        return new Line();
    }
}
