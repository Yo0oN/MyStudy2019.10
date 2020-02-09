package MyJungol;

import java.util.Scanner;

public class Jungol09Array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 배열1 - 자가진단1
		// 문자 10개를 저장할 수 있는 배열을 만들고 10개의 문자를 입력받은 문자를 이어서 출력하는 프로그램을 작성하시오.
		System.out.print("배열1-자가진단1\r문자를 차례대로 10개 입력하시오. ");

		String[] s1_1 = new String[10];

		for (int i = 0; i < 10; i++) {
			s1_1[i] = sc.next();
		}

		for (String s : s1_1) {
			System.out.print(s);
		}

		System.out.println();

		// 배열1 - 자가진단2
		// 정수 10개를 저장할 수 있는 배열을 만들어 1부터 10까지 대입 후 차례대로 출력하시오.

		System.out.println("배열1-자가진단2");

		int[] i2_1 = new int[10];

		for (int i = 0, j = 1; i < 10; i++, j++) {
			i2_1[i] = j;
		}
		for (int i : i2_1) {
			System.out.print(i + " ");
		}
		System.out.println();
		// 배열1 - 자가진단3
		// 10개의 문자를 입력받아, 첫번쨰, 네번쨰, 일곱번째 문자를 차례로 출력하시오.
		System.out.print("배열1-자가진단3\r문자를 차례로 10개 입력하시오.");
		String[] s3_1 = new String[10];
		for (int i = 0; i < 10; i++) {
			s3_1[i] = sc.next();
		}
		System.out.printf("%s %s %s", s3_1[0], s3_1[3], s3_1[6]);
	}

}
