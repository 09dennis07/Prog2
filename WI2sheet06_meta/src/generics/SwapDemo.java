package generics;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SwapDemo {

	// public static <T> void print(final T[] a) { // hier keine Generics notwendig
	public static void print(final Object[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static <T> void swap(T[] a, int i, int j) { // hier auch nicht unbedingt
		// assume i and j in range
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static <T> T getLast(T[] a) { // aber hier sehr sinnvoll
		return a[a.length - 1];
	}

	// Folgendes geht nicht
	// public static <T> T makeInstance() {
	//    return new T();
	// }

	// Ausweg
	public static <T> T makeInstance(Class<T> clazz) {

		try {
			Constructor<T> ct = clazz.getDeclaredConstructor();
			return ct.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// Folgendes geht nicht!
	// public static <T> T[] resize(T[] a) {
	//     T[] cl = new T[a.length + 1];
	//     return cl;
	// }

	// Ausweg
	public static <T> T[] resize(T[] a, Class<T> componentType) {
		@SuppressWarnings("unchecked")
		T[] cl = (T[]) Array.newInstance(componentType, a.length + 1);
		return cl;
	}

	public static void main(String[] args) {
		Float[] fa = { 2.0f, 4.7f, 3.9f, 0.9f };
		System.out.print("Array vor Swap:  ");
		print(fa);

		// implizite Ermittlung des aktuellen Typparameters
		swap(fa, 1, 3);
		System.out.print("Array nach erstem Swap: ");
		print(fa);
		
		// Syntax fuer explizite Vorgabe des aktuellen Typparameters
		SwapDemo.<Float>swap(fa, 0, 2);

		System.out.print("Array nach zweifachem Swap: ");
		print(fa);
		System.out.println();

		String[] sa = { "hello", "boys", "and", "girls" };
		System.out.print("Array vor Swap:  ");
		print(sa);
		swap(sa, 1, 3);
		System.out.print("Array nach Swap: ");
		print(sa);

		System.out.println();
		String s = getLast(sa);
		System.out.println("last:" + s);

		System.out.println("Size of array after resize:" + resize(fa, Float.class).length);

		System.out.println("new instance:" + makeInstance(SwapDemo.class));
	}

}