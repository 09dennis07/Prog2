package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsAnalyzer {

    public static void main(String[] args) {
        Class clazz=null;
        try {
            clazz = Class.forName("annotations.AnnotatedClass");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("class: " +  clazz.getName());
        Annotation[] classAnnotations = clazz.getAnnotations();
        for (int i = 0; i < classAnnotations.length; i++) {
            System.out.println("Class Annotation: " + classAnnotations[i]);
        }
        
        System.out.println("Displaying annotations for all methods in class (if any):");
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Annotation[] methodAnnotations = methods[i].getAnnotations();
            System.out.println(" method: " + methods[i].getName());
            for (int j = 0; j < methodAnnotations.length; j++) {
                System.out.println("  annotation:" + methodAnnotations[j]);
//                System.out.println("   annotationType:" + methodAnnotations[j].annotationType());
//                System.out.println("   annotation class:" + methodAnnotations[j].getClass());  
            }
            
            ToDo toDo = methods[i].getAnnotation(ToDo.class);
            if (toDo != null) {
                System.out.println("    what: " + toDo.what());
                System.out.println("    count: " + toDo.count());
            }
        }
        
    }
}
