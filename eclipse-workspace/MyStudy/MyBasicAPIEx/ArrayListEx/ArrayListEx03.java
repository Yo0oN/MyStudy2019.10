package ArrayListEx;
import java.util.ArrayList;

public class ArrayListEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("1001", "홍길동");
		Person p2 = new Person("1002", "박문수");
		Person p3 = new Person("1003", "성춘향");
		
		ArrayList al = new ArrayList();
		//ArrayList의 al 안에 데이터를 하나씩 집어넣었다.
		al.add(p1);
		al.add(p2);
		al.add(p3);
		
		//.size : List계열의 길이를 알 수 있다.
		System.out.println(al.size());
		
		//Object로 ArrayList에 들어가있는것을 Person데이터로 형변환 하고,
		//0번의 데이터를 p에 넣는다.
		Person p = (Person)al.get(0);
		//Person클래스에서 override한 toString을 불러옴
		System.out.println(p.toString());
		//Person클래스에서 getHakbun과 getName을 불러온다.
		System.out.println(p.getHakbun());
		System.out.println(p.getName());
		
		//향상된 for문에서 al은 Object형식으로 데이터가 들어있으니
		//Object로 일단 뺀다
		for(Object o : al ) {
			//Object인 데이터를 Person데이터로 바꿔준다.
			Person pe = (Person)o;
			//Person클래스의 getHackbun과 getName을 불러온다.
			System.out.print(pe.getHakbun());
			System.out.println(pe.getName());
		}
		//al의 참조주소가 al2에 들어간다.
		ArrayList al2 = al;
	}
}
