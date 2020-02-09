package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		
		byte[] b = new byte[10];
		
		byte j = 97;
		
		for (int i = 0; i < 10; i++) {
			b[i] = j;
			j++;
		}
		
		try {
			fos = new FileOutputStream("C:\\Users\\4855c\\OneDrive\\Java\\datas\\forOutput.txt");
			fos.write('H');
			fos.write(b, 5, 5);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
