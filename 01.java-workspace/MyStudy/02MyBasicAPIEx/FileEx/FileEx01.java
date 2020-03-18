package FileEx;
import java.io.File; //io=input output
import java.io.IOException;
import java.util.Date;

public class FileEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//절대경로를 통한 File 객체 생성
		//윈도우에서의 디렉토리 생성
		File f1 = new File("c:\\java");
		//윈도우에서의 파일 생성
		File f2 = new File("C:\\java\\test1.txt");
		File f3 = new File("../../test1.txt");
		
		System.out.println(f2.getName());
		System.out.println(f2.getPath());
		System.out.println(f2.getParent());
		System.out.println(f2.getParentFile());
		
		
		
		
		if(f1.exists()) {
			System.out.println("디렉토리 있음");
		} else {
			System.out.println("디렉토리 없음");
		}
		if(f2.exists()) {
			System.out.println("파일 있음");
		} else {
			System.out.println("파일 없음");
		}
		if(f2.isDirectory()) {
			System.out.println("디렉토리");
		} else {
			System.out.println("파일");
		}
		//이름
		System.out.println(f3.getName());
		//상대경로?
		System.out.println(f3.getParent());
		//절대경로
		System.out.println(f3.getPath());
		System.out.println(f3.getAbsolutePath());
		
		try {
			System.out.println(f3.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(f2.isHidden()) {
			System.out.println("숨김파일");
		} else {
			System.out.println("일반파일");
		}
		//lastModified는 타임스탬프(1970년)로부터의 밀리초가 출력되기 때문에
		//long에 담겨서 나온다.
		//밀리초를 우리가 알고있는 시간으로 보고싶다면 Date나 Callendar에 담아서 출력해야한다.
		long fileDate = f2.lastModified();
		System.out.println(fileDate);
		Date date = new Date(fileDate);
		System.out.println(date);
		System.out.println(date.toLocaleString());
		//파일 용량. 단위는 B로 나온다. KB로 하려면 /1024해주기.
		long fileSize = f2.length();
		System.out.println(fileSize);
	}
}
