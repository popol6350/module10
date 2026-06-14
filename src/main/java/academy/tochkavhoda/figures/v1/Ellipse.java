package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Ellipse {

    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = new Point(center.getX(), center.getY());
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xAxis, int yAxis) {
        this.center = new Point(0, 0);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse() {
        this(1, 1);
    }

    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void moveTo(int x, int y) {
        center = new Point(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        xAxis = (int)(xAxis * ratio);
        yAxis = (int)(yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis = (int)(xAxis * xRatio);
        yAxis = (int)(yAxis * yRatio);
    }

    public double getArea() {
        double a = xAxis / 2.0, b = yAxis / 2.0;
        return Math.PI * a * b;
    }

    /**
     * Approximation formula: P ≈ 2π * sqrt((a²+b²)/2), where a and b are semi-axes
     */
    public double getPerimeter() {
        double a = xAxis / 2.0, b = yAxis / 2.0;
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2.0);
    }

    public boolean isInside(int x, int y) {
        double a = xAxis / 2.0, b = yAxis / 2.0;
        double dx = (x - center.getX()) / a;
        double dy = (y - center.getY()) / b;
        return dx * dx + dy * dy <= 1.0;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis && yAxis == ellipse.yAxis
                && Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}
