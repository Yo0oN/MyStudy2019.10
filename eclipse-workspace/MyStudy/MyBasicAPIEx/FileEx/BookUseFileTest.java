package FileEx;
import java.io.File;
import java.util.Date;


public class BookUseFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//현재있는 곳의 경로를 나타내는 .을 File안에 넣어 currentDir라는 객체를 만든다.
		File currentDir = new File(".");
		//만약에 현재 디렉토리에 파일이 존재한다면 아래의 식을 시작한다.
		if (currentDir.exists()) {
			// 현재 디렉토리에 있는것들중에 파일
			File[] childs = currentDir.listFiles();
			for(File child : childs) {
				Date time = new Date(child.lastModified());
				String name = child.getName();
				long length = child.length();
				if (child.isDirectory()) {
					name = "[" + child.getName() + "]";
				}
				System.out.printf("%-20s\t%tF %<tT\t%s%n", name, time, length);
			}
		}
	}

}
