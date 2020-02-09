package ObjectEx;

public class Student {
	private String name;
	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean result = false;
		Student s = (Student)obj;
		//값을 비교하게 해주는 식..
		if(s.name.equals(this.name) && s.age == this.age) {
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	//@Override
	//public String toString() {
	//	return "Student [name=" + name + ", age=" + age +"]";
	//}
}
