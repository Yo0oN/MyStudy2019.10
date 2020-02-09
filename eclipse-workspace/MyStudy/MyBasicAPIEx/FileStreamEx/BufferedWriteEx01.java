package FileStreamEx;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("c:\\java\\newtest.txt"));
			
			bw.write("abc");
			//여기서는 newLine으로 줄바꿈을 해줄수도 있다.
			bw.write("\r\n");
			bw.newLine();
			bw.write("cdc");
			
			System.out.println("출력완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {if (bw != null) {try {bw.close();} catch (IOException e) {}}
		}
	}
}
