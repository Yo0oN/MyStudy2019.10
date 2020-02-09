package MyQueue_Stack_Array;

import java.util.NoSuchElementException;

// 큐 클래스 만들어주기
class MyQueue03<T> {
	
	class Node<T> {
		private T data;
		private Node<T> next;
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void enque (T t) {
		Node<T> node = new Node(t);
		
		if (first == null) {
			first = node;
			last = first;
		} else {
			// 이것은 마지막에 있던 노드에 다음 노드의 주소를 저장한 것이다.
			last.next = node;
			// last = node라 하여도 마지막 자리의 노드가 사라지지 않는것은,
			// 어차피 이전 노드에 마지막이었던 노드의 주소가 저장되어 있기 때문이다.
			// last나 first는 타이틀 같은거라 생각하면 쉬울듯..?
			// 타이틀 바꾼다고해서 캐릭터가 사라지지않듯..?
			last = node;
		}
	}
	public T deque() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T t = first.data;
		first = first.next;
		
		// 만약 다음칸이 없었다면, 즉 디큐로 값을 뺐는데 이 큐에 더이상 값이 없다면
		// last에도 null을 넣어주어야한다.
		if (first == null) {
			last = null;
		}
		return t;
	}
	public boolean isEmpty() {
		return last == null;
	}
}
public class QueueEx03 {

	public static void main(String[] args) {
		MyQueue03<Integer> queue = new MyQueue03();
		for (int i = 1; i < 6; i++) {
			queue.enque(i);			
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.deque());
		}
		queue.deque();
		
	}

}
