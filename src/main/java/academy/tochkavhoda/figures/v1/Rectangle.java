package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.bottomRight = new Point(rightBottom.getX(), rightBottom.getY());
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        this.topLeft = new Point(0, -width);
        this.bottomRight = new Point(length, 0);
    }

    public Rectangle() {
        this(1, 1);
    }

    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    public Point getBottomRight() {
        return new Point(bottomRight.getX(), bottomRight.getY());
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = new Point(bottomRight.getX(), bottomRight.getY());
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        topLeft = new Point(x, y);
        bottomRight = new Point(x + length, y + width);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int newLength = (int)(getLength() * ratio);
        int newWidth = (int)(getWidth() * ratio);
        bottomRight = new Point(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    public void stretch(double xRatio, double yRatio) {
        int newLength = (int)(getLength() * xRatio);
        int newWidth = (int)(getWidth() * yRatio);
        bottomRight = new Point(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    public double getArea() {
        return (double) getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2.0 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX()
                && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return !(rectangle.bottomRight.getX() < topLeft.getX()
                || rectangle.topLeft.getX() > bottomRight.getX()
                || rectangle.bottomRight.getY() < topLeft.getY()
                || rectangle.topLeft.getY() > bottomRight.getY());
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.topLeft) && isInside(rectangle.bottomRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
