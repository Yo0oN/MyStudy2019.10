package spring;

public class HelloBean {
	private String name1;
	private String name2;

	public HelloBean() {
		System.out.println("HelloBean 디폴트 생성자 호출");
	}

	public HelloBean(String name1, String name2) {
		System.out.println("HelloBean(name1, name2) 생성자 호출");
		this.name1 = name1;
		this.name2 = name2;
	}

	public void sayHello() {
		System.out.println(name1 + " / " + name2);
	}
}
