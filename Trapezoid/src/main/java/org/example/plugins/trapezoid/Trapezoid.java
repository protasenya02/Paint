package org.example.plugins.trapezoid;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import org.example.core.Color;
import org.example.core.Point;
import org.example.core.Shape;

public class Trapezoid implements Shape {
  private final Color lineColor;
  private final boolean isLine;
  private final boolean isFill;
  private final Color fillColor;
  private final int lineWidth;
  private final ArrayList<Point> pointsArr = new ArrayList<>();

  public Trapezoid(Color lineColor, boolean isLine, boolean isFill, Color fillColor, int lineWidth) {

    this.lineColor = lineColor;
    this.isLine = isLine;
    this.isFill = isFill;
    this.fillColor = fillColor;
    this.lineWidth = lineWidth;
  }

  @Override
  public boolean draw(GraphicsContext gc, Point point) {

    if (pointsArr.size() <= 2) {
      pointsArr.add(point);
      fill(gc);
      return true;
    }

      return false;
  }

  @Override
  public void fill(GraphicsContext gc) {

    gc.setStroke(lineColor.getPaintColor());
    gc.setLineWidth(lineWidth);
    gc.setFill(fillColor.getPaintColor());
    gc.setLineCap(StrokeLineCap.ROUND);
    gc.setLineJoin(StrokeLineJoin.ROUND);

    if (pointsArr.size() == 3) {

      Point point1 = new Point(0,0);
      point1.setY(pointsArr.get(1).getY());
      point1.setX(pointsArr.get(2).getX());

      Point point2 = new Point(0,0);
      point2.setY(pointsArr.get(0).getY());
      point2.setX(pointsArr.get(2).getX() + (pointsArr.get(1).getX()- pointsArr.get(0).getX()));

      ArrayList<Point> pointsArr2 = new ArrayList<>();
      pointsArr2.add(pointsArr.get(0));
      pointsArr2.add(pointsArr.get(1));
      pointsArr2.add(point1);
      pointsArr2.add(point2);

      int nPoints = pointsArr2.size();
      double[] xPoints = new double[nPoints];
      double[] yPoints = new double[nPoints];

      for (int i = 0; i < pointsArr2.size(); i++) {
        xPoints[i] = pointsArr2.get(i).getX();
        yPoints[i] = pointsArr2.get(i).getY();
      }

      if (isFill) {
        gc.fillPolygon(xPoints, yPoints, nPoints);

        if (isLine) {
          gc.strokePolygon(xPoints, yPoints, nPoints);
        }

      } else {
        gc.strokePolygon(xPoints, yPoints, nPoints);
      }
    }

    if (pointsArr.size() == 2) {

      int nPoints = pointsArr.size();
      double[] xPoints = new double[nPoints];
      double[] yPoints = new double[nPoints];

      for (int i = 0; i < pointsArr.size(); i++) {
        xPoints[i] = pointsArr.get(i).getX();
        yPoints[i] = pointsArr.get(i).getY();
      }
      gc.strokePolygon(xPoints, yPoints, nPoints);
    }
  }

  @Override
  public void deleteLastPoint() {

    if (pointsArr.size() > 1) {
      pointsArr.remove(pointsArr.size() - 1);
    }
  }
};
