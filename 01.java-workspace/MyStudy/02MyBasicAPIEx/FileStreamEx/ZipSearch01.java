package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ZipSearch01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//동을 검색하면 우편번호가 뜨는 우편번호 검색기를 만들어보자~
		//args로 파일을 입력받는다.
		//파일리더로 파일을 불러온다.
		
		//동을 입력받는다.
		String[] arg = new String[1];
		arg[0] = args[0];
		
		//파일리더로 우편번호를 불러온다.
		FileReader fr = null;
		
		try {
			fr = new FileReader("C:\\\\java\\\\java-workspace\\\\FileStreamEx01\\\\zipcode_seoul_utf8_type2.csv");
			
			int data = 0;
			String datas = "";
			
			//일단 데이터를 쭉 불러온다.
			//왜 fr.read() =-1로 하면 실행되는데 fr != null이라 하면안될까?
			while((data = fr.read()) != -1){

				//불러온데이터를 한줄을 한덩이로보고 넣는다.
				if(data != '\n') {
					datas += (char)data;
				} else {
					//근데 가다가 엔터를 만나면 그 줄을 뽑는다.
					//System.out.println(datas);
					//근데 또 거기에 개포가있는것만뽑고싶다.
					//만약 개포가 들어있으면
					if(datas.contains("개포")) {
						System.out.println(datas);
					}
					datas = "";
				}
				//System.out.println(datas);
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
