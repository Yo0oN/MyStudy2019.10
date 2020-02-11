package FileStreamEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c:\\java\\test1.txt");
			
			int data = 0; //아무값이나 넣어서 그냥 초기화시킨거
			data = fis.read();
			System.out.println(data);
			System.out.println((char)data);
			
			data = fis.read();
			System.out.println((char)data);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis !=null) try {fis.close();} catch(IOException e) {}
		}
	}
}
