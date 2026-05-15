package vector1.shapes;

import java.awt.Graphics;
import java.awt.Color;
public interface Drawable {
  Color defaultColor=Color.blue;
  void setColor(Color c);
  void draw(Graphics g);
}