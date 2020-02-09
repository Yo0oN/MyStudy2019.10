package FileEx;
import java.io.File;
import java.io.IOException;

public class FileEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//디렉토리 생성과 삭제
		//mkdir() / delete() 디렉토리 생성,삭제
		File f1 = new File("c:\\java\\dir1");
		if(f1.delete()) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		//파일 생성과 삭제
		File f2 = new File("c:\\java\\test2.txt");
		
		//f2.createNewFile(); //이렇게만 적으면 오류
		/*try {
			if(f2.createNewFile()){
				System.out.println("파일 생성성공");
			} else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		File f3 = new File("c:\\java\\test3.txt");
		if(f2.renameTo(f3)) {
			System.out.println("이름 수정 성공");
		} else {
			System.out.println("이름 수정 실패");
		}
	}
}
