package org.example;


import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.example.factories.CircleFactory;
import org.example.factories.EllipseFactory;
import org.example.factories.PolygonFactory;
import org.example.factories.PolylineFactory;
import org.example.factories.RectangleFactory;
import org.example.factories.ShapeFactory;
import org.example.shapeOptions.Color;
import org.example.shapeOptions.Point;
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

    public void btnEllipseClicked() { shapeFactory = new EllipseFactory(); }

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

            Point newPoint = new Point(mouseEvent.getX(), mouseEvent.getY());

            // left
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                if (!isShapeDrawing) {

                    int width = Integer.parseInt(tfLineWidth.getText());

                    Color lineColor = new Color(cpLineColor.getValue());
                    Color fillColor  = new Color(cpFillColor.getValue());

                    shape = shapeFactory.createShape(lineColor, cbBorder.isSelected(),
                        cbFill.isSelected(), fillColor, width);

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
            Point newPoint = new Point(mouseEvent.getX(), mouseEvent.getY());
            shape.draw(gc, newPoint);
        }

    }

    @FXML
    void btnUndoClicked() { shapeList.undoShape(gc);}

    @FXML
    void btnRedoClicked() { shapeList.redoShape(gc);}

    @FXML
    void menuSaveAsClicked() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Document");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary", "*.bin");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            shapeList.serializeShapeList(file.toString());
        }

    }


    @FXML
    void menuOpenClicked() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Document");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary", "*.bin");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {

            shapeList.deserializeShapeList(file.toString());
            shapeList.clearCanvas(gc);
            shapeList.drawAll(gc);

        }
    }

}




