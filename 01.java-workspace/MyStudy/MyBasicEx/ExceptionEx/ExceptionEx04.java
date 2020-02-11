package ExceptionEx;

public class ExceptionEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시작");
		//다중예외처리
		//name이 null이기 때문에 name.length()를 할 수 없어 에러,
		//result에서 분모가 0이기 때문에 또 에러
		try {
			String name = "Hello";
			int num1 = 0;
			int num2 = 10;
			System.out.println("문자열 길이 : " +name.length());
			int result = num2/num1;
			System.out.println("결과 : " + result);
		} catch(NullPointerException e) {
			System.out.println("null로 초기화 됨");
		} catch(ArithmeticException a) {
			System.out.println("0으로 나누었음");
		}
		System.out.println("끝");
	}

}
