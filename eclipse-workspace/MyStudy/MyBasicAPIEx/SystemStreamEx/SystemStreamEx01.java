package SystemStreamEx;
import java.io.IOException;
import java.io.InputStream;

public class SystemStreamEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner 이전의 키보드를 통한 입력
		//Stream이기때문에 영어나 숫자만 가능하다.
		InputStream is = null;
		
		try {
			is = System.in;
			System.out.print("데이터 입력 : ");
			//한자씩 읽을 수 있다.
			System.out.println("입력값 : " + (char)is.read());
			System.out.println("입력값 : " + (char)is.read());
			System.out.println("입력값 : " + is.read());
			/*
			while (is != null) {
				System.out.println("입력값 : " + (char)is.read());
			}
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is != null) try { {is.close();} } catch (IOException e) {}
		}
	}
}
