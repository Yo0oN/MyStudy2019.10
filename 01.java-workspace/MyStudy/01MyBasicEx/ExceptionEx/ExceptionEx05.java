package ExceptionEx;

public class ExceptionEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//throw : 강제 익셉션 발생
		try {
			//Exception 클래스가 정의되어 있지 않은 경우에
			//강제로 Exception을 발생한다. -> throw
			if(args.length == 1) {
				System.out.println(args[0]);
			} else {
				//
				throw new Exception("잘못된 입력");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			System.out.println("종료");
		}
	}
