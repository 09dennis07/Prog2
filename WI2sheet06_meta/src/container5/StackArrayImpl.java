package container5;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/** A simple stack implementation backed by an array of fixed size,
 *  which can hold objects.
 */
public class StackArrayImpl implements Stack { 
    public static final int DEFAULT_SIZE = 5;
    private Object[] objects;   
    private int h; // height and index of first free component
   
    public StackArrayImpl(int cap) { 
        objects = new Object[cap]; 
    }
    
    public StackArrayImpl() { 
        this(DEFAULT_SIZE); 
    }
    
   
    public void push(Object obj) throws StackOverflowException {       
        if (h == objects.length ) 
            throw new StackOverflowException(
                "Stack with fixed size " + objects.length);
        objects[h++] = obj;
    }   
    
    public Object pop() throws StackEmptyException {      
        if (h == 0) 
            throw new StackEmptyException("unable to pop");
        return objects[--h];
    }
      
    public Object top() throws StackEmptyException {
        if (h == 0) 
            throw new StackEmptyException("unable to top");
        return objects[h - 1];      
    }
    
    public boolean empty() { 
        return (h==0); 
    }
    
    public String toString()  {
        String s = "content of stack \n";
        for (int i=0; i < h; i++)
    	    s += i + "-te Komponente: " + objects[i] + "\n";
        return s;    
    }
    
    // 1. Version: Enumerator as member class
//    public Enumeration elements()  {
//        return new Enumerator();  
//    }
//    
//    // Adapter class for producing enumerations
//    private class Enumerator implements java.util.Enumeration {
//        private int index = h;
//        public boolean hasMoreElements() {
//            return index > 0;
//        }
//        public Object nextElement() {
//           if (index == 0)
//               throw new NoSuchElementException("ArrayStack already exhausted");
//           return objects[--index];
//        }
//     } 
 
    
    // 2. Version: Enumerator as local class
//    public Enumeration elements()  {
//    
//        // local class for producing enumerations
//        class Enumerator implements Enumeration {        
//            int index = h;
//            public boolean hasMoreElements() {
//                return index > 0;
//            }
//            public Object nextElement() {
//                if (index == 0)
//                    throw new NoSuchElementException("ArrayStack already exhausted");
//                return objects[--index];
//            }
//         } 
//         
//         return new Enumerator();  
//    } 
    
    // 3. Version: Enumerator as anonymous class
    public Enumeration elements()  {
    
        // produce anonymous class on the fly for enumeration
        return new Enumeration() {        
            int index = h;
            public boolean hasMoreElements() {
                return index > 0;
            }
            public Object nextElement() {
                if (index == 0)
                    throw new NoSuchElementException("ArrayStack already exhausted");
                return objects[--index];
            }
         };     
    } 
    
}
