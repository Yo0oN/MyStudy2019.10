package FileStreamEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c:\\java\\test1.txt");
			
			int data = 0; //아무값이나 넣어서 그냥 초기화시킨거
			while((data = fis.read()) != -1 ) {
				//엔터키
				//윈도우에서의 엔터키는 \r\n (\r은위,\n은 아래?)
				//리눅스,맥 \n
				if(data =='\r') {System.out.print("(r)");
				} else if(data =='\n') {
					System.out.print("(n)");
				} else {
					System.out.print((char)data);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis !=null) try {fis.close();} catch(IOException e) {}
		}
	}
}