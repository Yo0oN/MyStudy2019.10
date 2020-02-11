package spring;

public class HelloAnnotationEx01 implements Hello {
	public HelloAnnotationEx01() {
		System.out.println("HelloAnnotationEx01 생성자 호출");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name + "님 안녕하세요.");
	}
}
