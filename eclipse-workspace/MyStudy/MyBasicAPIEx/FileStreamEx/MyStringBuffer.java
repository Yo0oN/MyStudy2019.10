package FileStreamEx;

public class MyStringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//buffer = 내부 저장공간
		StringBuilder sb1 = new StringBuilder();
		StringBuffer sb2 = new StringBuffer(100);
		StringBuilder sb3 = new StringBuilder("Hello World");
		String s1 = "Hello World";
		
		//capacity 저장공간의 크기를 알려줌
		System.out.println(sb1.capacity() + " " + sb1.hashCode());
		System.out.println(sb2.capacity() + " " + sb2.hashCode());
		System.out.println(sb3.capacity() + " " + sb3.hashCode());
		System.out.println(s1.hashCode());

		//sb3에 들어있는데이터의 길이를 알려준다.
		System.out.println(sb3.length());
		
		//버퍼조작 : append 맨 뒤에 추가, inser 사이에 추가, delete 삭제
		System.out.println(sb3 + " " + sb3.hashCode());
		sb3.append("안녕");
		System.out.println(sb3 + " " + sb3.hashCode());
		sb3.insert(3, " 추가 ");
		System.out.println(sb3 + " " + sb3.hashCode());
		sb3.delete(0, 4);
		System.out.println(sb3 + " " + sb3.hashCode());
		sb3.deleteCharAt(6);
		System.out.println(sb3 + " " + sb3.hashCode());
		//Stringbuffer는 데이터를 삭제하던, 추가하던 주소가 계속 일정하다.
		//하지만, String은 새로운 곳에 데이터를 저장하게 되어 추가할떄마다 주소가 계속 변한다.
		String s2 = s1 + "Hello Java";
		System.out.println(s2.hashCode());
		System.out.println(sb3.indexOf("o"));
		System.out.println(sb3.replace(4,7,"헤이"));
		
	}
}
