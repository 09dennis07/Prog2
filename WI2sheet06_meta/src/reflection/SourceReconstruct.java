package reflection;

import java.lang.reflect.*;

/**
 * fragment for producing source code from a class by means
 * of the reflection API
 */
public class SourceReconstruct implements Comparable<SourceReconstruct> {
  
    private static void writeClassHeader(Class c) {
        
        String name = c.getName();
        System.out.println("Name der Klasse: " + name);
  
        int i = name.lastIndexOf(".");
        if (i > -1) { // extract package name
            System.out.println("package "+ name.substring(0,i) + ";");
            name = name.substring(i+1, name.length());
        }
        
        System.out.print(Modifier.toString(c.getModifiers()) + " ");
    
        System.out.print("class " + name + " ");
    
        Class superclass = c.getSuperclass();
        if (superclass != null)
            System.out.print("extends " + superclass.getName() + " ");
    
        Class[] interfaces = c.getInterfaces();
        if (interfaces.length != 0) {
            System.out.print("implements ");
            for (int j=0; ; j++) {
                System.out.print(interfaces[j].getName());
                if (j == (interfaces.length -1)) break;
                else System.out.print(", ");
            }
        } 
        System.out.println(); System.out.println();
    }
  
    public static void main(String[] args) {
        writeClassHeader((Double.valueOf(2.1)).getClass());
        writeClassHeader(java.lang.Class.class);
        writeClassHeader(reflection.SourceReconstruct.class);
        SampleClass sc = new SampleClass();
        writeClassHeader(sc.getClass());
//        // was liefern die folgenden "missbraeuchlichen" Verwendungen
        writeClassHeader(int.class);
        writeClassHeader(int[].class);
    }

    @Override
    public int compareTo(SourceReconstruct sourceReconstruct) {
        return 0;
    }
}