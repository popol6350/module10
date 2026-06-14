package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.Resizable;
import java.util.Objects;

public class Balloon implements Movable, Resizable, Colored {
    private Point position;
    private int radius;
    private int color;

    public Balloon(Point position, int radius, int color) {
        this.position = new Point(position.getX(), position.getY());
        this.radius = radius;
        this.color = color;
    }
    public Balloon(int radius, int color) { this(new Point(0,0), radius, color); }

    public Point getPosition() { return new Point(position.getX(), position.getY()); }
    public int getRadius() { return radius; }

    @Override public void moveTo(int x, int y) { position = new Point(x, y); }
    @Override public void moveRel(int dx, int dy) { position.moveRel(dx, dy); }
    @Override public void resize(double ratio) { radius = (int)(radius * ratio); }
    @Override public int getColor() { return color; }
    @Override public void setColor(int color) { this.color = color; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balloon b = (Balloon) o;
        return radius == b.radius && color == b.color && Objects.equals(position, b.position);
    }
    @Override public int hashCode() { return Objects.hash(position, radius, color); }
}
