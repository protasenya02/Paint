package org.example.plugins.trapezoid;
import org.example.core.Color;
import org.example.core.IService;
import org.example.core.ShapeFactory;

public class Service implements IService {

  @Override
  public String getShapeName() {
    return "Trapezoid";
  }

  @Override
  public ShapeFactory createFactory() {
    return new TrapezoidFactory();
  }
}
