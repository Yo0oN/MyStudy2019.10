package MyQueue_Stack_Array;

import java.util.Random;

class SearchKey {
	static int searchKey(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}
}

public class SearchEx01 {
	// 선형검색2
	public static void main(String[] args) {
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = new Random().nextInt(20);
		}

		int key = new Random().nextInt(20);

		SearchKey search = new SearchKey();

		int result = search.searchKey(array, key);

		if (result != -1) {
			System.out.println(key + "는 " + result + "에 있습니다.");
		} else {
			System.out.println(key + " 값이 없습니다.");
		}
	}
}
