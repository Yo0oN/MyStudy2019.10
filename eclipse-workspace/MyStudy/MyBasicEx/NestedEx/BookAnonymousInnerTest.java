package NestedEx;

public class BookAnonymousInnerTest {
	int iMember = 1;
	static int cMember = 2;
	
	void method(BookSomeInterface bsi) {
		bsi.printInfo();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookAnonymousInnerTest bait = new BookAnonymousInnerTest();
		int localVar = 3;
		bait.method(new BookSomeInterface() {
			
			@Override
			public void printInfo() {
				// TODO Auto-generated method stub
				//System.out.println("외부 인스턴스 멤버 변수 : " + iMember );
				System.out.println("외부 클래스 멤버 변수 : " + cMember );
				System.out.println("외부 로컬 변수 : " + localVar );
				
				cMember++;
				//localVar++;;
			}
		});
	}
}
