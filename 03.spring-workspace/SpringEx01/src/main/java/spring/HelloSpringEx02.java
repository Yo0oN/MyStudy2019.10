package spring;

public class HelloSpringEx02 implements Hello {
	public HelloSpringEx02() {
		System.out.println("HelloSpringEx02() 생성자 호출");
	}

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
}
