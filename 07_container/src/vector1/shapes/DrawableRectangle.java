package vector1.shapes;

import java.awt.Graphics;
import java.awt.Color;

/** Rechtecke, die graphisch dargestellt werden koennen.
 *  Dazu ist natuerlich ein Graphik-Kontext erforderlich
 *  @see shapes.DrawableCircle
 *  @version 1.0 beta 29. 2. 97
 *  @author Erwin Softwareklau
 */
public class DrawableRectangle extends Rectangle implements Drawable {
  public DrawableRectangle(double x, double y, double w, double h) {
    super(x,y,w,h);
  }
  public void setColor(Color c) { this.c=c; };

  /** Bringt das Rechteck auf den Bildschirm.
   *  @see shapes.Drawable#draw
   *  @param g dorthin wird gezeichnet
   *  @return Es wird nur ausgegeben, nichts zurueckgegeben
   */
  public void draw(Graphics g) {
    g.setColor(c);
    g.drawRect((int) getX(),(int) getY(),
               (int) width(), (int) height()); };

  private Color c=defaultColor;
}