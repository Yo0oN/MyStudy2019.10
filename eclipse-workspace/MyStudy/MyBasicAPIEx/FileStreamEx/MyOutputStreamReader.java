package FileStreamEx;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MyOutputStreamReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputStreamWriter osw = null;
		FileOutputStream fos = null;
		try {
			//fos = new FileOutputStream("C:\\java\\MyOSW.txt");
			osw = new OutputStreamWriter(System.out);
			//String hello = "hello";
			osw.write('1');
			//fos.write('2');
			//fos.write('3');
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
