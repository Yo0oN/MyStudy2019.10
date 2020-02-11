package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("c:\\java\\newtest.txt");
			
			fos.write(96);
			fos.write(97);
			fos.write('\r');
			fos.write('\n');
			fos.write('\r');
			fos.write('\n');
			fos.write('c');
			fos.write('d');
			System.out.println("출력 완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {fos.close();} catch (IOException e) {}
			}
		}
	}
}
