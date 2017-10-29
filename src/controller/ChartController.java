package controller;

import domain.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChartController {

    private final List<Point> listOfPoints;
    private double distance;

    public ChartController(final List<Point> listOfPoints) {
        this.listOfPoints = new ArrayList<>();
        this.listOfPoints.addAll(listOfPoints);
        Collections.shuffle(this.listOfPoints);
        this.distance = 0;
    }

    public List<Point> getPoints() {
        return this.listOfPoints;
    }

    public Point getPoint(final int index) {
        return this.listOfPoints.get(index);
    }

    public void setPoint(final Point point, final int index) {
        this.listOfPoints.add(index, point);
    }

}
