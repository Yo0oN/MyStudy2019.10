package MyQueue_Stack_Array;

import java.util.NoSuchElementException;

class MyQueue01<T> {

	// 이 노드에 큐에 있는 데이터 하나하나를 저장하고, 다음 데이터를 저장할 위치도 함께 담겨있다.
	class Node<T> {
		private T data;
		private Node<T> next;

		// 생성자에서 데이터를 받아, 받은 데이터를 노드안에 저장한다.
		public Node(T data) {
			this.data = data;
		}
	}

	// 이곳에는 처음과 마지막 노드만 저장해준다.
	// 커서 또는 위치값같은거라고 생각하면 쉽다.
	private Node<T> first;
	private Node<T> last;

	// 큐에 데이터 넣기
	public void enqueue(T item) {
		// 큐에서 데이터를 넣을 때, 노드를 일단 만들어, 들어온 데이터를 저장해준다.
		Node<T> t = new Node<T>(item);
		// 만약 이 노드가 첫번째 노드가 아니라한다면
		// (== 마지막 노드가 있다면 == 이전에 이미 다른 노드가 있다면)
		// 그 뒤에 새로 생성한 노드를 붙여준다.
		if (last != null) {
			last.next = t;
		}
		// 그렇게 된다면 지금 만들어서 데이터 넣고 다음에 붙인 이 노드가 제일 마지막 노드다.
		last = t;
		// 데이터가 없다면, 만약 이게 첫번째 노드였다면, 지금만든 이 마지막 노드가 첫번째 자리에 들어간다.
		if (first == null) {
			first = last;
		}
	};

	// 큐에서 데이터 빼기
	public T dequeue() {
		// 만약 큐에서 데이터를 뺀다고 이 메소드를 실행했는데,
		// 이 큐에 데이터가 없다면, 고의로 예외를 발생시킨다.
		if (first == null) {
			// 참고로 이 데이터는 더이상 불러올 데이터가 없을 경우 발생하는 예외다.
			throw new NoSuchElementException();
		}
		// 이제, 데이터를 빼기 전에 다음에 있는 노드(두번째자리에있던애)를
		// 첫번째로 만들어 주어야 한다.
		// 일단 첫번째 있던 데이터를 먼저 뽑아두고,
		T data = first.data;
		// 두번째자리에있던 애를 첫번째로 옮긴다.
		first = first.next;
		// 근데 첫번째가 null일경우, 즉 두번째자리에 아무것도 없었다면,
		// 이 큐에는 더이상 데이터가 없을테니 last도 null로 바꿔주어야한다.
		if (first == null) {
			last = null;
		}

		return data;
	};

	// 큐가 비어있는지 확인
	boolean isEmpty() {
		// 첫번째 데이터가 비어있는지 확인하면 된다.
		return first == null;
	};
//
//	// 큐의 크기 확인
//	int getSize() {
//		return 0;
//	};

	// 큐의 제일 앞 데이터 보기
	public T peek() {
		// 만약 제일앞에 데이터가 없었다면, 즉, 이 큐에 데이터가 없다면 예외가 발생
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	};
}

public class QueueEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer만 넣을 수 있는 큐 만들었음
		MyQueue01<Integer> que = new MyQueue01();
		que.enqueue(1);
		que.enqueue(2);
		que.enqueue(3);
		que.enqueue(4);
		que.enqueue(5);
	}

}
