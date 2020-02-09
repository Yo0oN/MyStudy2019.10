package FileStreamEx;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//try~with~resources 구문
		//finally에서 close하던것을 없애고,
		//try에서 생성,호출 close를 한번에 해결한다.
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\java\\newtest.txt"));) {
			bw.write("abc");
			//여기서는 newLine으로 줄바꿈을 해줄수도 있다.
			bw.write("\r\n");
			bw.newLine();
			bw.write("cdc");
			
			System.out.println("출력완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
