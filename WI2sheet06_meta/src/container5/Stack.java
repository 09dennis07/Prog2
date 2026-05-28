package container5;

import java.util.Enumeration;

/** 
 * Specification of a simple stack with enumeration of all elements
 */
public interface Stack { 
   
    void push(Object obj) throws StackOverflowException;
    
    Object pop() throws StackEmptyException;
      
    Object top() throws StackEmptyException;
    
    boolean empty();
    
    Enumeration<?> elements();
}
