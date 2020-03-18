package FileStreamEx;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("./score.dat", "rw");
			
			int[] scores = {
					1, 100, 90, 900,
					2, 70, 90, 100,
					3, 100, 100, 100,
					4, 70, 60, 80,
					5, 70, 90, 100
			};
			for (int i = 0 ; i < scores.length ; i++){
				raf.writeInt(scores[i]);
				//파일 포인터(쓰거나 읽을 위치값을 표시해줌.)
				System.out.println("pointer : " + raf.getFilePointer());
			}
			
			System.out.println("출력 완료");
			
			//파일 포인터 이동하기
			raf.seek(0);
			while (true) {
				System.out.println(raf.readInt());
			}
			
		} catch(EOFException e) {
			System.out.println("입력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {if (raf != null) {try { raf.close(); } catch (IOException e) {}}
		}
	}
}
