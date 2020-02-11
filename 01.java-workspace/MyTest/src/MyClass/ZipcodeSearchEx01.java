package MyClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZipcodeSearchEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("동이름 입력(q:종료) : ");
			String msg = scan.nextLine();
			if (msg.equals("quit")) {
				System.out.println("프로그램 종료");
				break;
			}
			BufferedReader br = null;
			try {
				br = new BufferedReader(
						new FileReader("C:\\java\\java-workspace\\MyTest\\zipcode_seoul_utf8_type2.csv"));

				String sentence = null;
				while ((sentence = br.readLine()) != null) {
					// System.out.println(sentence);
					String[] adresses = sentence.split(",");
					if (adresses[3].startsWith(msg)) {
						System.out.println(sentence);
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
					}
				}
			}
		}
		scan.close();
	}
}
