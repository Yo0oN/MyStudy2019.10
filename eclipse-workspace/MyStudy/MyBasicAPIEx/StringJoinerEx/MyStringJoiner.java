package StringJoinerEx;
import java.util.StringJoiner;

public class MyStringJoiner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringJoiner sj = new StringJoiner(" ");
		sj.add("사과");
		sj.add("수박");
		sj.add("망고");
		System.out.println(sj);
		System.out.println(sj.toString());
		StringJoiner sj2 = new StringJoiner(".");
		sj2.add("딸기");
		sj2.add("귤");
		System.out.println(sj2);
		sj.merge(sj2);
		System.out.println(sj);
		sj.merge(sj);
		System.out.println(sj);
		//sj.setEmptyValue("귤");
		//System.out.println(sj);
	}
}
