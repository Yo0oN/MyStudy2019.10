package MyQueue_Stack_Array;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.peek() + "/" + queue.element() + "/" + queue.poll());
		}
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		//System.out.println(queue.element());
		//System.out.println(queue.remove());
	}

}
