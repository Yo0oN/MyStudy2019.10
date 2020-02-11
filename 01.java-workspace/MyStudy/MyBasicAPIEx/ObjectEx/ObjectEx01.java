package ObjectEx;

public class ObjectEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o1 = new Object();
		//java.lang.Object = 자료형
		//@2f92e0f4 = 해쉬코드

		System.out.println( o1 );
		System.out.println( o1.toString() );//16진수
		System.out.println(o1.hashCode());	//10진수
		System.out.printf("%x%n", o1.hashCode()); //16진수
		
		System.out.println(o1.getClass().getName());
		
		
		//Student 클래스는 지금 아무것도 상속받지않고 만들기만하였는데, 위의 o1처럼 object에 있는 코드들을 쓸 수 있다
		// -> 모든 클래스들은 특별히상속받는것을 지정하지 않으면 object를 상속받아 사용한다.
		Student s = new Student();
		System.out.println( s );
		System.out.println(s.toString());
		System.out.println(s.hashCode());
		System.out.println(s.getClass().getName());
	}

}
