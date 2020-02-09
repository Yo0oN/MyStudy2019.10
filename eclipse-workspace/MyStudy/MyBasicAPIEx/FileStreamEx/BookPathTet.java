package FileStreamEx;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BookPathTet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path1 = Paths.get("C:\\windows\\explorer.exe");
		System.out.println("파일명 : " + path1.getFileName());
		System.out.println("이름의 개수 : " + path1.getNameCount());
		System.out.println("0번째 이름의 개수 : " + path1.getName(0));
		System.out.println("0~2의 패스 : " + path1.subpath(0, 2));
		System.out.println("상위 경로 : " + path1.getParent());
		System.out.println("루트 경로 : " + path1.getRoot());
		
		Path relative = Paths.get(".\\src");
		System.out.println("절대경로로 : " + relative.toAbsolutePath());
		System.out.println("상대 경로 표시 삭제 : " + relative.normalize().toAbsolutePath());
		
		File file = relative.toFile();
		System.out.println("URI 표현 : " + relative.toUri());
		
		Path path2 = Paths.get("c:\\Windows\\Appcompat\\UA\\GenericApp.png");
		System.out.println("파일명 : " + path2.getFileName());
		System.out.println("이름의 개수 : " + path2.getNameCount());
		System.out.println("0번째 이름의 개수 : " + path2.getName(0));
		System.out.println("0~2의 패스 : " + path2.subpath(0, 2));
		System.out.println("상위 경로 : " + path2.getParent());
		System.out.println("루트 경로 : " + path2.getRoot());
	}
}
