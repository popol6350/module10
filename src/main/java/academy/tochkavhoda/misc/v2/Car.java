package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;
import java.util.Objects;

public class Car implements Movable, Colored {
    private String model;
    private Point position;
    private int color;

    public Car(String model, Point position, int color) {
        this.model = model;
        this.position = new Point(position.getX(), position.getY());
        this.color = color;
    }
    public Car(String model) { this(model, new Point(0, 0), 1); }

    public String getModel() { return model; }
    public Point getPosition() { return new Point(position.getX(), position.getY()); }

    @Override public void moveTo(int x, int y) { position = new Point(x, y); }
    @Override public void moveRel(int dx, int dy) { position.moveRel(dx, dy); }
    @Override public int getColor() { return color; }
    @Override public void setColor(int color) { this.color = color; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return color == car.color && Objects.equals(model, car.model) && Objects.equals(position, car.position);
    }
    @Override public int hashCode() { return Objects.hash(model, position, color); }
}
