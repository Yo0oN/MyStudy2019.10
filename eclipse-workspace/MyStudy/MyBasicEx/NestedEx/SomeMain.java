package NestedEx;

public class SomeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//익명 내부 클래스 - 선언 후에 바로 사용
		SomeInterface some = new SomeInterface() {
			
			@Override
			public void printInfo() {
				// TODO Auto-generated method stub
				System.out.println("printInfo() 호출");
			}
		};
		some.printInfo();
	}
}
