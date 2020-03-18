package FileStreamEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class FilesEx01 {

	public void dirInfo1(){
		try {
			DirectoryStream<Path> directoryStream
				= Files.newDirectoryStream(Paths.get("c:\\"));
			for(Path path : directoryStream ) {
				Date date = new Date(Files.getLastModifiedTime(path).toMillis());
				String name = path.getFileName().toString();
				long length = Files.size(path);
				
				if(Files.isDirectory(path)) {
					name = "[" + name + "]";
				}
				
				System.out.println(name + "\t" + date + "\t" + length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//메소를 선언할 때 안에 try~catch 가 있는것은 좋은 방식이 아니다.
	//throws를 사용하여 호출에서 문제해결을 하도록 하자.
	public void dirInfo2() throws IOException {
		
			DirectoryStream<Path> directoryStream
				= Files.newDirectoryStream(Paths.get("c:\\"));
			for(Path path : directoryStream ) {
				Date date = new Date(Files.getLastModifiedTime(path).toMillis());
				String name = path.getFileName().toString();
				long length = Files.size(path);
				
				if(Files.isDirectory(path)) {
					name = "[" + name + "]";
				}
				
				System.out.println(name + "\t" + date + "\t" + length);
			}
		}
	
	public void readTextFile() throws IOException {
		Path target = Paths.get("C:\\java\\test1.txt") ;
		BufferedReader reader = Files.newBufferedReader(target);
		String line = null;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		List<String> lines = Files.readAllLines(target);
		for(String line2 : lines) {
			System.out.println(line2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilesEx01 fe = new FilesEx01();
		//fe.dirInfo1();
		
		//선언에서 문제해결을 하지 않아서 호출할 때 문제 해결중.
		//try {
		//	fe.dirInfo2();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		try {
			fe.readTextFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
