package academy.tochkavhoda.figures.v2;

import java.util.Objects;

public class Square extends Figure {

    private Point topLeft;
    private int size;

    public Square(Point leftTop, int size) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY()); this.size = size;
    }
    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop); this.size = size;
    }
    public Square(int size) { this.topLeft = new Point(0, -size); this.size = size; }
    public Square() { this(1); }

    public Point getTopLeft() { return new Point(topLeft.getX(), topLeft.getY()); }
    public Point getBottomRight() { return new Point(topLeft.getX()+size, topLeft.getY()+size); }
    public void setTopLeft(Point p) { this.topLeft = new Point(p.getX(), p.getY()); }
    public int getLength() { return size; }

    @Override public void moveTo(int x, int y) { topLeft = new Point(x, y); }
    @Override public void moveRel(int dx, int dy) { topLeft.moveRel(dx, dy); }
    @Override public void resize(double ratio) { size = (int)(size * ratio); }
    @Override public double getArea() { return (double)size * size; }
    @Override public double getPerimeter() { return 4.0 * size; }
    @Override public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= topLeft.getX()+size
            && y >= topLeft.getY() && y <= topLeft.getY()+size;
    }
    public boolean isIntersects(Square sq) {
        int r1x1=topLeft.getX(), r1y1=topLeft.getY(), r1x2=r1x1+size, r1y2=r1y1+size;
        int r2x1=sq.topLeft.getX(), r2y1=sq.topLeft.getY(), r2x2=r2x1+sq.size, r2y2=r2y1+sq.size;
        return !(r2x2<r1x1||r2x1>r1x2||r2y2<r1y1||r2y1>r1y2);
    }
    public boolean isInside(Square sq) { return isInside(sq.topLeft) && isInside(sq.getBottomRight()); }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square sq = (Square) o;
        return size == sq.size && Objects.equals(topLeft, sq.topLeft);
    }
    @Override public int hashCode() { return Objects.hash(topLeft, size); }
}
