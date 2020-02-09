package ArrayListEx;
import java.util.ArrayList;

public class ArrayListEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al1 = new ArrayList();
		ArrayList al2 = new ArrayList(100);
		
		String data1 = "박문수";
		String data2 = "이몽룡";
		
		//al1.add((Object)data1);로 적어도 되고
		al1.add(data1);	//자동형변환되어 이렇게 해도괜찮다
		al1.add(data2);
		
		System.out.println(al1.size());
		
		al1.add("홍길동");	//자동 형변환되어 홍길동이 바로 추가되었다.
		System.out.println(al1.size());
		
		//get을 이용하여 내용을 뺀다.
		//Object obj1 = al1.get(0);
		//String str1 = (String)obj1;
		String str1 = (String)al1.get(2);
		System.out.println(str1);
		
		for(int i = 0 ; i < al1.size() ; i++) {
			String data = (String)al1.get(i);
			System.out.println(data);
		}
		for (Object al : al1) {
			String data = (String)al;
			System.out.println(data);
		}
	}
}
