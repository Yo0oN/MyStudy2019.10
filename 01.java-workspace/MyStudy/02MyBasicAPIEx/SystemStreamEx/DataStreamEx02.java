package SystemStreamEx;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataStreamEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStream dis = null;
		
		try {
			//C:\java\java-workspace\SystemStreamEx01\value.dat
			//C:\java\java-workspace\SystemStreamEx01\src\DataStreamEx02.java
			dis = new DataInputStream(new FileInputStream("./value.dat"));
			
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			System.out.println(dis.readFloat());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {if (dis != null) {try { dis.close(); } catch (IOException e) {}}
		}
	}
}
