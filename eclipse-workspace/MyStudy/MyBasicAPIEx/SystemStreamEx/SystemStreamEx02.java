package SystemStreamEx;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemStreamEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner 이전의 키보드를 통한 입력
		//Reader이기때문에 영어외의 다른문자 가능
		InputStreamReader isr = null;
		
		try {
			isr = new InputStreamReader(System.in);
			System.out.print("데이터 입력 : ");
			
			//한자씩 읽을 수 있다.
			System.out.println("입력값 : " + (char)isr.read());
			System.out.println("입력값 : " + (char)isr.read());
			/*
			while (isr != null) {
				System.out.println("입력값 : " + (char)isr.read());
			}
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(isr != null) try { {isr.close();} } catch (IOException e) {}
		}
	}
}
