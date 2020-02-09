package HashSetEx;
import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class BookTreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Object> set = new TreeSet<Object>();
		//set.add("I");
		set.addAll(Arrays.asList("w","o","r","l","d"));
		System.out.println("오름차순 TreeSet : " + set);
		System.out.println("처음 요소" + set.first());
		System.out.println("마지막 요소" + set.last());
		System.out.println("o 아래 요소" + set.lower(""));
		System.out.println("l 다음 요소" + set.higher("l"));
		System.out.println("m 이전 요소" + set.floor("m"));
		System.out.println("m 다음 요소" + set.ceiling("m"));
		System.out.println("헤드 셋 : "+ set.headSet("m"));
		
		NavigableSet<Object> naviSet = set.descendingSet();
		System.out.println("내림차순 TreeSet : " + naviSet);
		}
}
