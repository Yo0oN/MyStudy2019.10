package spring;

public class HelloSpringEx03 implements Hello {
	private String name;

	public HelloSpringEx03() {
		System.out.println("HelloSpringEx03() 디폴트생성자 호출");
	}

	public HelloSpringEx03(String name) {
		this.name = name;
		System.out.println("HelloSpringEx03(name) 생성자 호출");
	}

	@Override
	public void sayHello(String name) {

	}

	public void sayHello() {
		System.out.println(name + "님 안녕하세요.");
	}
}
