package FileStreamEx;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBufferedEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream fis = null;
		//FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream("c:\\java\\newTulips2.jpg"));
			bis = new BufferedInputStream(new FileInputStream("c:\\java\\Tulips.jpg"));
			
			int data = 0;
			while ((data = bis.read()) != -1 ) {
				bos.write(data);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bis != null) {try {bis.close();} catch(IOException e) {}}
			if(bos != null) {try {bos.close();} catch(IOException e) {}}
		}
		
	}

}
