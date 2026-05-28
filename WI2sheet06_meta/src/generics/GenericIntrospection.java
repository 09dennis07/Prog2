package generics;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class GenericIntrospection {
    public static void main(String[] args) {
        Class<?> clazz = SingleObjectHolder.class;
        System.out.println(clazz);
        System.out.println("Getting all type parameters: ");
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        for (int j = 0; j < typeVariables.length; j++)
            System.out.println(typeVariables[j]);
        try {
        	System.out.println("Return Type of Method get():");
            Method method = clazz.getDeclaredMethod("get");
            System.out.println(method.getGenericReturnType());
        	System.out.println("Parameter Type of Method put():");
            method = clazz.getDeclaredMethod("put", Object.class);
            System.out.println(method.getGenericParameterTypes()[0]);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
