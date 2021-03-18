package org.example;

public class PolylineFactory implements ShapeFactory{

    @Override
    public Shape createShape() {
        return new Polyline();
    }
}
