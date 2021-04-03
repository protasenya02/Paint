package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Point;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class PrimaryController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Pane mainPain;
    @FXML
    private Canvas canvas;
    @FXML
    private Label lblShapes;
    @FXML
    private Label lblLineWidth;
    @FXML
    private ColorPicker cpLineColor;
    @FXML
    private ColorPicker cpFillColor;
    @FXML
    private CheckBox cbFill;
    @FXML
    private ComboBox<String> cbLineWidth;
    @FXML
    private Label lblLineColor;
    @FXML
    private Label lblFillColor;
    @FXML
    private Button btnLine;
    @FXML
    private Button btnRect;

    // объявление фабрики фигур
    private ShapeFactory shapeFactory = null;

    private ArrayList<Shape> shapeList = new ArrayList<>();
    private boolean shapeIsDrawing = false;
    private  GraphicsContext gc;

    @FXML
    void initialize() {

        gc = canvas.getGraphicsContext2D();          // получение буфера канвы

        ObservableList<String> lineWidth = FXCollections
            .observableArrayList("1","2","3","5", "10", "15");
        // инициализация компонента толщины линии
        cbLineWidth.getItems().addAll(lineWidth);
        cbLineWidth.setValue("1");


        canvas.setOnMouseMoved( e -> {



        });



    }

    public void btnLineClicked() { shapeFactory = new PolylineFactory(); }
    public void btnRectClicked() {
        shapeFactory = new RectangleFactory();
    }

    public void mouseClicked(MouseEvent e) {

        // left
        if (e.getButton() == MouseButton.PRIMARY) {

            Point location = MouseInfo.getPointerInfo().getLocation();


            if (!shapeIsDrawing) {

                shapeIsDrawing = true;
                Shape shape = shapeFactory.createShape(cpLineColor.getValue(), cbFill.isSelected(),
                    cpFillColor.getValue(), 5);
                shapeList.add(shape);
                shape.draw(gc, newPoint);

            } else {
                shapeList.get(shapeList.size()).draw(gc, newPoint);
            }
        };

    }

}