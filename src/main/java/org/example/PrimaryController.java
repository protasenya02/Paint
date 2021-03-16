package org.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    void initialize() {

        GraphicsContext gc = canvas.getGraphicsContext2D();          // получение буфера канвы
        // отрисовка фигур
        drawCutLine(gc);
        drawRect(gc);
        drawOval(gc);
        drawPoligon(gc);
        drawArc(gc);
        // инициализация компонента списка фигур
        cbShapes.getItems().addAll("Line", "Circle", "Triangle", "Rectangle", "Star");
        cbShapes.setValue("Line");
        // инициализация компонента толщины линии
        cbLineWidth.getItems().addAll("1px", "5px", "10px", "15px");
        cbLineWidth.setValue("1px");
    }

    private  void  drawCutLine(GraphicsContext gc){
        gc.setStroke(Color.rgb(0, 102, 255));
        gc.setLineWidth(5);
        gc.strokeLine(100, 80, 300, 80);            // отрисовка отрезка
    }

    private void drawRect(GraphicsContext gc){
        gc.setFill(Color.rgb(255, 153, 255));
        gc.fillRect(100,100, 200, 130);             // отрисовка прямоугольника
    }

    private void drawOval(GraphicsContext gc){
        gc.setFill(Color.rgb(7, 248, 220));
        gc.fillOval(120, 300, 150, 90);             // отрисовка овала
    }

    private void drawPoligon(GraphicsContext gc){
        gc.setFill(Color.rgb(109, 29, 255));
        gc.fillPolygon(new double[]{360, 400, 360, 400},            // отрисовка полигона
                new double[]{110, 110, 170, 170}, 4);
    }

    private void drawArc(GraphicsContext gc){
        gc.setFill(Color.rgb(255, 102, 102));
        gc.fillArc(360, 300, 100, 100, 45, 240, ArcType.ROUND);     // отрисовка дуги
    }

}