package vector2;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import vector1.shapes.*;

public class ShapeTestFrame extends Frame {
    public void paint(Graphics g) {
        // mit Kapazitaet 3 and Kapazitaetszunahme 5
        Vector v = new Vector(3, 5);

        v.addElement(new DrawableCircle(0, 0, 50));
        v.addElement(new DrawableCircle(60, 50, 20));

        Rectangle r = new DrawableRectangle(100, 100, 80, 40);
        // falls nicht sicher, ob schon enthalten, besser abfragen
        if (!v.contains(r))
            v.addElement(r);

        // Kapazitaet hier erschoepft, wird beim naechsten add um 5 erhoeht
        v.addElement(new DrawableCircle(r.toCircle()));
        v.trimToSize(); // Kapazitaet soll gleich Groesse werden

        Enumeration e = v.elements();
        while (e.hasMoreElements())
            ((Drawable) e.nextElement()).draw(g);
    }

    public static void main(String[] args) {
        ShapeTestFrame frame = new ShapeTestFrame();
        frame.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                frame.dispose();    
            }    
        }); 
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}