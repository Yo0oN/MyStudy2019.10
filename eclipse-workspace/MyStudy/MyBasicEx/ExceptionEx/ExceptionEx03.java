package ExceptionEx;

public class ExceptionEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시작");
		int num1 = 20;
		int num2 = 0;
		try {
			System.out.println("1");
			int result = num1/num2;
			System.out.println("2");
			System.out.println("결과 : " + result);
		} catch (ArithmeticException e) {
			// TODO: handle exception  Exception 발생시에만 실행
			//ArithmeticException e 에서 e는 변수다
			//ArithmeticException e = new ArithmeticException();
			//	라 적어줘야 사용할 수있겠지만 이 일은 JVM이 실행한다.
			//e : Exception 상황을 알 수 있다.
			System.out.println("Exception 발생 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("끝");
	}
}
