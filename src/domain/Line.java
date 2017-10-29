package domain;

public class Line {

    private Point startPoint;
    private Point endPoint;
    private double distance;

    public Line() {
    }

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public double getDistance() {
        if (this.distance == 0) {
            this.distance = this.startPoint.distanceTo(this.endPoint);
        }
        return this.distance;
    }

    @Override
    public String toString() {
        return "Line{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", distance=" + distance +
                '}';
    }
}
