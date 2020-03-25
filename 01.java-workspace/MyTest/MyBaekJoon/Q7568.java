import java.util.HashMap;
import java.util.Scanner;

public class Q7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		String p = "";
		for (int i = 0; i < num; i++) {
			String s = sc.nextLine();
			p += s + " ";
		}
		System.out.println(p);
		System.out.println("========");
		HashMap<Integer, Integer> w = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

	}

}
