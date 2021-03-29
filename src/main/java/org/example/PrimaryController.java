package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


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
    private ComboBox<String> cbShapes;
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

    private List<Double> pointsArr = new ArrayList<>();

    private List<Shape> shapeList = new ArrayList<>();

    @FXML
    void initialize() {

        GraphicsContext gc = canvas.getGraphicsContext2D();          // получение буфера канвы

        ObservableList<String> lineWidth = FXCollections
            .observableArrayList("1","2","3","5", "10", "15");
        // инициализация компонента толщины линии
        cbLineWidth.getItems().addAll(lineWidth);
        cbLineWidth.setValue("1");

        ObservableList<String> shapes = FXCollections
            .observableArrayList("Line", "Circle", "Triangle", "Rectangle");
        // инициализация компонента списка фигур
        cbShapes.getItems().addAll(shapes);
        cbShapes.setValue("Line");


        canvas.setOnMouseReleased( e -> {

            pointsArr.add(e.getX());
            pointsArr.add(e.getY());

            Double[] arr = new Double[pointsArr.size()];
            pointsArr.toArray(arr);
            double[] points = Stream.of(arr).mapToDouble(Double::doubleValue).toArray();
            int width = Integer.parseInt(cbLineWidth.getValue());

            Shape shape = shapeFactory.createShape(cpLineColor.getValue(), cbFill.isSelected(), cpFillColor.getValue(), width, points);
            shape.draw(gc);

            shapeList.add(shape);
            pointsArr.clear();

        });

        canvas.setOnMouseDragged( e -> {


        });

        // initial coordinates
        canvas.setOnMousePressed( e -> {

            pointsArr.add(e.getX());
            pointsArr.add(e.getY());

        });

    }

    public void btnLineClicked() {
        shapeFactory = new LineFactory();
    }


}