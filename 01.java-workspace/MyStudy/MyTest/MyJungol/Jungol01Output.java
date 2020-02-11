package MyJungol;

public class Jungol01Output {
	public static void main(String[] args) {
		/*
		 * 1~4번.아래 "출력예"와 같이 출력되는 프로그램을 작성하라. Fun Programming! Programming! It's fun. My
		 * name is Hong Gil Dong. I am 13 years old. (햄스터그림~)
		 */

		System.out.println("Fun Programming!");

		System.out.println("Programming! It's fun.");

		System.out.println("My name is Hong Gil Dong.\r\nI am 13 years old.");

		System.out.println("(@) (@)\r\n(=^.^=)\r\n(-m-m-)");

		/*
		 * 5번. 서식 문자를 사용하여 다음과 같이 출력되는 프로그램을 작성하라. I can program well. Dreams come true.
		 */

		String i = "I can program well.\nDreams come true.";

		System.out.printf("%s", i);

		System.out.println();

//		6번 다음과 같이 출력되는 프로그램을 작성하라.
//		My height
//		170
//		My weight
//		68.600000

		String h = "My height";

		String w = "My weight";

		int hi = 170;

		double di = 68.6;

		System.out.printf("%s%n%d%n%s%n%.6f", h, hi, w, di);

		// 7번. 공백으로 구분하여 출력하여라.

		int i7 = 5;
		int j = 2;

		System.out.println(i7 + " Dan");

		System.out.println(i7 + " * " + j + " = " + (i7 * j));

		// 형1번.각 요소들은 10칸씩 공간을 확보하여 오른쪽으로 정렬하여 출력한다.

		System.out.printf("%10s%10s%10s%n%10s%10d%10d%n%10s%10d%10d%n%10s%10d%10d", "item", "count", "price", "pen", 20,
				100, "note", 5, 95, "eraser", 110, 97);

		System.out.printf("%n%n%10s%10s%10s%n", "item", "count", "price");

		System.out.printf("%10s%10d%10d%n", "pen", 20, 100);

		System.out.printf("%10s%10d%10d%n", "note", 5, 95);

		System.out.printf("%10s%10d%10d%n", "eraser", 110, 97);

		// 형1번.다음 출력 예와 같이 출력하는 프로그램을 작성하시오.

		System.out.println("\nMy name is Hong");

		// 형2번.다음 출력 예와 같이 출력되는 프로그램을 작성하시오.

		System.out.println("My hometown\nFlowering mountain");

		// 형3번.다음 출력 예와 같이 출력되는 프로그램을 작성하시오.

		System.out.println("TTTTTTTTTT\nTTTTTTTTTT\n    TT    \n    TT    \n    TT    ");
		System.out.println("TTTTTTTTTT");
		System.out.println("TTTTTTTTTT");
		System.out.println("    TT    ");
		System.out.println("    TT    ");
		System.out.println("    TT    ");

		// 형4번.합계와 평균은 수식을 이용하여 출력하여라.

		int kor = 90;
		int mat = 80;
		int eng = 100;

		// sum, avg 구하기
		System.out.printf("kor %d%nmat %d%neng %d%nsum %d%navg %d", kor, mat, eng, (kor + mat + eng),
				((kor + mat + eng) / 3));

		System.out.println("\n");

		System.out.printf("kor %d%n", kor);

		System.out.printf("mat %d%n", mat);

		System.out.printf("eng %d%n", eng);

		System.out.printf("sum %d%n", (kor + mat + eng));

		System.out.printf("avr %d%n%n", (kor + mat + eng) / 3);

		// 형5번. 모든 단어를 15칸씩 오른쪽에 맞추어 출력되는 프로그램을 작성하시오.

		System.out.printf(
				"%15s%,15d%+,15d%n" + "%15s%,15d%+,15d%n" + "%15s%,15d%+,15d%n" + "%15s%,15d%+,15d%n"
						+ "%15s%,15d%+,15d%n",
				"Seoul", 10312545, 91375, "Pusan", 3567910, 5868, "Incheon", 2758296, 64888, "Daegu", 2511676, 17230,
				"gwangju", 1454636, 29774);
	}
}
