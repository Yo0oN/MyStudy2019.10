package ArrayListEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookArrayList01{
	//ArrayList의 상위인 List로 ArrayList 호출
	List<Object> list = new ArrayList<Object>();
	List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
	
	public void createTest() {
		list.add("Hello");
		list.add("Hello");	//list의 특성중 하나. 동일데이터 추가가능
		list.add(null);
		list.addAll(integers);	//Object가 아닌 다른 요소 추가
		list.add(0, new Object());	//0번칸에 새로운 데이터 끼워넣기
		System.out.println("추가 후 내용 출력" + list);
	}
	public void retrieveTest() {
		//list의 내용을 하나씩 빼오기
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		//indextOf를 통하여 위치 조회
		if (list.contains("Hello")) {
			System.out.println("Hello의 위치는 : " + list.indexOf("Hello"));
		}
		
		List<Object> sub = list.subList(3, 5);
		System.out.println("sub의 내용 : " +sub);
		System.out.println("sub의 내용을 다 가지고 있는가?" +list.containsAll(sub));
		}
	public void updateTest() {
		list.set(1, "updated");
		System.out.println("업데이트 후 : " + list);
	}
	public void deletTest() {
		list.remove(0);
		list.remove("Hello");
		for(int i = 0; i<list.size(); i++) {
			if (list.get(i) instanceof Integer) {
				list.remove(i);
			}
		}
		System.out.println("삭제 후 : " + list);
		list.clear();
		System.out.println("초기화 후 : " + list);
	}
	
	public static void main(String[] args) {
		BookArrayList01 alt = new BookArrayList01();
		alt.createTest();
		alt.retrieveTest();
		alt.updateTest();
		alt.deletTest();
	}
	
}
