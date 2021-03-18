package org.example;

public class PolygonFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Polygon();
    }
}
