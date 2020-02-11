package FileStreamEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileEx01 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("c:\\java\\Tulips.jpg");
			fos = new FileOutputStream("c:\\java\\newTulips1.jpg");
			
			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//finally 안의 내용은 파일인풋,아웃풋스트림을 하는동안은 계속 쓴다.외우던가 복붙해주자.
			//전송이 끝나면 꼭!닫아줘야한다!
			if(fis != null) {try {fis.close();} catch(IOException e) {}}
			if(fos != null) {try {fos.close();} catch(IOException e) {}}
		}
		System.out.println("복사 완료");
	}
}
