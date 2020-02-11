package FileEx;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path path1 = Paths.get("C:\\java\\test1.txt");
		Path path2 = Paths.get("C:\\java\\new1.txt");
		Path path3 = Paths.get("C:\\java\\test\\test1.txt");
		try {
			//Files.copy(path1, path2);
			//Files.delete(path3);
			byte[] data = Files.readAllBytes(path1);
			System.out.println(data.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
