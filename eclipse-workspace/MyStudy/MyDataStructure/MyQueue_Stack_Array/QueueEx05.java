package MyQueue_Stack_Array;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class MyQueue05<T> {
	class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> first;
	private Node<T> last;

	public void enque(T data) {
		Node<T> queue = new Node(data);
		if (first == null) {
			first = queue;
		} else {
			last.next = queue;
		}
		last = queue;
	}

	public T deque() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}

	public T peek() {
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}
}

class MyQueueArrayList<T> {
	//ArrayList<T>
}
public class QueueEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue05<Integer> queue = new MyQueue05();

		for (int i = 0; i < 5; i++) {
			queue.enque(i);
		}
		System.out.println(queue.isEmpty());

		while (!queue.isEmpty()) {
			System.out.println(
					"peek : " + queue.peek() + " / deque : " + queue.deque() + " / isEmpty : " + queue.isEmpty());
		}
	}

}
