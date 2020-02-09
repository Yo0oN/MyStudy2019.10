package FileStreamEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("C:\\Users\\4855c\\OneDrive\\Java\\datas\\forInput.txt");
			byte[] b = new byte[16];
			b[0] = 'A';
			b[1] = 'B';
			b[2] = 'C';

			fis.read(b, 2, 10);
			for (int i = 0; i < b.length; i++) {
				System.out.print((char) b[i]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
