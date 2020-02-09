package MyJungol;

import java.util.Scanner;

public class Jungol06Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 반복제어문1 - 자가진단1.
		// 1부터 15까지 차례로 출력하는 프로그램을 while을 이용하여 작성하여라.
		System.out.println("반복제어문1-자가진단1.");
		int i1_1 = 1;
		while (i1_1 <= 15) {
			System.out.print(i1_1 + "  ");
			i1_1++;
		}
		System.out.println();

		// 반복제어문1 - 자가진단2.
		// 100 이하의 양의 정수만 입력된다.
		// while 문을 이용하여 1부터 입력받은 정수까지의 합을 구하여 출력하는 프로그램을 작성하시오.
		System.out.print("반복제어문1-자가진단2.\r100 이하의 양의 정수를 입력하시오. ");
		Scanner sc = new Scanner(System.in);
		int i2_1 = sc.nextInt();
		int i2_2 = 0;
		int i2_3 = 0;
		while (i2_3 <= i2_1) {
			i2_2 += i2_3;
			i2_3++;
		}
		System.out.println(i2_2 + "\r");

		// 반복제어문1 - 자가진단3.
		// 한 개의 정수를 입력받아 양수(positive integer)인지 음수(negative number)인지
		// 출력하는 작업을 반복하다가 0이 입력되면 종료하는 프로그램을 작성하시오.
		System.out.println("반복제어문1-자가진단3." + "숫자를 입력하시오. 0을 입력하면 종료됩니다.");

		while (true) {
			System.out.print("number? ");
			int i3_1 = sc.nextInt();
			if (i3_1 == 0) {
				System.out.println("zero\r");
				break;
			} else if (i3_1 < 0) {
				System.out.println("negative number");
			} else {
				System.out.println("positive integer");
			}
		}

		// 반복제어문1 - 자가진단4.
		// 정수를 계속 입력받다가 100 이상의 수가 입력이 되면
		// 마지막 입력된 수를 포함하여 합계와 평균을 출력하는 프로그램을 작성하시오.
		// (평균은 반올림하여 소수 첫째자리까지 출력한다.)
		System.out.println("반복제어문1-자가진단4." + "\r숫자를 계속 입력하시오. 100이상의 수가 입력되면 종료됩니다.");

		int i4_1 = 0;
		int i4_2 = 0;
		int i4_3 = 0;

		l: while (true) {
			i4_1 = sc.nextInt();
			if (i4_1 < 100) {
				i4_2 += i4_1;
				++i4_3;
			} else if (i4_1 >= 100) {
				double i4_4 = (Math.round(((double) (i4_2 + i4_1) / (double) (i4_3 + 1) * 10)) / 10.0);
				System.out.printf("%d%n%.1f", i4_2 + i4_1, i4_4);
				break l;
			}
		}
		System.out.println("\r");

		// 반복제어문1 - 자가진단5.
		// 정수를 입력받아서 3의 배수가 아닌 경우에는 아무 작업도 하지 않고
		// 3의 배수인 경우에는 3으로 나눈몫을 출력하는 작업을 반복하다가
		// -1이 입력되면 종료하는 프로그램을 작성하시오.
		System.out.println("반복제어문1-자가진단5." + "\r정수를 계속 입력하시오. -1을 입력하면 종료됩니다.");

		int i5_1 = 0;

		while (true) {
			i5_1 = sc.nextInt();
			if (i5_1 % 3 == 0) {
				System.out.println(i5_1 / 3);
			} else if (i5_1 == -1) {
				System.out.println("종료");
				break;
			}
		}

		System.out.println();

		// 반복제어문1 - 자가진단6.
		// 아래와 같이 나라 이름을 출력하고 숫자를 입력받아
		// 해당하는 나라의 수도를 출력하는 작업을 반복하다가
		// 해당하는 번호 이외의 숫자가 입력되면 "none"라고 출력한 후 종료하는 프로그램을 작성하시오.
		// * 각 나라의 수도 :
		// 대한민국 = 서울(Seoul) /미국 = 워싱턴(Washington)
		// 일본 = 동경(Tokyo)/중국 = 북경(Beijing)
		System.out.println("반복제어문1-자가진단6." + "\r원하는 나라의 숫자를 입력하시오. 범위를 벗어나면 종료됩니다.");

		l: while (true) {
			System.out.print("1. Korea\r\n2. USA\r\n3. Japan\r\n" + "4.China\r\nnumber? ");
			int i6_2 = sc.nextInt();
			switch (i6_2) {
			case 1:
				System.out.println("Seoul");
				break;
			case 2:
				System.out.println("Washington");
				break;
			case 3:
				System.out.println("Tokyo");
				break;
			case 4:
				System.out.println("Beijing");
				break;
			default:
				System.out.println("none");
				break l;
			}
		}
		System.out.println();

		// 반복제어문1 - 형성평가1.
		// 정수를 입력받아 1부터 입력받은 정수까지를 차례대로 출력하는 프로그램을 작성하시오.
		System.out.print("반복제어문1-형성평가1.\r하나의 정수를 입력하시오. ");
		int i7_1 = sc.nextInt();
		int i7_2 = 1;
		for (; i7_2 <= i7_1; i7_2++) {
			System.out.print(i7_2 + " ");
		}
		System.out.println();

		// 반복제어문1 - 형성평가2.
		// 0 이상의 정수들이 공백으로 구분되어 반복적으로 주어진다.
		// 0이 입력되면 반복문을 멈추고 그 전까지 입력받은 수들에 대하여
		// 홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.
		// +C언어에서는 공백으로 값을 받을 수 있지만, java에서는 불가능하다.
		// 공백이아니라 줄바꿈을 기준으로 숫자를 입력받도록 하자.
		System.out.println("반복제어문1-형성평가2.\r0 이상의 정수를 엔터를.. 기준으로 입력하시오." + " 0이 입력되면 종료됩니다.");
		int i8_1 = 0;
		int i8_2 = 0;
		int i8_3 = 0;

		while (true) {
			i8_1 = sc.nextInt();
			if (i8_1 == 0) {
				break;
			} else if (i8_1 % 2 != 0) {
				i8_2++;
			} else {
				i8_3++;
			}
		}
		System.out.println("odd : " + i8_2);
		System.out.println("even : " + i8_3 + "\r");

		// 반복제어문1 - 형성평가3.
		// 0 부터 100 까지의 점수를 계속 입력받다가
		// 범위를 벗어나는 수가 입력되면 그 이전까지 입력된 자료의 합계와
		// 평균을 출력하는 프로그램을 작성하시오.
		// (평균은 반올림하여 소수 첫째자리까지 출력한다.)
		System.out.println("반복제어문1-형성평가3.\r" + "0부터 100까지의 숫자만 계속 입력하시오.");
		int i9_1 = 0;
		// 들어온 값을 더할 값
		int i9_2 = 0;
		// 몇번 들어왔는지 알려주는 값
		int i9_3 = 0;
		double i9_4 = 0;

		l: while (true) {
			i9_1 = sc.nextInt();

			if (i9_1 < 0 || i9_1 > 100) {
				if (i9_3 == 0) {
					System.out.println("평균을 낼 수 없어 계산 할 수 없습니다.");
					break l;
				} else {
					i9_4 = ((double) i9_2 / (double) i9_3);

					System.out.println("sum : " + i9_2);
					System.out.println("avg : " + i9_4);
					break l;
				}
			}
			i9_2 += i9_1;
			i9_3++;
		}

		// 반복제어문1 - 형성평가4.
		// 0 이 입력될 때까지 정수를 계속 입력받아
		// 3의 배수와 5의 배수를 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.

		System.out.println("반복제어문1-형성평가4.\r\n정수를 계속 입력하시오. 0이 입력되면 종료됩니다.");

		int i10_1 = 0;
		int i10_2 = 0;

		while (true) {
			i10_1 = sc.nextInt();
			if (i10_1 == 0) {
				break;
			} else if (i10_1 % 3 != 0) {
				if (i10_1 % 5 != 0) {
					i10_2++;
				}
			}
		}

		System.out.println(i10_2 + "\r");

		// 반복제어문1 - 형성평가5.
		// 삼각형의 밑변의 길이와 높이를 입력받아 넓이를 출력하고, "Continue? "에서 하나의 문자를 입력받아
		// 그 문자가 'Y' 나 'y' 이면 작업을 반복하고 다른 문자이면 종료하는 프로그램을 작성하시오.
		// 넓이는 반올림하여 소수 첫째자리까지 출력한다.​
		System.out.println("반복제어문1-형성평가5.\r삼각형 넓이 구하기.");

		int i11_1 = 0;
		int i11_2 = 0;

		String s11_4 = null;

		l: while (true) {
			System.out.print("Base = ");
			i11_1 = sc.nextInt();

			System.out.print("Height = ");
			i11_2 = sc.nextInt();

			double i11_3 = Math.round(((double) (i11_1 * i11_2) / 2.0) * 10.) / 10.;

			System.out.printf("Triangle width = %.1f%n계속하려면 Y, 끝내려면 N를 입력하시오.%nContinue? ", i11_3);
			s11_4 = sc.next();

			if (s11_4.equals("Y")) {
				continue;
			} else if (s11_4.equals("N")) {
				System.out.println("end\r");
				break l;
			} else {
				System.out.println("제대로된 값을 입력하지 않아 종료합니다.");
				break l;
			}
		}

	}

}
