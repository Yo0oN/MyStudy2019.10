package ArraysEx;
import java.util.Arrays;

public class ArraysEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrs = {"aaa", "bbb", "ccc"};
		String[] arrs2 = {"aaa", "bbb", "ccc"};
		//Arrays를 이용한 전체 데이터의 초기화
		//Arrays.fill(arrs, "xxx");
		//Arrays를 이용한 일부 초기화 (0부터 2전까지 초기화)
		Arrays.fill(arrs, 0, 2, "xxx");
		for(String arr : arrs) {
			System.out.print(arr + "\t");
		}
		System.out.println();
		//배열의 값 비교
		System.out.println(arrs == arrs2 );
		//여기서 사용된 equals는 Object의 equals를 상속받아 사용중이라 false
		System.out.println(arrs.equals(arrs2));
		//여기서 사용하는 equals는 Arrays의 equals를 상속받아 사용중이라 true
		System.out.println(Arrays.equals(arrs, arrs2));
		
		//정렬
		Integer[] nums = {5, 2, 3, 1, 4};
		//정렬하기 전에는 집어넣은 순서대로방에 들어가있다.
		for (int num : nums) {
			System.out.print(num);
		}
		System.out.println();
		//하지만 정렬을 하고나니 오름차순으로 변경되어 방에 들어갔다!
		Arrays.sort(nums);
		for (int num : nums) {
			System.out.print(num);
		}
		System.out.println();
		//문자의 정렬?
		String[] sarrs = {"Java", "is", "A", "PIE!"};
		for (String sarr : sarrs){System.out.print(sarr + "\t");}
		System.out.println();
		//ASCII Code값으로 정렬된다. 대문자 -> 소문자
		Arrays.sort(sarrs);
		for(String sarr : sarrs) {System.out.print(sarr + "\t");}
	}
}
