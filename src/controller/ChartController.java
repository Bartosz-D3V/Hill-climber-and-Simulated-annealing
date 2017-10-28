package controller;

import domain.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChartController {

    private final List<Point> listOfPoints;
    private double distance;

    public ChartController(List<Point> listOfPoints) {
        this.listOfPoints = new ArrayList<>();
        this.listOfPoints.addAll(listOfPoints);
        Collections.shuffle(this.listOfPoints);
        this.distance = 0;
    }

    public Point getPoint(final int index) {
        return this.listOfPoints.get(index);
    }

    public void setPoint(final Point point, final int index) {
        this.listOfPoints.add(index, point);
    }

    public double getDistance() {
        if (this.distance == 0) {
            double tempDist = 0;
            for (Point point : this.listOfPoints) {
                final Point destPoint;

                if (this.listOfPoints.indexOf(point) + 1 < this.listOfPoints.size()) {
                    destPoint = this.listOfPoints.get(this.listOfPoints.indexOf(point) + 1);
                } else {
                    destPoint = this.listOfPoints.get(0);
                }
                tempDist = point.distanceTo(destPoint);
            }
            this.distance = tempDist;
        }
        return this.distance;
    }


}
