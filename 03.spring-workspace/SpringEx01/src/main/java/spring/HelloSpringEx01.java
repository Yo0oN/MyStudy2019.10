package spring;

public class HelloSpringEx01 implements Hello {
	public HelloSpringEx01() {
		System.out.println("HelloSpringEx01() 생성자 호출");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name + "님 안녕하세요.");
	}
}
