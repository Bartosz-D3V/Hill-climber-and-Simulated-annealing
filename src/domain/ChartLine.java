package domain;

import java.util.ArrayList;
import java.util.List;

public class ChartLine {

    private List<Point> points = new ArrayList<>();

    public ChartLine() {
    }

    public ChartLine(List<Point> points) {
        this.points = points;
    }

    public void addPoint(final Point point) {
        this.points.add(point);
    }

    public Point getPoint(final int index) {
        return this.points.get(index);
    }

    public int getSize() {
        return this.points.size();
    }
}
