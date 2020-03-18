package ExceptionEx;

public class ExceptionEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시작");
		int num1 = 0;
		int num2 = 20;
		
		//0으로 나눌 수 없다는 Exception 발생
		if(num1 !=0 ) {
			int result = num2/num1;
			System.out.println("결과 : " + result);
		} else {
			System.out.println("분모는 0이 될 수 없습니다.");
		}
		
		System.out.println("끝");
	}
}
