package generics;

public class GenericsInheritance {
	class A<T> {}

	class B<T> extends A {}

	class C extends A<String> {}

	class D<T> extends A<T> {}

	class E<T> extends A<String> {}
	
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		SingleObjectHolder<Integer> si = new SingleObjectHolder<>();
		SingleObjectHolder<Number> sn  = new SingleObjectHolder<>();
		
		// Inheritance with generic parameters does not work --> Cannot cast SingleObjectHolder<Integer> to SingleObjectHolder<Number>
		// Compiler error
		//sn = (SingleObjectHolder<Number>)si;
		
		System.out.println(sn.get());
		
	}
}
