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
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Currently the best found solution ")
                .append("is the line with the following points:")
                .append(System.lineSeparator())
                .append("Start point:")
                .append(System.lineSeparator())
                .append(this.startPoint.toString())
                .append(System.lineSeparator())
                .append("End point:")
                .append(System.lineSeparator())
                .append(this.endPoint.toString())
                .append(System.lineSeparator())
                .append("Total distance between points:")
                .append(this.distance);

        return stringBuilder.toString();
    }
}
