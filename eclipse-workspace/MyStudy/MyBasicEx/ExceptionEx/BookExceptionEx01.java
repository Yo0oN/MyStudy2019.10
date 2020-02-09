package ExceptionEx;
import java.util.Random;

public class BookExceptionEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nextInt() : 가능한 모든 int 값에 걸친 범위의 숫자
		//nextInt(int num) : 0부터 num-1까지 범위에 있는 숫자
		int num = new Random().nextInt(2);
		try {
			System.out.println("code 1, num : " + num);
			int i = 1/num;
			System.out.println(i);
			System.out.println("code 2 : 예외 없음");
		} catch(ArithmeticException e){
			System.out.println(e.getMessage());
			System.out.println("code 3 : 예외 처리 완료");
		}
		System.out.println("code 4");
	}

}
