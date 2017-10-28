package domain;

public class Point {

    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * sqrt( (X2-X1)^2 + (Y2-Y1)2 )
     *
     * @return
     */
    public double distanceTo(Point destPoint) {
        if (destPoint == null) {
            return 0;
        }
        final double powerOf2DistanceXAxis = Math.pow(this.pointX - destPoint.pointX, 2);
        final double powerOf2DistanceYAxis = Math.pow(this.pointY - destPoint.pointY, 2);

        return Math.sqrt(powerOf2DistanceXAxis + powerOf2DistanceYAxis);
    }
}
