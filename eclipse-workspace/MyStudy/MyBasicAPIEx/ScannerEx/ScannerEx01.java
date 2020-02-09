package ScannerEx;
import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//시스템상에서 입력받기
		Scanner scanner = new Scanner(System.in);
		//next는 String타입이기때문에 담아줄msg의 타입을 String으로한다.
		System.out.print("입력해주세요 : ");
		//String msg = scanner.next();
		String msg = scanner.nextLine();
		System.out.println("입력값 : " + msg);
		
		scanner.close();
	}

}
