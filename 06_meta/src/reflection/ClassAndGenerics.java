package reflection;

public class ClassAndGenerics {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Class<?> clazz1 = "abc".getClass();
        Class<?> clazz2 = Class.forName("java.lang.String");
        System.out.println(clazz1 == clazz2);
        Object o ="abc";
        @SuppressWarnings("unused")
		String s = stringClass.cast(o);
    }

}
