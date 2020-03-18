package HashSetEx;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		hs.add("아메리카노");
		hs.add("에스프레소");
		hs.add("카푸치노");
		//size로 데이터의 개수를 출력함
		System.out.println(hs.size());
		//toString을 통하여 안에있는 내용을 뽑아낸다.
		System.out.println(hs.toString());
		
		//Set계열은 중복데이터를 허용하지 않는다.
		hs.add("아메리카노");
		hs.add("에스프레소");
		hs.add("카푸치노");
		//중복을 허용하지 않으니 입력해도 제거된다.
		System.out.println(hs.size());
		System.out.println(hs.toString());
		
		//set계열은 순서없이 들어가있지않으니, list처럼 get으로 내용을 출력할 수 없다.
		//그래서 Iterator에 집어넣어 조건문을 이용하여 출력한다.
		Iterator<String> i = hs.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		for (String str : hs) {
			System.out.println(str);
		}
		
		Set<String> coffee = new HashSet<String>();
		coffee.add("아메리카노");
		coffee.add("카페모카");
		
		System.out.println(coffee);
		
		//coffee = Collections.unmodifiableSet(coffee);
		
		//coffee.add("카페라떼");
		//System.out.println(coffee);
		
		coffee = Collections.singleton("카페라떼");
		System.out.println(coffee);
		
		coffee.add("아메리카노");
		System.out.println(coffee);
	}
}
