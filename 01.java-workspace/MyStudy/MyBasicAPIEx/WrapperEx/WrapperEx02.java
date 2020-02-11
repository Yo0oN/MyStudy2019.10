package WrapperEx;

public class WrapperEx02 {
	public static void main(String[] args) {
		/*
		 * //오토박싱 / 언박싱 Integer i1 = Integer.valueOf(10); //기본 ->객체 //int를 쓰면 변수에 값이
		 * 바로들어가는데 integer에는 참조주소값이 들어간다. //new를 사용하는걸 간단하게 줄여서사용함.이것이 오토박싱 Integer i2 =
		 * 10; int i3 = i1; System.out.println(i3);
		 * 
		 * //언박싱을 이용한 덧셈. 원래 i2에는 참조주소값이 들어있는데, 저절로 언박싱하여 i2가 불러오는 데이터와 10이 더해져 계산이
		 * 된다...... int sum = i2 + 10; System.out.println(sum);
		 */

		Integer iObj1 = new Integer(1000);
		Integer iObj2 = new Integer(1000);
		System.out.println(iObj1 + " " + iObj2);
		System.out.println(iObj1 == iObj2);
		System.out.println(iObj1.equals(iObj2));
		System.out.println(iObj1 == 1000);
	}
}
