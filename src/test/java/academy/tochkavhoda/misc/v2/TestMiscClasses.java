package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.Resizable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMiscClasses {

    @Test
    public void testCar() {
        Car car = new Car("Tesla", new Point(10, 20), 3);
        assertEquals("Tesla", car.getModel());
        assertEquals(10, car.getPosition().getX());
        assertEquals(20, car.getPosition().getY());
        assertEquals(3, car.getColor());
        car.moveRel(5, 5);
        assertEquals(15, car.getPosition().getX());
        car.moveTo(100, 200);
        assertEquals(100, car.getPosition().getX());
        car.moveTo(new Point(0, 0));
        assertEquals(0, car.getPosition().getX());
        car.setColor(7);
        assertEquals(7, car.getColor());
        assertTrue(car instanceof Movable);
        assertTrue(car instanceof Colored);
        Car car2 = new Car("Tesla", new Point(0, 0), 7);
        assertEquals(car, car2);
    }

    @Test
    public void testRobot() {
        Robot robot = new Robot("R2D2", new Point(0, 0), 50);
        assertEquals("R2D2", robot.getName());
        assertEquals(50, robot.getSize());
        robot.resize(2);
        assertEquals(100, robot.getSize());
        robot.moveRel(10, 10);
        assertEquals(10, robot.getPosition().getX());
        robot.moveTo(new Point(5, 5));
        assertEquals(5, robot.getPosition().getX());
        assertTrue(robot instanceof Movable);
        assertTrue(robot instanceof Resizable);
    }

    @Test
    public void testBalloon() {
        Balloon b = new Balloon(new Point(0, 0), 10, 2);
        assertEquals(10, b.getRadius());
        assertEquals(2, b.getColor());
        b.resize(3);
        assertEquals(30, b.getRadius());
        b.moveRel(5, 5);
        assertEquals(5, b.getPosition().getX());
        b.moveTo(new Point(1, 1));
        assertEquals(1, b.getPosition().getX());
        b.setColor(5);
        assertEquals(5, b.getColor());
        assertTrue(b instanceof Movable);
        assertTrue(b instanceof Resizable);
        assertTrue(b instanceof Colored);
        Balloon b2 = new Balloon(new Point(1, 1), 30, 5);
        assertEquals(b, b2);
    }
}
