package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Stretchable;
import java.util.Objects;

public class Rectangle extends Figure implements Stretchable {

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
    public Rectangle() { this(1, 1); }

    public Point getTopLeft() { return new Point(topLeft.getX(), topLeft.getY()); }
    public Point getBottomRight() { return new Point(bottomRight.getX(), bottomRight.getY()); }
    public void setTopLeft(Point p) { this.topLeft = new Point(p.getX(), p.getY()); }
    public void setBottomRight(Point p) { this.bottomRight = new Point(p.getX(), p.getY()); }
    public int getLength() { return bottomRight.getX() - topLeft.getX(); }
    public int getWidth() { return bottomRight.getY() - topLeft.getY(); }

    @Override public void moveTo(int x, int y) {
        int l = getLength(), w = getWidth();
        topLeft = new Point(x, y);
        bottomRight = new Point(x + l, y + w);
    }
    @Override public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy); bottomRight.moveRel(dx, dy);
    }
    @Override public void resize(double ratio) {
        bottomRight = new Point(topLeft.getX() + (int)(getLength()*ratio),
                                topLeft.getY() + (int)(getWidth()*ratio));
    }
    @Override public void stretch(double xRatio, double yRatio) {
        bottomRight = new Point(topLeft.getX() + (int)(getLength()*xRatio),
                                topLeft.getY() + (int)(getWidth()*yRatio));
    }
    @Override public double getArea() { return (double)getLength() * getWidth(); }
    @Override public double getPerimeter() { return 2.0 * (getLength() + getWidth()); }
    @Override public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX()
            && y >= topLeft.getY() && y <= bottomRight.getY();
    }
    public boolean isIntersects(Rectangle r) {
        return !(r.bottomRight.getX() < topLeft.getX()
              || r.topLeft.getX() > bottomRight.getX()
              || r.bottomRight.getY() < topLeft.getY()
              || r.topLeft.getY() > bottomRight.getY());
    }
    public boolean isInside(Rectangle r) {
        return isInside(r.topLeft) && isInside(r.bottomRight);
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle r = (Rectangle) o;
        return Objects.equals(topLeft, r.topLeft) && Objects.equals(bottomRight, r.bottomRight);
    }
    @Override public int hashCode() { return Objects.hash(topLeft, bottomRight); }
}
