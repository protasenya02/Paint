package org.example;

public class EllipseFactory implements ShapeFactory{

    @Override
    public Shape createShape() {
        return new Ellipse();
    }
}
