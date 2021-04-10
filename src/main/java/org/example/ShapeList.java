package org.example;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import org.example.shapes.Shape;

public class ShapeList {

  private final ArrayList<Shape> shapeList = new ArrayList<>();
  private int shapesCounter = 0;

  public void addShape(Shape shape) {

    clearUndoShapes();
    shapesCounter++;
    shapeList.add(shape);

  }

  public void undoShape(GraphicsContext gc) {

    if  (shapesCounter > 0) {
      shapesCounter--;
    }

    clearCanvas(gc);
    drawShapesFromCounter(gc);
  }

  public void redoShape(GraphicsContext gc) {

    if  (shapesCounter < shapeList.size()) {
      shapesCounter++;
    }

    clearCanvas(gc);
    drawShapesFromCounter(gc);
  }

  public void clear() {

    shapeList.clear();
    shapesCounter = 0;

  }

  public void drawAll(GraphicsContext gc) {

    for (Shape shape : shapeList) {
      shape.fill(gc);
    }

  }

  public void drawPreview(GraphicsContext gc) {

    for (int i = 0; i < shapeList.size()-1; i++) {
      shapeList.get(i).fill(gc);
    }

  }

  private void drawShapesFromCounter(GraphicsContext gc) {

    for (int i = 0; i < shapesCounter; i++) {
      shapeList.get(i).fill(gc);
    }

  }

  private void clearUndoShapes() {

    if (shapesCounter < shapeList.size()) {

      for (int i = shapeList.size() - 1; i>= shapesCounter; i--) {
           shapeList.remove(i);
      }
    }
  }

  public void clearCanvas(GraphicsContext gc){

    double width = gc.getCanvas().getWidth();
    double height = gc.getCanvas().getHeight();

    gc.clearRect(0, 0, width, height);

  }




}
