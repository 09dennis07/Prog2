package othercontainer;

import java.util.Random;
import java.util.Stack;

public class StackTest {
	public static final int NUM_COUNT = 5;
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		Random random = new Random(); 
		for (int i = 0; i != NUM_COUNT; ++i) {
			int r = random.nextInt(NUM_COUNT*10);
			System.out.println("Pushing: " + r);
			stack.push(r);
		}
		
		while (!stack.empty()) {
			System.out.println("On top of stack: " + stack.peek()); // peek(): shows top-most element but does not remove from stack
			stack.pop(); // now remove it from the stack
		}
	}
}
