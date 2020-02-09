package HashMapEx;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookHashMapTest {
	Map<String, String> hMap = new HashMap<String, String>();
	
	private void addMethod() {
		System.out.println("추가결과 : " + hMap.put("Andy", "1234"));
		System.out.println("추가결과 : " + hMap.put("Andy", "4567"));
		hMap.put("Henry", "4567");
		hMap.put("Kate", "999");
		System.out.println(hMap);
	}
	
	private void retrieveMethod() {
		System.out.println("총 Entity 개수 : " + hMap.size());
		Set<String> keys = hMap.keySet();
		for (String key : keys) {
			System.out.println("키 : " + key + ", 값 : " + hMap.get(key));
		}
		String targetNUmber = "4567";
		Set<Map.Entry<String, String>> entrySet = hMap.entrySet();
		for (Map.Entry<String, String> entry : entrySet) {
			if(entry.getValue().equals(targetNUmber)) {
				System.out.println("번호가 " + targetNUmber + "인 사람 : " + entry.getKey());
			}
		}
		System.out.println("Kate의 전화번호가 있는가?" + hMap.containsKey("Kate"));
	}
	
	private void removeMethod() {
		hMap.remove("Andy");
		System.out.println(hMap);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookHashMapTest hmt = new BookHashMapTest();
		hmt.addMethod();
		hmt.retrieveMethod();
		hmt.removeMethod();
	}

}
