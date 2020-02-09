package MyQueue_Stack_Array;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class MyQueue02<T> {
	private ArrayList<T> queue = new ArrayList<T>();

	public void enque(T data) {
		queue.add(data);
	}

	public T deque() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.remove(0);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}

public class QueueEx02 {
	public static void main(String[] args) {
		MyQueue02<Integer> queue = new MyQueue02();
		queue.enque(1);
		queue.enque(2);
		queue.enque(3);
		queue.enque(4);
		queue.enque(5);
		queue.enque(6);

		while (!queue.isEmpty()) {
			System.out.println(queue.deque());
			System.out.println(queue.isEmpty());
		}
	}
}
