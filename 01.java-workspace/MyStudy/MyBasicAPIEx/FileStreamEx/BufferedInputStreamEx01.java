package FileStreamEx;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			//fis = new FileInputStream("c:\\java\\test1.txt");
			bis = new BufferedInputStream(new FileInputStream("c:\\java\\test1.txt"));
			
			int data = 0;
			while((data = bis.read()) != -1) {
				System.out.print((char)data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//if(fis != null) {try {fis.close();} catch(IOException e) {}}
			if(bis != null) {try {bis.close();} catch(IOException e) {}}
		}
	}
}
