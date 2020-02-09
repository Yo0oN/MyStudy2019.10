package StringJoinerEx;
import java.util.StringJoiner;

public class StringJoinerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringJoiner sj1 = new StringJoiner(":","[","]");
		sj1.add("사과");
		sj1.add("수박");
		sj1.add("딸기");
		
		System.out.println(sj1.toString());
	}

}
