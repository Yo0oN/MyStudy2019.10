package FileStreamEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInputStreamReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			//fis = new FileInputStream("C:\\java\\test1.txt");
			//isr= new InputStreamReader(fis);
			isr = new InputStreamReader(System.in);
			System.out.print((char)isr.read());
			System.out.print((char)isr.read());
			System.out.print((char)isr.read());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(isr != null) {try { isr.close(); } catch (IOException e) {}}
			//if(isr != null) {try { isr.close(); } catch (IOException e) {}}
		}
	}
}
