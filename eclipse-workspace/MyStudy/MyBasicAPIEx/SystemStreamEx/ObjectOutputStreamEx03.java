package SystemStreamEx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./serial.dat"));
			
			Person p = new Person("홍길동", "010-0000-0000", 20, "서울시");
			
			oos. writeObject(p);
			
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {if (oos != null) {try { oos.close(); } catch (IOException e) {}}
		}
	}
}
