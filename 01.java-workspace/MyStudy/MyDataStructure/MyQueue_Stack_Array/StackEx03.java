package MyQueue_Stack_Array;

import java.util.Stack;

public class StackEx03 {

	public static void main(String[] args) {
		// java.uti.Stack
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			stack.add(i);
		}
		System.out.println(stack.search(3));

		System.out.println(stack.pop());

		System.out.println(stack.search(3));
		System.out.println(stack.search(30));

		System.out.println(stack.isEmpty());
		System.out.println(stack.empty());
	}
}
