package MyClass;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//인천지역만 추출해서 인천.txt 파일에 저장하는 클래스 작성
public class ZipCodeIncheonMoveEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//zipcord먼저 불러오기
		//인천인애들뽑기
		//txt로 저장하기
		BufferedReader bf = null;
		FileWriter fw = null;
		
		try {
			bf = new BufferedReader(new FileReader("C:\\java\\java-workspace\\MyTest\\zipcode_seoul_utf8_type2.csv"));
			fw = new FileWriter("c:\\java\\인천.txt");
				//System.out.println(bf.readLine());
				String data = null;
				//zipcord에 있는 내용 다 불러왔다. 이제 인천만 뽑자.
				while((data = bf.readLine()) != null) {
					//System.out.println(bf.readLine());
					//인천은 2번째에 있다. 두번째에있는줄먼저 뽑자.
					String[] datas = data.split(",");
					//만약 인천이라면 출력하기
					if(datas[1].contains("인천")) {
						//만약인천 출력했으니까 txt파일로내보내주자.
						//System.out.println(data);
						//이렇게만쓰니까 줄바꿈없이 나온다. 줄바꿈을 넣어보자..
						//fw.write(data);
						fw.write(data + "\r\n");
						
					}
				}
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			if (fw != null) {try {fw.close();} catch (IOException e) {}}
			if (bf != null) {try {bf.close();} catch (IOException e) {}}
		}
	}
}
