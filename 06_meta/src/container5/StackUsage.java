package container5;

import java.util.Enumeration;

public class StackUsage { 

    /**
      * applies method calls specified for a stack;
      * does not mind which stack implementation is used
      */
    public static void stackTest(Stack stack) { 
        try  {
            stack.push(Integer.valueOf(7));
            stack.push(Integer.valueOf(8));  
            stack.push(Integer.valueOf(10));          
        } catch(StackOverflowException e)  {
            e.printStackTrace();
        } 
        
        System.out.println("Elements on stack:");
        Enumeration enumeration = stack.elements();
        while (enumeration.hasMoreElements())
            System.out.println(" >" + enumeration.nextElement());
    }
    

    public static void main(String[] args) { 
    
        System.out.println("--> test StackArrayImpl");
        stackTest(new StackArrayImpl(5));
        
        System.out.println();
        System.out.println("--> test StackLinkedListImpl"); 
        stackTest(new StackLinkedListImpl());
               
    }
}