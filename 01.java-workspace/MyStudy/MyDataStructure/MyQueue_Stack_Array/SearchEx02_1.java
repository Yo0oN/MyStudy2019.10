package MyQueue_Stack_Array;

import java.util.Arrays;
import java.util.Random;

public class SearchEx02_1 {

	public static void main(String[] args) {
		// Arrays의 binarySearch메소드
		// 찾는 값이 중복되어 배열에 들어있으면, 제일 처음 찾은 값을 알려준다.

		int[] array = new int[15];

		// 배열에 값을 무작위로 넣고
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(40);
		}
		// 정렬시킨다.
		Arrays.sort(array);

		// 찾을 값을 아무 값이나 하나 넣는다.
		int key = new Random().nextInt(40);

		for (int i : array) {
			System.out.print(i + "  ");
		}
		System.out.println("\n" + key);

		int result = Arrays.binarySearch(array, key);
		
		if (result >= 0) {
			System.out.println("찾는값 " + key + "는 " + result + "에 있습니다.");
		} else {
			System.out.println("찾는값 " + key + "는 없습니다.");
		}
	}
}
