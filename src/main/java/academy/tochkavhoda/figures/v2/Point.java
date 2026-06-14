package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Movable;
import java.util.Objects;

public class Point implements Movable {
    private int x;
    private int y;

    public Point(int x, int y) { this.x = x; this.y = y; }
    public Point() { this(0, 0); }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    @Override public void moveTo(int x, int y) { this.x = x; this.y = y; }
    @Override public void moveRel(int dx, int dy) { x += dx; y += dy; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
    @Override public int hashCode() { return Objects.hash(x, y); }
}
