package org.example;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light.Point;
import javafx.scene.input.MouseButton;


public class PrimaryController {

    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker cpLineColor;
    @FXML
    private ColorPicker cpFillColor;
    @FXML
    private CheckBox cbFill;
    @FXML
    private CheckBox cbBorder;
    @FXML
    private TextField tfLineWidth;

    private ShapeFactory shapeFactory = null;
    private ArrayList<Shape> shapeList = new ArrayList<>();
    private boolean isShapeDrawing = false;
    private GraphicsContext gc;
    private  Shape shape;

    @FXML
    void initialize() {

        gc = canvas.getGraphicsContext2D();
        shapeFactory = new PolylineFactory();

        canvas.setOnMouseClicked( e -> {

            Point newPoint = new Point();
            newPoint.setX(e.getX());
            newPoint.setY(e.getY());

            // left
            if (e.getButton() == MouseButton.PRIMARY) {

                if (!isShapeDrawing) {

                    int width = Integer.parseInt(tfLineWidth.getText());
                    shape = shapeFactory.createShape(cpLineColor.getValue(), cbBorder.isSelected(),
                        cbFill.isSelected(), cpFillColor.getValue(), width);
                    shapeList.add(shape);
                    isShapeDrawing = shape.draw(gc,newPoint);

                } else {

                    isShapeDrawing = shape.draw(gc,newPoint);

                }

            // right
            } else {

                isShapeDrawing = false;

            }
        });

        canvas.setOnMouseMoved( e -> {

            if ( isShapeDrawing ) {

                // clear canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                // redraw  all shapes except the last one
                for (int i = 0; i < shapeList.size() - 1; i++) {
                    shapeList.get(i).fill(gc);
                }

                shape.deleteLastPoint();
                
                // add current point
                Point newPoint = new Point();
                newPoint.setX(e.getX());
                newPoint.setY(e.getY());
                shape.draw(gc, newPoint);
            }
        });
    }

    public void btnLineClicked() {

        shapeFactory = new PolylineFactory();

    }

    public void btnRectClicked() {

      shapeFactory = new RectangleFactory();

    }

    public void btnCircleClicked() {

      shapeFactory = new CircleFactory();

    }

    public void btnEllipseClicked() {

      shapeFactory = new EllipseFactory();

    }

    public void btnPolygonClicked() {

      shapeFactory = new PolygonFactory();
    }

    public void btnClearCliсked() {

       gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
       shapeList.clear();
       isShapeDrawing = false;

    }


}