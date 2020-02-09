package ArrayListEx;
import java.util.ArrayList;

public class ArrayListEx07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("1", "홍길동", "010-111-1111", "20", "서울시");
		Student s2 = new Student("2", "박문수", "010-222-2222", "22", "경기도");
		Student s3 = new Student("3", "이몽룡", "010-333-3333", "23", "강원도");
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		
		//향상된for문으로 출력해보자.
		for(Student als : al) {
			System.out.println(als.getSeq()+"\t" + als.getName()
			+"\t" + als.getPhone() +"\t" + als.getAge() +"\t" + als.getRegion());
		}
	}

}
