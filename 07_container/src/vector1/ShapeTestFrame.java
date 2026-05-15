package vector1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import vector1.shapes.*;

public class ShapeTestFrame extends Frame {

    public void paint(Graphics g) {
        Vector v = new Vector(3); // mit Kapazitaet 3
        v.setSize(3); // Groesse festlegen, vorher 0

        Circle c = new DrawableCircle(0, 0, 50);
        v.setElementAt(c, 0);
        v.setElementAt(new DrawableCircle(60, 50, 20), 1);
        v.setElementAt(new DrawableRectangle(100, 100, 80, 40), 2);

        // Abholen eines Elements
        Rectangle r = (Rectangle) v.elementAt(2);
        c = r.toCircle();

        // ein Element bei der Festlegung der Kapazitaet vergessen
        // macht nichts, Kapazitaet (gleich ziemlich) erhoehen!
        v.ensureCapacity(10);
        v.setSize(4);
        v.setElementAt(new DrawableRectangle(70, 70, 80, 40), 3);

        // Damit wird die Groesse des Vektors implizit um 1 erh?ht das neue
        // Element wird als 2. Komponente eingeschoben, die bisherige 2. wird 3.
        v.insertElementAt(new DrawableCircle(c), 2);

        // Doch keine weiteren Elemente mehr dazu, keinen Speicherplatz
        // vergeuden
        v.trimToSize();

        // Iterieren ueber den Inhalt des Containers
        for (int i = 0; i < v.size(); i++)
            ((Drawable) v.elementAt(i)).draw(g); // cast ist notwendig
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