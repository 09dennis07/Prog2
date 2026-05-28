package reflection;

import java.lang.reflect.*;

class Tuer {
    public void doIt(int i) {
        System.out.println("Ich (" + this + ") tu' was mit der Zahl: "+i);
    }
}


public class InvokeTest {
  

    public static void main(String[] args) {
        try {
            Class cl = Class.forName("reflection.Tuer");
            System.out.println("got Class object: " + cl);
            
            
            Constructor c = cl.getDeclaredConstructor();
			Object obj = c.newInstance();
            System.out.println("got instance: " + obj);
            
      
            // doIt() with single int parameter
            Method method = cl.getDeclaredMethod("doIt", int.class);
            System.out.println("got Method object: " + method);
            
//            method.setAccessible(true);
            
            method.invoke(obj, 3);
            
            // call same method for another object
            method.invoke(new Tuer(), 6);
            
        } catch(ClassNotFoundException ex) {
            System.out.println(ex);
        } catch(InstantiationException ex) {
            System.out.println(ex);
        } catch(NoSuchMethodException ex) {
            System.out.println(ex);
        } catch(InvocationTargetException ex) {
            System.out.println(ex);       
        } catch(IllegalAccessException ex) {
            System.out.println(ex);
        }
    }
}
  