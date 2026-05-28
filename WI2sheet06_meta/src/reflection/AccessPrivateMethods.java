package reflection;

import java.lang.reflect.*;

class MyPrivateMethodClass {
	@SuppressWarnings("unused")
	private void myPrivateMethod() {
		System.out.println("This is a private method");
	}

}

public class AccessPrivateMethods {
	public static void accessPrivateMethod(boolean setAccessible) {
		try {
			Class<?> clazz = MyPrivateMethodClass.class;
			Constructor<?> c = clazz.getDeclaredConstructor();
			MyPrivateMethodClass p = (MyPrivateMethodClass) c.newInstance(new Object[] {});

			Method method = clazz.getDeclaredMethod("myPrivateMethod");
			System.out.println("Method: " + method);
			
			if (setAccessible) {
				method.setAccessible(true);
			}
			
			method.invoke(p);
		} catch (Exception e) {
			System.out.println("Caught exception: " + e);
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) throws IllegalAccessException {
		System.out.println("============== Trying to access private method ...");
		accessPrivateMethod(false);

		System.out.println("============== Trying again, but this time setting accessible to true ...");
		accessPrivateMethod(true);

	}
}
