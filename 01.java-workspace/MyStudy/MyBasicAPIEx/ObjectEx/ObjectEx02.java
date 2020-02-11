package ObjectEx;

public class ObjectEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o1 = new Object();
		Object o2 = new Object();
		
		//주소에 대한 비교
		System.out.println(o1==o2);
		//값에 대한 비교 
		System.out.println(o1.equals(o2));
		
		Student s1 = new Student("홍길동", 20);
		Student s2 = new Student("홍길동", 20);

		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		
	}

}
