package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		
		try {
			//절대경로를 사용해서 읽어온다.
			//fr = new FileReader("C:\\java\\java-workspace\\FileStreamEx01\\zipcode_seoul_utf8_type2.csv");
			//상대경로로 읽어보자.
			fr = new FileReader("./zipcode_seoul_utf8_type2.csv");
			int data = 0;
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fr != null) {try {fr.close();} catch(IOException e) {}}
		}
	}
}
