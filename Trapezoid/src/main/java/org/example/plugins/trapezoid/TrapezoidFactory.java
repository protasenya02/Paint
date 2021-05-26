package org.example.plugins.trapezoid;

import org.example.core.Color;
import org.example.core.Shape;
import org.example.core.ShapeFactory;

public class TrapezoidFactory implements ShapeFactory {

  @Override
  public Shape createShape(Color lineColor, boolean isLine, boolean isFill, Color fillColor,
      int lineWidth) {

    return new Trapezoid(lineColor, isLine, isFill, fillColor, lineWidth);
  }
}
