package ArrayListEx;
import java.util.ArrayList;

public class ArrayListEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList와 Wrapper
		//ArrayList에 Integer만 넣기
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		//Integer.valueOf를 이용해 Integer형으로 int를 바꿔서 al에 넣어줌
		al.add(Integer.valueOf(10));
		al.add(Integer.valueOf(20));
		//오토박싱으로 저절로 int가 Integer로 바뀜
		al.add(30);
		al.add(40);
		
		//Object를 Integer로 변경
		Integer i = al.get(0);
		//Integer를 int로 언박싱
		System.out.println(i.intValue());
		//이렇게해도 값이 나오긴한다.
		System.out.println(i);
		
		//오토언박싱
		int i2 = al.get(2);
		System.out.println(i2);
		
		int sum = al.get(0) + al.get(3);
		System.out.println(sum);
	}

}
