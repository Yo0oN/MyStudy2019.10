package SystemStreamEx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체(배열) 형태 데이터를 file에 넣기
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./data.dat"));
			
			String[] names = {"홍길동", "박문수", "이몽룡"};
			int[] ages = {55, 23, 47};
			double[] weights = {71.4, 69.9, 58.6};
			
			oos.writeObject(names);
			oos.writeObject(ages);
			oos.writeObject(weights);
			
			System.out.println("출력 완료");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {if(oos != null) {try { oos.close(); } catch (IOException e) {}}
		}
	}
}
