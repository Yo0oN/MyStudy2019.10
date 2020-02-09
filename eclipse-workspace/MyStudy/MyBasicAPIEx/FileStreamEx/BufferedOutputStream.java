package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.io.BufferedOutputStream bos = null;
		try {
			bos = new java.io.BufferedOutputStream(new FileOutputStream("c:\\java\\newtest.txt"));
			
			bos.write('a');
			bos.write('b');
			bos.write('c');
			bos.write('d');
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {bos.close();} catch(IOException e) {}
			}
		}
	}
}
