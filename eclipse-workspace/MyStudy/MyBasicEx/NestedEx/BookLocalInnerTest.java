package NestedEx;

public class BookLocalInnerTest {
	int iMember = 1;
	static int cMember = 2;
	
	void method() {
		int localVar = 3;
		
		class LocalInner{
			int innerLocalVal = 4;
			void innerMethoid() {
				System.out.println("외부 인스턴스 멤버 변수 : " + iMember);
				System.out.println("외부 인스턴스 멤버 변수 : " + cMember);
				System.out.println("외부 로컬 변수 : " + localVar);
				System.out.println("내부 인스턴스 멤버 변수 : " + innerLocalVal);
				iMember++;
				cMember++;
				//localVar++;
				innerLocalVal++;
			}
		}
		LocalInner lInner = new LocalInner();
		lInner.innerMethoid();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookLocalInnerTest lit = new BookLocalInnerTest();
		lit.method();
	}

}
