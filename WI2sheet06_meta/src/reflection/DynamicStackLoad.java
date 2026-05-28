package reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import container5.*;

public class DynamicStackLoad { 

    public static void main(String[] args) { 
    
        String className = null;
        Class<?> stackClass = null;
        Stack stackInstance = null;
    
        System.out.println("Which stack implementation do You want to use today?");
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            className = reader.readLine();
        } catch(IOException ex)  {
            System.out.println("Can't read from Stdin: " + ex);
            return;
        }
         
        try  {
            System.out.println("--> load " + className);
            stackClass = Class.forName(className);

            System.out.println("--> instantiate " + stackClass);
            try {
            	Constructor<?> constructor = stackClass.getDeclaredConstructor();

                for (Constructor<?> ctor : stackClass.getConstructors()) {
                    System.out.println("--> " + ctor);
                }

				stackInstance = (Stack) constructor.newInstance();
			} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        } catch(ClassNotFoundException ex)  {
            System.out.println(ex);
            return;
        } catch(InstantiationException ex)  {
            System.out.println(ex);
            return;
        } catch(IllegalAccessException ex)  {
            System.out.println(ex);
            return;
        }
        
        System.out.println("--> call stackTest for instance ");
        StackUsage.stackTest(stackInstance);
                       
    }
}