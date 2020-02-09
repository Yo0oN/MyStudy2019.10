package MyQueue_Stack_Array;

import java.util.ArrayList;

class MyStack02<T> {
	private ArrayList<T> stack;

	public MyStack02() {
		stack = new ArrayList<T>();
	}

	public T pop() {
		return stack.remove(stack.size() - 1);
	}

	public void push(T data) {
		stack.add(data);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public T peek() {
		return stack.get(stack.size() - 1);
	}
}

public class StackEx02 {

	public static void main(String[] args) {
		// ArrayList로 만들기
		MyStack02<Integer> stack = new MyStack02();

		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.peek() + " / " + stack.pop() + " / " + stack.isEmpty());
		}
	}
}
