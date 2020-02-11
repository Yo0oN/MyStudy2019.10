package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZipSearch03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//주소록 먼저 불러온다.
		FileReader fr = null; 

		try {
			fr = new FileReader("C:\\java\\java-workspace\\FileStreamEx01\\zipcode_seoul_utf8_type2.csv");
			//내용을 받아서 저장시킬곳을 만든다.
			int data = 0;
			//내용을 받아서 문자열로 저장시킬곳을 만들자.
			String datas = "";
			//내용이 없을때까지 불러온다.
			while((data = fr.read()) != -1 ) {
				//data에 넣은걸빼보자.
				//data에 들어간건 int값이니까 문자로뺴자..
				//System.out.print((char)data);
				
				//받은것을 한줄기준으로 나눠보자.
				//내용을 빼다가 줄바꿈을만나게된다면? 거기서멈추는겨
				if(data != '\r') {
					//줄바꿈을 만날때까지 데이터를 문자열에 더해주자.
					datas += (char)data;
					//System.out.print(datas);
				} else  {
					//줄바꿈을 만났으니 멈추고,이제 여기서 개포가 맞는지 비교하자.
					if (datas.contains("개포")) {
						System.out.print(datas);
					}
				//개포를 출력했으니까 다음줄을 위해 datas를 비워주자.
				datas = "";
				}
					
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {if (fr != null) {try {fr.close();} catch (IOException e) {}}
		}
	}

}
