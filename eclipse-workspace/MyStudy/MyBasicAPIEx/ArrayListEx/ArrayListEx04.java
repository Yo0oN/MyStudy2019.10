package ArrayListEx;
import java.util.ArrayList;

public class ArrayListEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList는 Object형태로 자동형변환 되어 입력받기 때문에 아무 클래스나입력해도 상관없다.
		//그로인해 발생하는 문제를 확인해보자.
		
		ArrayList al1 = new ArrayList();
		
		//String데이터를 al1에 넣음
		al1.add("홍길동");
		al1.add("박문수");
		//Person데이터로 뒤에다가추가로 넣음		
		Person p1 = new Person("1001", "홍길동");
		Person p2 = new Person("1002", "박문수");
		al1.add(p1);
		al1.add(p2);
		
		/*
		//향상된 for문을 써서 빼려고하는데 들어간 데이터가 일관성이 없으니 문제가 생긴다.
		//들어간건 String과 Person 둘 다 들어갔는데 String으로 빼려니까 문제
		for(Object o : al1) {
			String str = (String)o;
			System.out.println(str);
		}
		*/
		
		//제네릭을 통해서 입력 데이터를 제한해서 위와같은 문제가 발생하지 않게 해주자.
		//<> 사이에 입력할 데이터형식을 적는다.
		ArrayList<String> al2 = new ArrayList<String>();
		//ArrayList<String> al3 = new rrayList<>();위와 같은말이다.
		al2.add("박문수");
		al2.add("홍길동");
		//al2.add(p1); String만 넣어야하는데 Person을 넣으니 오류가 생긴다.

		//String으로 형변환시켜서 다시빼주자
		String str0 = al2.get(0);
		System.out.println(str0);
		
		//향상된 for문을 쓸 때 위에서 제네릭으로 String만 넣었으니 ArrayList에는 String만 들어갔다는걸 안다.
		//그렇기 때문에 자동으로 Object에서 형변환 되어서 뺄수있게되어서, 직접 형변환 하지 않아도 알아서 빠진다.
		for (String str : al2) {
			System.out.println(str);
		}
		
		
		ArrayList<Person> al3 = new ArrayList<Person>();
		
		al3.add(p1);
		al3.add(p2);
		
		for (Person alp : al3) {
			System.out.println(alp);
		}
	}
}
