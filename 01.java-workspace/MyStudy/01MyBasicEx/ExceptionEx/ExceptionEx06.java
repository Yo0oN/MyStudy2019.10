package ExceptionEx;

public class ExceptionEx06 {
	//문제가 생기면 나에게 메세지가 온다.
	public void method1(int num) {
		//num이 100보다 크면 Exception처리
		try {
			if (num >= 100 ) {
				throw new Exception("100보다 크다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//메소드를 호출한 쪽에서 처리할 수 있도록 메세지를 전해준다.
	//API라이브러리에서는 이런식으로 적혀있다.
	public void method2(int num) throws Exception {
		if (num >= 100 ) {
			throw new Exception("100보다 크다.");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionEx06 ee = new ExceptionEx06();
		ee.method1(99);
		ee.method1(101);
		try {
			ee.method2(101);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
