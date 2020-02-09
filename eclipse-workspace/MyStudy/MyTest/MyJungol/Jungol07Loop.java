package MyJungol;

import java.util.Scanner;

public class Jungol07Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 반복제어문2 - 자가진단1.
		// 문자를 입력받아서 입력받은 문자를 20번 반복하여 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		System.out.println("반복제어문2-자가진단1.\r문자를 하나 입력하시오.");

		String s1 = sc.next();

		for (int i = 0; i < 20; i++) {
			System.out.print(s1);
		}

		System.out.println("\r");

		// 반복제어문2 - 자가진단2.
		// 10부터 20까지의 숫자를 차례대로 출력하는 프로그램을 작성하시오.for문을 사용하세요.

		System.out.println("반복제어문2-자가진단2.");

		for (int i = 10; i <= 20; i++) {
			System.out.print(i + " ");
		}

		System.out.println("\r");

		// 반복제어문2 - 자가진단3.
		// 하나의 정수를 입력받아 1부터 입력받은 정수까지의 짝수를 차례대로 출력하는 프로그램을 작성하시오.
		// 입력되는 정수는 50이하이다.

		System.out.print("반복제어문2-자가진단3.\r50 이하의 하나의 정수를 입력하여라.");

		int i3_1 = sc.nextInt();

		for (int i = 1; i <= i3_1; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println("\r");

		// 반복제어문2 - 자가진단4.
		// 100 이하의 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오.

		System.out.print("반복제어문2-자가진단4.\r100이하의 정수를 하나 입력하시오.");

		int i4_1 = sc.nextInt();

		int i4_2 = 0;

		for (int i = i4_1; i <= 100; i++) {
			i4_2 += i;
		}

		System.out.println(i4_2 + "\r");

		// 반복제어문3 - 자가진단5.
		// 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오.

		System.out.println("반복제어문2-자가진단5.\r10개의 정수를 입력하시오.");

		int i5_2 = 0;
		int i5_3 = 0;

		for (int i = 0; i < 10; i++) {
			int i5_1 = sc.nextInt();
			if (i5_1 % 3 == 0) {
				i5_2++;
			} else if (i5_1 % 5 == 0) {
				i5_3++;
			}
		}

		System.out.printf("Multiples of 3 : %d%nMultiples of 5 : %d%n%n", i5_2, i5_3);

		// 반복제어문3 - 자가진단6.
		// 10 이하의 과목수 n을 입력받은 후 n개 과목의 점수를 입력받아서 평균을 구하여 출력하고
		// 평균이 80점이상이면 "pass", 80점 미만이면 "fail"이라고 출력하는 프로그램을 작성하시오.
		// 평균은 반올림하여 소수 첫째자리까지 출력한다.

		System.out.println("반복제어문2-자가진단6.");

		int i6_3 = 0;

		System.out.print("과목수를 입력하시오. ");

		int i6_1 = sc.nextInt();

		System.out.println("점수를 순서대로 입력하시오");

		for (int i = 0; i < i6_1; i++) {
			int i6_2 = sc.nextInt();
			i6_3 += i6_2;
			System.out.println(i6_3);
		}

		double i6_4 = Math.round(((double) i6_3 / (double) i6_1) * 10.) / 10.;

		System.out.println("avg : " + i6_4);

		if (i6_4 >= 80) {
			System.out.println("pass\r");
		} else {
			System.out.println("fail\r");
		}

		// 반복제어문2 - 자가진단7.

		System.out.println("반복제어문2-자가진단7.");

		for (int i = 2; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(i + " ");
				i++;
			}
			i = i - 5;
			System.out.println();
		}

		System.out.println();

		// 반복제어문2 - 자가진단8.
		// 구구단의 일부를 다음과 같이 출력하는 프로그램을 작성하시오.
		// 곱셈의 결과는 오른쪽으로 맞추어 출력을 하고 결과값 사이의 공백은 3칸으로 한다.
		// 출력형식 예) 2_*_1_=__2___ _는 공백을 나타내는 것임

		System.out.println("반복제어문2-자가진단8.");

		for (int i = 2; i < 5; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.printf("%d * %d =%3d   ", i, j, i * j);
			}
			System.out.println();
		}

		// 반복제어문2 - 형성평가1.
		// 10 이하의 자연수 n을 입력받아 "JUNGOL​"을 n번 출력하는 프로그램을 작성하시오.

		System.out.print("반복제어문2-형성평가1.\r10 이하의 자연수를 하나 입력하시오.");

		int i9_1 = sc.nextInt();

		for (int i = 0; i < i9_1; i++) {
			System.out.println("JUNGOL");
		}

		System.out.println();

		// 반복제어문2 - 형성평가2.
		// 100 이하의 두 개의 정수를 입력받아 작은 수부터 큰 수까지 차례대로 출력하는 프로그램을 작성하시오.

		System.out.print("반복제어문2-형성평가2\r100 이하의 정수를 입력해주시오.");

		int i10_1 = sc.nextInt();

		System.out.print("100 이하의 정수를 하나 더 입력해주시오.");

		int i10_2 = sc.nextInt();
		if (i10_1 >= i10_2) {
			for (int i = i10_2; i <= i10_1; i++) {
				System.out.print(i + " ");
			}
		} else {
			for (int i = i10_1; i <= i10_2; i++) {
				System.out.print(i + " ");
			}
		}

		System.out.println("");

		// 반복제어문2 - 형성평가3.
		// 정수를 입력받아서 1부터 입력받은 정수까지의 5의 배수의 합을 구하여 출력하는 프로그램을 작성하시오.

		System.out.println("반복제어문2-형성평가3\r하나의 정수를 입력하시오.");

		int i11_1 = sc.nextInt();
		int i11_2 = 0;

		for (int i = 1; i <= i11_1; i++) {
			if (i % 5 == 0) {
				i11_2 += i;
			}
		}

		System.out.println(i11_2 + "\r");

		// 반복제어문2 - 형성평가4.
		// 100 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 평균을 출력하는 프로그램을 작성하시오.
		// (평균은 반올림하여 소수 둘째자리까지 출력하도록 한다.)

		System.out.println("반복제어문2-형성평가4.\r100이하의 자연수를 하나 입력하시오.");

		int i12_1 = sc.nextInt();
		int i12_2 = 0;
		int i12_3 = 0;

		System.out.println(i12_1 + "개의 정수를 입력하시오.");

		for (int i = 0; i < i12_1; i++) {
			i12_2 = sc.nextInt();
			i12_3 += i12_2;
		}

		double i12_4 = Math.round(((double) i12_3 / (double) i12_1) * 100.) / 100.;

		System.out.println(i12_4 + "\r");

		// 반복제어문2 - 형성평가5.
		// 10개의 정수를 입력받아 입력받은 수들 중 짝수의 개수와 홀수의 개수를 각각 구하여 출력하는 프로그램을 작성하시오.

//		System.out.println("반복제어문2-형성평가5.\r10개의 정수를 입력하시오.");
	}

}
