package StringTokenizerEx;
import java.util.StringTokenizer;

public class MyStringTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hello = "Hello Java, Nice to meet you.";
		StringTokenizer st = new StringTokenizer(hello);
		/*System.out.println(st.countTokens());
		System.out.println(st.nextElement());
		System.out.println(st.nextToken());
		System.out.println(st.hasMoreElements());
		//while은 true일동안만 진행되는것을 이용하여,
		//st에 아직 문자열이 있으면 hasMoreElements나, hasMoreTokens가
		//True가 나오므로 계속 출력가능하다.
		while (st.hasMoreElements()) {
			System.out.print(st.nextElement() + "  ");
		}
		System.out.println();*/
		System.out.println(st.countTokens());
		System.out.println(st.nextToken("o"));
		System.out.println(st.countTokens());
		System.out.println(st.nextToken("t"));
		System.out.println(st.countTokens());
		System.out.println(st.nextElement());
		System.out.println(st.countTokens());
		for (String h : hello.split("a")) {
			System.out.println(h);
		}
		String[] h = hello.split("a");
		for(String hs : h){
			System.out.println(hs);
		}
	}
}
