package ComparatorEx;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
	String name;
	int id;
	double score;

	public Student(String name, int id, double score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}

	public String toString() {
		return "이름 : " + this.name + " 학번 : " + this.id + " 학점 : " + score;
	}

	// 학번으로 오름차순하여 정렬하기
	@Override
	public int compareTo(Student student) {
		// Integer.compare 메서드는
		// 첫번째 매개변수와 두번째 매개변수가 오름차순으로 유지될 수 있도록 값을 비교해준다.
		// Integer.compare을 보면 아래처럼 x가 y보다 작다면 -1을, 같다면 0을, 크다면 1을 리턴해준다.
		// public static int compare(int x, int y) {
		// return (x < y) ? -1 : ((x == y) ? 0 : 1);
		// }
		// 여기서 return값이 0이하이면 자리바꿈을 하지 않고, 양수일 경우 자리바꿈을 한다.
		// 위의 경우를 그대로하면 오름차순으로 정렬이 된다.
		// 그렇기 때문에 아래에서는
		return Integer.compare(this.id, student.id);
	}
}

class NameAscending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		// 아래의 compareTo 메소드는 String 클래스에 잇으며,
		// 문자열을 사전순서대로 정렬해준다.
		return s1.name.compareTo(s2.name);
	}

}

public class ComparatorEx01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student[] = { new Student("홍길동", 20120001, 4.2), new Student("김춘배", 20150001, 4.5),
				new Student("김철수", 20110001, 3.5), new Student("김멍멍", 20130001, 2.8),
				new Student("김야옹", 20140001, 4.2) };
		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].toString());
		}

		System.out.println("==================================");

		Arrays.sort(student);
		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].toString());
		}

		System.out.println("==================================");

		Arrays.sort(student, new NameAscending());
		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].toString());
		}
	}
}
