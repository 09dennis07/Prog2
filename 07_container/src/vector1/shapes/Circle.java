package vector1.shapes;
public class Circle extends Shape{

  public Circle(double x, double y, double r) {
    super(x,y); this.r=r;
  }
  public Circle(Circle c) {
    super(c); r = c.r;
  };

  public double circumference() { return 2*PI*r; };
  public double area() { return PI*r*r; };

  static final double PI=3.14159;

  final double radius() { return r; };

  private double r;
}