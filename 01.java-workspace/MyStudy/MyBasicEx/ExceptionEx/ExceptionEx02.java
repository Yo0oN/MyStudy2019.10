package ExceptionEx;

public class ExceptionEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시작");
		String[] datas = {"1", "2", "3"};
		System.out.println(datas[0]);
		System.out.println(datas[5]);	//에러가 발생하여 중간에 종료
		System.out.println("끝");
	}

}
