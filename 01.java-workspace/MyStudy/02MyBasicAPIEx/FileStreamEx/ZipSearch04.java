package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZipSearch04 {
	//스캐너로 밖에서도 값을 받을 수 있게 해준다.
	Scanner sc = new Scanner(System.in);
	//동을 받을 문자열을 만든다.
	public String dong="";
	//실행하면 안내문구와 입력창이 나오는것 메소드를 만든다.
	public void dongM(){
		//동을입력하라는 안내문구가 나오고
		System.out.print("동을 입력하세요.");
		//동을 받을 문자열에 스캐너를 받을 쑤 있게 한다.
		dong= sc.nextLine();
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZipSearch04 z = new ZipSearch04();
		FileReader fr = null;
		
		//이짓을 a가 입력될때까지 반복한다.
		l : while(true){
			//메소드를 시작하면 동을 입력하는 안내문구와, 스캐너가 실행시 제일 먼저 나오게 해준다.
			z.dongM();
			try {
				//주소록을 불러온다.
				fr = new FileReader("./zipcode_seoul_utf8_type2.csv");
				//내용이 오면 받아줄 변수를 만든다.
				int data = 0;
				//데이터는 int로 들어온다.그것을 char로바꿔서 모아줄 문자열 변수를 만들어준다. 
				String sentence = "";
				//주소록을 계속 받는다.
				while((data = fr.read()) != -1) {
					//주소록을 쭉 받는다.
					if(data != '\n') {
						//주소록을 받다가 엔터가나오기전까지는 if안을 실행한다
						//char를 문자열데이터인 sentence에 넣어준다. 
						sentence += (char)data;
					} else {	//주소를 받다가 엔터가나오면 else안을 실행한다.
						//엔터를 기준으로 줄을 나누면 줄바꿈이 2번된다.그러니까 마지막엔터를 빼주자.
						sentence = sentence.substring(0, sentence.length()-1);
						//System.out.println(sentence);
						//sentence안에는 이제 주소록이 한줄이 들어와있다.
						//그 줄을 ,를 기준으로 나눠서 sen이라는 배열안에 넣어준다.
						//,를 기준으로 나눠서 배열에 넣었으면, 배열의 3번방에 동이 들어와있다.
						String[] sen = sentence.split(",");
						//System.out.println(sen[3]);
						//3번방에 동이들어와있으니 위에서 입력한 dong의 값이 3번방과 같은지 확인한다.
						if(sen[3].startsWith(z.dong)) {
							//만약 같다면, 그 줄을 출력한다.
							System.out.println(sentence);
						}
						//출력이 다끝났으니 이제 안에있는것을 초기화시켜 지워준다.
						//만약 이작업을 하지않으면 sentence안에는
						//이전에 파일에서 받아온 데이터들이 저장되어있기떄문에 데이터가 계속 쌓여서
						//출력할때 이전것도 같이 출력되기를 반복하게된다.(맞는지모르겠다..)
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
			//스캐너로 입력받은문자가 a가 되면 이제 종료한다.
			if (z.dong.equals("a")) {
				System.out.println("끝");
				break l;
				}
		}
	}
}
