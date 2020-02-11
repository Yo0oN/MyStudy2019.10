package ArrayListEx;
import java.util.ArrayList;

public class ArrayListEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열인데 방갯수가 정해져 있어서 자료를 넣는데 제한이 있다.
		int[] intArray = new int[4];
		//배열과 비슷한데 방갯수가 정해져있지 않아 자료를 넣는데 제한이 없다.
		ArrayList al = new ArrayList();
		
		String data1 = "박문수";
		String data2 = "이몽룡";
		
		//add를 써서 넣으면 object데이터로 들어가게된다.
		al.add(data1);
		al.add(data2);	//위의 String 데이터가 Object로 자동형변환되었다.
		
		/*
		//Object로 ArrayList로 들어간 자료를 다시 String으로 형변환 시켰다.
		String str = (String)al.get(0); 
		//String 데이터를 출력함
		System.out.println(str);
		//
		Object obj = al.get(0);
		//Object데이터를 출력함
		System.out.println(obj);
		//String 데이터를 출력함
		System.out.println(obj.toString());
		*/
		al.add(2, "홍길동");	//2번에 추가로 넣음
		al.set(0, "성춘향");	//0번방의자료를 다른것으로 변경
		al.add(2,"이순신");	//2번에 추가로 넣음, 2번에있던것부터 뒤로밀림
		
		for(Object obj : al) {
			String str = (String)obj;
			System.out.println(str);
		}
		System.out.println();
		al.remove(0);//0번방 데이터 삭제
		for(Object obj : al) {
			String str = (String)obj;
			System.out.println(str);
		}
		System.out.println();
		al.clear();	//전부 제거
		for(Object obj : al) {
			String str = (String)obj;
			System.out.println(str);
		}
		System.out.println("끝");
	}

}
