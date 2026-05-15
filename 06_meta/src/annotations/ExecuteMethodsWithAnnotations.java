package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecuteMethodsWithAnnotations {
	public static void main(String[] args) {
		AnnotatedClass annotatedClass = new AnnotatedClass();
		Class clazz = annotatedClass.getClass();
		
		// check all methods for annotations
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
            ToBeExecuted toBeExecuted = method.getAnnotation(ToBeExecuted.class);
            if (toBeExecuted != null) {
            	if (method.getParameterCount() == 1) {
                	try {
    					method.invoke(annotatedClass, toBeExecuted.param());
    				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
    					e.printStackTrace();
    				} 
            	}
            	if (method.getParameterCount() == 0) {
                	try {
    					method.invoke(annotatedClass);
    				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
    					e.printStackTrace();
    				}             		
            	}

            }
		}
	}
}
