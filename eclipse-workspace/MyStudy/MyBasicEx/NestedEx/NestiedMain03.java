package NestedEx;

public class NestiedMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 100;

		//내부에서 복잡한 식을 처리 할 때 따로 사용
		class Inner {
			int y = 200;
			
			public void viewInner() {
				System.out.println( x );
				System.out.println( y );
			}
		}
		
		Inner i = new Inner();
		i.viewInner();
	}
}
