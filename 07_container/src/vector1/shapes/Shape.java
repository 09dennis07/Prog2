package vector1.shapes;

public abstract class Shape {

  public Shape(double x, double y) {
    this.x=x; this.y=y;
  }

  public Shape(Shape s) {
    x = s.x;
    y = s.y;
  };

  public void move(double x, double y) {
    this.x=x; this.y=y;
  }

  public abstract double circumference();
  public abstract double area();

  final double getX() { return x; }
  final double getY() { return y; }

  private double x,y;
}