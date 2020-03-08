package MyQueue_Stack_Array;

import java.util.Random;

public class SearchEx03 {

	static int seqSearch(int[] a, int key) {
		int i = 0;
		// 배열의 마지막에 찾으려는 키를 추가한다.
		a[a.length - 1] = key;

		while (true) {
			// 찾는값이 나오면 종료
			if (a[i] == key) {
				break;
			}
			i++;
		}
		// 찾는값이 배열의 마지막방에 있다면 원래 배열에 없던것이므로 -1을,
		// 아니면 방번호를 리턴
		return i == (a.length - 1) ? -1 : i;
	}

	public static void main(String[] args) {
		// 보초법
		// 찾으려는 값들의 수보다 하나 더 크게 배열을 만든다.
		int[] array = new int[11];

		// 배열의 마지막은 비우고 나머지만 채운다.
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = new Random().nextInt(40);
		}

		for (int arr : array) {
			System.out.print(arr + " . ");
		}
		System.out.println();
		System.out.println(seqSearch(array, 5));

		for (int arr : array) {
			System.out.print(arr + " . ");
		}
	}
}
