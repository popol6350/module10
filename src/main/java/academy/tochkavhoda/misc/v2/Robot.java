package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.Resizable;
import java.util.Objects;

public class Robot implements Movable, Resizable {
    private String name;
    private Point position;
    private int size;

    public Robot(String name, Point position, int size) {
        this.name = name;
        this.position = new Point(position.getX(), position.getY());
        this.size = size;
    }
    public Robot(String name) { this(name, new Point(0, 0), 10); }

    public String getName() { return name; }
    public Point getPosition() { return new Point(position.getX(), position.getY()); }
    public int getSize() { return size; }

    @Override public void moveTo(int x, int y) { position = new Point(x, y); }
    @Override public void moveRel(int dx, int dy) { position.moveRel(dx, dy); }
    @Override public void resize(double ratio) { size = (int)(size * ratio); }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot r = (Robot) o;
        return size == r.size && Objects.equals(name, r.name) && Objects.equals(position, r.position);
    }
    @Override public int hashCode() { return Objects.hash(name, position, size); }
}
