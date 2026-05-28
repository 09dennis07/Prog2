package container5;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/** A simple stack implementation backed by a linked list of
 *  objects with enumeration of all elements.
 */
public class StackLinkedListImpl implements Stack {

    // eine geschachtelte Klasse
    static private class ListLinkElement  {   
        Object data;
        ListLinkElement next;
    
        ListLinkElement(Object data, ListLinkElement next) {
            this.data = data;
            this.next = next;
        }
    }
 
    // gekapselte Daten 
    private ListLinkElement h; // head of list which is top of stack
   
    // generated default constructor is sufficient
   
    public void push(Object c) { 
        h = new ListLinkElement(c, h);      
    }   
    
    public Object pop() throws StackEmptyException {      
        if (h == null)  
            throw new StackEmptyException("unable to pop");
 
        Object c = h.data;
        h = h.next;
        return c;
    }
      
    public Object top() throws StackEmptyException {
        if (h == null)
            throw new StackEmptyException("unable to pop");
             
        return h.data;      
    }
    
    public boolean empty() { 
        return (h==null); 
    }
    
    public String toString()  {
        String s = "content of circle stack \n";
        
        ListLinkElement lnk = h;
        while (lnk != null)   {
    	    s += lnk.data.toString() + "\n";
            lnk = lnk.next;
        }
        return s;    
    }
    
        public Enumeration elements()  {
        return new Enumerator();  
    }
    
    // Adapter class for producing enumerations
    private class Enumerator implements java.util.Enumeration {
        private ListLinkElement current = h;
        public boolean hasMoreElements() {
            return current != null;
        }
        public Object nextElement() {
           if (current == null)
               throw new NoSuchElementException("Stack already exhausted");
           
           Object returnValue = current.data;
           current = current.next;
           return returnValue;
        }
     }        
}