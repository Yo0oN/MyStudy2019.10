package ObjectEx;

public class ObjectEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = new Object();
		System.out.println(o.toString());
		
		//내부 데이터를 확인하려고 오버라이딩
		Student s = new Student("홍길동", 20);
		System.out.println(s.toString());
		System.out.println(s);
		
		String str = new String("Hello");
		System.out.println(str.toString());
	}

}
