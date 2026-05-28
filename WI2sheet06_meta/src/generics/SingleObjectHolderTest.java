package generics;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class SingleObjectHolderTest {
    public static void main(String[] args) {
        // testing the implementation
        SingleObjectHolder<String> stringHolder = new SingleObjectHolder<String>();
        stringHolder.put("Hallo");
        String s = stringHolder.get();
        System.out.println("got: " + s);
        
        SingleObjectHolder<Integer> intHolder = new SingleObjectHolder<Integer>();
        intHolder.put(5);
        int i = intHolder.get();
        System.out.println("got: " + i);
        
        SingleObjectHolder<char[]> charArrayHolder = new SingleObjectHolder<char[]>();
        charArrayHolder.put(new char[]{'a','b','c'});
        char [] ca = charArrayHolder.get();
        System.out.println("got: " + ca);
        System.out.println("got: " + Arrays.toString(ca));
        
        SingleObjectHolder<Integer> integerHolder = new SingleObjectHolder<Integer>();
        SingleObjectHolder rawTypeHolder = integerHolder;  // warning SingleObjectHolder is a raw type
        integerHolder = rawTypeHolder;                     // warning: ... needs unchecked conversion ....
        @SuppressWarnings("unused")
		SingleObjectHolder<?> unboundedWildcardHolder = integerHolder; // no warning
        //integerHolder = unboundedWildcardHolder;                       // error
        
        SingleObjectHolder<String> h = new SingleObjectHolder<String>();
        h.put("Hallo");
        String si = h.get();
        System.out.println("got: " + si);
        
        Class<?> clazz = SingleObjectHolder.class;
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        for (int j=0; j<typeVariables.length; j++)
            System.out.println(typeVariables[j]);
        try {
            Method method = clazz.getDeclaredMethod("get");
            System.out.println(method.getGenericReturnType());
            method = clazz.getDeclaredMethod("put", Object.class);
            System.out.println(method.getGenericParameterTypes()[0]);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
      
    }
}
