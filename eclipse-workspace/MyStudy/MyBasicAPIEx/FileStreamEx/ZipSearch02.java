package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZipSearch02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		
		try {
			//주소록을 불러온다.
			fr = new FileReader("./zipcode_seoul_utf8_type2.csv");
			int data = 0;
			//데이터는 int로 들어와서 char로 바뀐다. 그것을 쌓아줄 변수를 만들어준다. 
			String sentence = "";
			//주소록을 계속 받는다.
			while((data = fr.read()) != -1) {
				//엔터를 기준으로 줄을 나눠준다
				if(data != '\n') {
					//char를 문자열데이터인 sentence에 넣어준다. 
					sentence += (char)data;
				} else {
					//엔터를 기준으로 줄을 나누면 줄바꿈이 2번된다.그러니까 마지막엔터를 빼주자.
					sentence = sentence.substring(0, sentence.length()-1);
					//System.out.println(sentence);
					//개포라고만 검색하면 개포아파트이런것도 뜨게되니까 쉼표로나눠서
					//동부분이 개포인것만 뽑아서 출력한다.
					String[] sen = sentence.split(",");
					//System.out.println(sen[3]);
					
					if(sen[3].startsWith("개포")) {
						System.out.println(sentence);
					}
					//if(sentence.contains("개포")) {
					//	System.out.println(sentence);
					//}
					sentence = "";
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fr != null) {try {fr.close();} catch(IOException e) {}}
		}
	}
}
