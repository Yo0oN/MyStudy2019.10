package MyClass;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipCodeIncheonMoveEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bf = null;
		BufferedWriter bw = null;
		try {
			bf = new BufferedReader(new FileReader("C:\\java\\java-workspace\\MyTest\\zipcode_seoul_utf8_type2.csv"));
			bw = new BufferedWriter(new FileWriter("c:\\java\\인천A.txt"));
			
			String sentence = null;
			while((sentence = bf.readLine()) != null) {
				String addresses[] = sentence.split(",");
				if(addresses[1].equals("인천")) {
					bw.write(sentence);
					bw.newLine();
				}
			}
			System.out.println("출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			if (bw != null) {try {bw.close();} catch (IOException e) {}}
			if (bf != null) {try {bf.close();} catch (IOException e) {}}
		}
	}
}
