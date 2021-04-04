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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


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
    private ArrayList<Point> points = new ArrayList<>();
    private boolean isShapeDrawing = false;
    private GraphicsContext gc;

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
                    Shape shape = shapeFactory.createShape(cpLineColor.getValue(), cbBorder.isSelected(),
                        cbFill.isSelected(), cpFillColor.getValue(), width);
                    shapeList.add(shape);
                    isShapeDrawing = shape.draw(gc,newPoint);
                    points.add(newPoint);

                } else {

                    points.add(newPoint);
                    isShapeDrawing = shapeList.get(shapeList.size() - 1).draw(gc, newPoint);

                    if (!isShapeDrawing) {
                        points.clear();
                    }
                }

            // right
            } else {

                isShapeDrawing = false;
                points.clear();

            }
        });


        canvas.setOnMouseMoved( e -> {

            if ( isShapeDrawing ) {

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                for (int i = 0; i < shapeList.size() - 1; i++) {
                    shapeList.get(i).draw(gc);
                }

                shapeList.remove(shapeList.size() - 1);

                int width = Integer.parseInt(tfLineWidth.getText());
                Shape shape = shapeFactory.createShape(cpLineColor.getValue(), cbBorder.isSelected(),
                    cbFill.isSelected(), cpFillColor.getValue(), width);

                Point newPoint = new Point();
                newPoint.setX(e.getX());
                newPoint.setY(e.getY());

                points.add(newPoint);
                for (Point point : points) {
                    shape.draw(gc, point);
                }
                shapeList.add(shape);
                points.remove(points.size() - 1);
            }
        });

    }

    public void btnLineClicked() {

        shapeFactory = new PolylineFactory();
        cbBorder.setSelected(false);
        cbFill.setSelected(false);
    }

    public void btnRectClicked() {

      shapeFactory = new RectangleFactory();
      cbBorder.setSelected(false);
      cbFill.setSelected(false);

    }

    public void btnCircleClicked() {

      shapeFactory = new CircleFactory();
      cbBorder.setSelected(false);
      cbFill.setSelected(false);

    }

    public void btnEllipseClicked() {

      shapeFactory = new EllipseFactory();
      cbBorder.setSelected(false);
      cbFill.setSelected(false);

    }

    public void btnPolygonClicked() {

      shapeFactory = new PolygonFactory();
      cbBorder.setSelected(true);
      cbFill.setSelected(true);

    }

    public void btnClearCliсked() {

       gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
       shapeList.clear();

    }



}