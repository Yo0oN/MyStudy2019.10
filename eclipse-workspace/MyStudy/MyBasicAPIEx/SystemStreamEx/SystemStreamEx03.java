package SystemStreamEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemStreamEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner 이전의 키보드를 통한 입력
		//Reader이기때문에 영어외의 다른문자 가능
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("데이터 입력 : ");
			
			System.out.println("입력값 : " + br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try { {br.close();} } catch (IOException e) {}
		}
	}
}
