package vector1.shapes;

import java.awt.Graphics;
import java.awt.Color;

public class DrawableCircle extends Circle implements Drawable {
  public DrawableCircle(double x, double y, double r) {
    super(x,y,r);
  }
  public DrawableCircle(Circle c) {
    super(c);
  }

  public void setColor(Color c) { this.c=c; };
  public void draw(Graphics g) {
    g.setColor(c);      // ein anderes setColor(), setzt die aktuelle Farbe
                        // fÅr das nachfolgende Zeichnen
    g.drawArc((int)(getX()-radius()),(int)(getY()-radius()),
              2*(int)(radius()),2*(int)(radius()),0,360); };

  private Color c=Color.red;
}