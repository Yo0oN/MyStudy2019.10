package MyQueue_Stack_Array;

import java.util.Random;

public class SearchEx01_1 {
	// 선형검색
	static int seqSearch(int[] a, int key) {
		int i = 0;
		while (true) {
			// 배열의 마지막인지 확인
			if (i == a.length) {
				return -1;
			}
			if (a[i] == key) {
				return i;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[10];

		for (int i = 0; i < 10; i++) {
			array[i] = new Random().nextInt(20);
		}

		for (int arr : array) {
			System.out.print(arr + "  ");
		}
		System.out.println();
		System.out.println(seqSearch(array, 3));
	}
}
