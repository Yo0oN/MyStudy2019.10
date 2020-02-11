package ArrayListEx;
import java.util.ArrayList;

public class ArrayListEx06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//엑셀형 데이터
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> data1 = new ArrayList<String>();
		data1.add("1");
		data1.add("홍길동");
		data1.add("010-111-1111");
		data1.add("20");
		data1.add("서울시");
		ArrayList<String> data2 = new ArrayList<String>();
		data2.add("2");
		data2.add("박문수");
		data2.add("010-222-2222");
		data2.add("22");
		data2.add("경기도");
		ArrayList<String> data3 = new ArrayList<String>();
		data3.add("3");
		data3.add("이몽룡");
		data3.add("010-333-3333");
		data3.add("23");
		data3.add("강원도");
		
		datas.add(data1);
		datas.add(data2);
		datas.add(data3);
		/*
		for(int i = 0 ; i < datas.size() ; i++) {//행
			ArrayList<String> data = datas.get(i);
			for(int j = 0 ; j < data.size(); j++) {//열
				System.out.print(data.get(j) + "\t");
				}
			System.out.println();
			}
			*/
		//향상된 for문
		for(ArrayList ds : datas ) {
			System.out.println(ds);
		}
		for(ArrayList<String> ds : datas ) {
			for(String dd : ds) {
				System.out.print(dd + "\t");
			}
			System.out.println();
		}
	}
}
