package HashMapEx;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//key키, value값 -> key를 이용해 key방 value를 넣어주고, key방에서 value를 뺴준다
		HashMap<String, String> hm1 = new HashMap<String, String>();
		
		hm1.put("a", "박문수");
		hm1.put("b", "이몽룡");
		hm1.put("c", "성춘향");
		
		System.out.println(hm1.size());
		System.out.println(hm1.toString());
		
		hm1.put("d", "홍길동");
		System.out.println(hm1.toString());
		
		//이미 들어가있는 방에 다른값을 넣으면 수정된다.
		hm1.put("c","이순신");
		System.out.println(hm1.toString());
		
		System.out.println(hm1.get("a"));
		System.out.println(hm1.get("b"));
		
		Set<String> keys = hm1.keySet();
		System.out.println(keys.toString());
		
		Iterator<String> i = keys.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
			//System.out.println(hm1.get(i.next()));
		}
		
		Collection<String> values = hm1.values();
		for (String value : values) {
			System.out.println(value);
		}
	}
}
