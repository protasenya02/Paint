package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light.Point;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.example.factories.CircleFactory;
import org.example.factories.EllipseFactory;
import org.example.factories.PolygonFactory;
import org.example.factories.PolylineFactory;
import org.example.factories.RectangleFactory;
import org.example.factories.ShapeFactory;
import org.example.shapes.Shape;

public class PaintController {

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

    private ShapeFactory shapeFactory = new PolylineFactory();
    private final ShapeList shapeList = new ShapeList();
    private boolean isShapeDrawing = false;
    private GraphicsContext gc;
    private Shape shape;

    @FXML
    void initialize() { gc = canvas.getGraphicsContext2D();}

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

    public void btnClearClicked() {

        shapeList.clearCanvas(gc);
        shapeList.clear();
        isShapeDrawing = false;
    }

    @FXML
    void canvasMouseClicked(MouseEvent mouseEvent) {

            Point newPoint = new Point();
            newPoint.setX(mouseEvent.getX());
            newPoint.setY(mouseEvent.getY());

            // left
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                if (!isShapeDrawing) {

                    int width = Integer.parseInt(tfLineWidth.getText());
                    shape = shapeFactory.createShape(cpLineColor.getValue(), cbBorder.isSelected(),
                        cbFill.isSelected(), cpFillColor.getValue(), width);

                    shapeList.addShape(shape);

                }
                isShapeDrawing = shape.draw(gc, newPoint);

                // right
            } else {

                isShapeDrawing = false;

            }
    }


    @FXML
    void canvasMouseMoved(MouseEvent mouseEvent) {

        if (isShapeDrawing) {

            // clear canvas
            shapeList.clearCanvas(gc);

            // redraw  all shapes except the last one
            shapeList.drawPreview(gc);

            shape.deleteLastPoint();

            // add current point
            Point newPoint = new Point();
            newPoint.setX(mouseEvent.getX());
            newPoint.setY(mouseEvent.getY());

            shape.draw(gc, newPoint);
        }

    }

    @FXML
    void btnUndoClicked() { shapeList.undoShape(gc);}

    @FXML
    void btnRedoClicked() { shapeList.redoShape(gc);}

    @FXML
    void mainPainKeyPressed(KeyEvent keyEvent) {

        boolean isUndoClicked  = (keyEvent.isShortcutDown() && keyEvent.getCode() == KeyCode.Z);

        if (isUndoClicked) {

            if (keyEvent.isShiftDown()) {
                shapeList.redoShape(gc);
            } else {
                shapeList.undoShape(gc);
            }
        }
    }




}