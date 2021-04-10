package org.example.shapes;

import java.io.Serializable;
import javafx.scene.canvas.GraphicsContext;
import org.example.shapeOptions.Point;

// интерфейс для всех фигур
public interface Shape extends Serializable {

    boolean draw(GraphicsContext gc, Point point);

    void fill(GraphicsContext gc);

    void deleteLastPoint();

}
