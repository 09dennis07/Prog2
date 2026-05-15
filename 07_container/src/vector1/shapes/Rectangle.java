package vector1.shapes;
import java.lang.Math;

public class Rectangle extends Shape{

  public Rectangle(double x, double y, double w, double h) {
    super(x,y); this.w=w; this.h = h;
  }

  public double circumference() { return 2*(w+h); };
  public double area() { return w*h; };

  /** wandelt das Rechteck in einen Kreis mit gleicher Fl„che um */
  public Circle toCircle() {
    return new Circle(getX() + w/2, getY() + h/2, Math.sqrt(w*h/Circle.PI));
  }

  final double width() { return w; }
  final double height() { return h; }

  private double w,h;
}