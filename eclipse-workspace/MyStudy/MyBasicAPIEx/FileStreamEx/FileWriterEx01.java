package FileStreamEx;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		try {
			fw = new FileWriter("c:\\java\\newtest.txt");
			
			fw.write("abc\r\n");
			fw.write("def\r\n");
			fw.write("가나다");
			fw.write("라마바");
			fw.write("\r\nおはようございます\r\n你好。");
			System.out.println("출력완료~");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {try {fw.close();} catch(IOException e) {}}
		}	
	}
}
