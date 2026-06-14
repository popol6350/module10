package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Stretchable;
import java.util.Objects;

public class Ellipse extends Figure implements Stretchable {

    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = new Point(center.getX(), center.getY()); this.xAxis = xAxis; this.yAxis = yAxis;
    }
    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter); this.xAxis = xAxis; this.yAxis = yAxis;
    }
    public Ellipse(int xAxis, int yAxis) { this.center = new Point(0,0); this.xAxis=xAxis; this.yAxis=yAxis; }
    public Ellipse() { this(1, 1); }

    public Point getCenter() { return new Point(center.getX(), center.getY()); }
    public int getXAxis() { return xAxis; }
    public int getYAxis() { return yAxis; }
    public void setCenter(Point p) { this.center = new Point(p.getX(), p.getY()); }
    public void setXAxis(int xAxis) { this.xAxis = xAxis; }
    public void setYAxis(int yAxis) { this.yAxis = yAxis; }

    @Override public void moveTo(int x, int y) { center = new Point(x, y); }
    @Override public void moveRel(int dx, int dy) { center.moveRel(dx, dy); }
    @Override public void resize(double ratio) { xAxis=(int)(xAxis*ratio); yAxis=(int)(yAxis*ratio); }
    @Override public void stretch(double xRatio, double yRatio) { xAxis=(int)(xAxis*xRatio); yAxis=(int)(yAxis*yRatio); }
    @Override public double getArea() { return Math.PI * (xAxis/2.0) * (yAxis/2.0); }
    @Override public double getPerimeter() {
        double a=xAxis/2.0, b=yAxis/2.0;
        return 2*Math.PI*Math.sqrt((a*a+b*b)/2.0);
    }
    @Override public boolean isInside(int x, int y) {
        double a=xAxis/2.0, b=yAxis/2.0;
        double dx=(x-center.getX())/a, dy=(y-center.getY())/b;
        return dx*dx+dy*dy<=1.0;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null||getClass()!=o.getClass()) return false;
        Ellipse e=(Ellipse)o;
        return xAxis==e.xAxis&&yAxis==e.yAxis&&Objects.equals(center,e.center);
    }
    @Override public int hashCode() { return Objects.hash(center, xAxis, yAxis); }
}
