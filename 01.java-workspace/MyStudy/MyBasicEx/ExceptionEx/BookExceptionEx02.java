package ExceptionEx;
import java.util.Random;

public class BookExceptionEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = new Random().nextInt(2);
		try {
			System.out.println("code 1, num : " + num);
			int i = 1/num;
			System.out.println("code 2 - 예외없음");
			return;
		} catch(ArithmeticException e) {
			System.out.println("code 3 - 예외 처리 완료");
		} finally {
			System.out.println("code 4 - 언제나 실행");
		}
		System.out.println("code 5");
	}

}
