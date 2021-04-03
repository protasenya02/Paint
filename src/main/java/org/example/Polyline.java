package org.example;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// класс ломанной линии
public class Polyline implements Shape {

    private final Color lineColor;
    private final int lineWidth;
    private ArrayList<Point> points;
    boolean firstDrawCall = true;

    public Polyline(Color lineColor, boolean isFill, Color fillColor, int lineWidth) {
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
    };

    @Override
    public void draw(GraphicsContext gc, Point point) {

        if(!firstDrawCall) {
            Point lastPoint = points.get(points.size()-1);
            gc.strokeLine(lastPoint.getX(),lastPoint.getY(),point.getX(),point.getY());
        }

        points.add(point);
        firstDrawCall = false;
    };

    @Override
    public void draw(GraphicsContext gc) {

        if(points.size() > 1) {

            for (int i = 1; i < points.size(); i++) {

                gc.strokeLine(points.get(i - 1).getX(), points.get(i - 1).getY(),
                                     points.get(i).getX(), points.get(i).getY());

            }
        }
    };
}
