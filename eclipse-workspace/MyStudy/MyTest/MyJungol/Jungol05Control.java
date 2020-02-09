package MyJungol;

import java.util.Scanner;

public class Jungol05Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 선택 제어문 - 자가진단 1.
		// 정수를 입력받아 첫 줄에 입력받은 숫자를 출력하고, 만약 음수라면 둘째 줄에 minus라 출력하여라.

		System.out.print("선택제어문-자가진단1.\r한 개의 숫자를 입력하시오. ");

		Scanner sc1 = new Scanner(System.in);

		int i1_1 = sc1.nextInt();

		if (i1_1 >= 0) {
			System.out.println(i1_1);
		} else {
			System.out.println(i1_1 + "\rminus\r");
		}

		// 선택 제어문 - 자가진단 2.
		// "몸무게+100-키"를 비만수치 공식이라 하자.
		// 키와 몸무게를 자연수를 입력받아 첫 줄에 비만수치를 출력하고,
		// 비만수치가 0보다 크면 다음줄에 Obesity를 출력해라.

		System.out.print("선택제어문-자가진단2.\r키 몸무게 순서로 두 개의 숫자를 입력하시오. ");

		Scanner sc2 = new Scanner(System.in);

		String[] s2_1 = (sc2.nextLine().split(" "));

		int[] i2_2 = new int[s2_1.length];

		for (int i = 0; i < s2_1.length; i++) {
			i2_2[i] = Integer.parseInt(s2_1[i]);
		}
		if (i2_2[1] + 100 - i2_2[0] > 0) {
			System.out.println((i2_2[1] + 100 - i2_2[0]) + "\rObesity\r");
		} else {
			System.out.println(i2_2[1] + 100 - i2_2[0] + "\r");
		}
		
		// 선택 제어문 - 자가진단 3.
		// 나이를 입력받아 20살 이상이면 adualt라 출력, 아니면 몇 년후에 성인이 되는지를 출력하여라.
		
		System.out.print("선택제어문-자가진단3.\r나이를 입력하시오. ");
		
		Scanner sc3 = new Scanner(System.in);
		
		int i3_1 = sc3.nextInt();
		
		if (i3_1 >= 20)
			System.out.println("adult\r");
		else
			System.out.println(20 - i3_1 + " years later\r");

		// 선택 제어문 - 자가진단 4.
		// 몸무게가 50.80 이상을 Flyweight, 61.23이상을 Lightwweight, 72.57 이하를 Middleweight
		// 88.45 이하를 Cruiserweight, 88.45 초과를 Heavyweight라 한다. 몸무게를 입력받아 체급을 출력하시오.
		
		System.out.print("선택제어문-자가진단4.\r몸무게를 입력하시오. ");
		
		Scanner sc4 = new Scanner(System.in);
		
		int i4_1 = sc4.nextInt();
		
		if (i4_1 <= 50.80)
			System.out.println("Flyweight\r");
		else if (i4_1 <= 61.23)
			System.out.println("Lightweight\r");
		else if (i4_1 <= 72.57)
			System.out.println("Middleweight\r");
		else if (i4_1 <= 88.45)
			System.out.println("Cruiserweight\r");
		else
			System.out.println("Heavyweight\r");

		// 선택 제어문 - 자가진단 5.
		// 두 개의 실수를 입력받아 모두 4.0이상이면 A, 3.0이상이면 B, 아니면 C를 출력하여라.
		
		System.out.println("선택제어문-자가진단5.\r두 개의 실수를 입력하시오. ");
		
		Scanner sc5 = new Scanner(System.in);
		
		String[] s5_1 = sc5.nextLine().split(" ");
		
		double[] i5_2 = new double[s5_1.length];
		
		for (int i = 0; i < s5_1.length; i++)
			i5_2[i] = Double.parseDouble(s5_1[i]);
		
		if (i5_2[0] + i5_2[1] >= 4.0)
			System.out.println("A\r");
		else if (i5_2[0] + i5_2[1] >= 3.0)
			System.out.println("B\r");
		else
			System.out.println("C\r");

		// 선택 제어문 - 자가진단 6.
		// 남자는 M 여자는 F으로입력하고, 나이를 입력하면
		// 18세 이상 성인 남자는 MAN, 여자는 WOMAN으로, 18세 이하 미성년 남자는 BOY, 여자는 GIRL을 출력하여라.
		
		System.out.print("선택제어문-자가진단6.\r남자는 M, 여자는 F를 입력하고 나이를 입력하여라. ");
		
		Scanner sc6 = new Scanner(System.in);
		
		String[] s6_1 = sc6.nextLine().split(" ");
		
		int[] i6_2 = { Integer.parseInt(s6_1[1]) };
		
		if (s6_1[0] == "M") {
			if (i6_2[0] >= 18) {
				System.out.println("MAN\r");
			} else {
				System.out.println("BOY\r");
			}
		} else if (s6_1[0] == "F") {
			if (i6_2[0] >= 18) {
				System.out.println("WOMAN\r");
			} else {
				System.out.println("GIRL\r");
			}
		} else
			System.out.println("제대로 입력해주세요\r");

		// 선택 제어문 - 자가진단 7.
		// 영문 대문자를 입력받아 A는 Excellent, B는 Good, C는 Usually,
		// D는 Effort, F는 Failure, 그 외 문자는 error라고 출력하여라.
		
		System.out.print("선택제어문-자가진단7.\rA부터 F까지 한 글자만 대문자로 입력하여라. ");
		
		Scanner sc7 = new Scanner(System.in);
		
		String s7_1 = sc7.next();
		
		switch (s7_1) {
		case "A":
			System.out.println("Excellent\r");
			break;
		case "B":
			System.out.println("Good\r");
			break;
		case "C":
			System.out.println("Usually\r");
			break;
		case "D":
			System.out.println("Effort\r");
			break;
		case "E":
			System.out.println("Failure\r");
			break;
		default:
			System.out.println("error\r");
		}

		// 선택 제어문 - 자가진단 8.
		// 4.5 이하의 평점을 입력받아 4.0 이상 : "scholarship", 3.0 이상 : "next semester"
		// 2.0 이상 : "seasonal semester", 2.0 미만 : "retake"​ 을 출력하여라.
		// 실수를 정수형으로 변환하여 분기한다.(switch((int)score))
		
		System.out.print("선택제어문-자가진단8\r학점을 입력하여라.(학점은 최대 4.5이다.) ");
		
		Scanner sc8 = new Scanner(System.in);
		
		double d8_1 = sc8.nextDouble();
		
		switch ((int) d8_1) {
		case 4:
			System.out.println("scholarship\r");
			break;
		case 3:
			System.out.println("next semester\r");
			break;
		case 2:
			System.out.println("easonal semester\r");
			break;
		default:
			System.out.println("retake\r");
		}

		// 선택 제어문 - 자가진단 9.
		// 3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을 출력하여라.
		
		System.out.print("선택제어문-자가진단9.\r3개의 정수를 입력하여라. ");
		
		Scanner sc9 = new Scanner(System.in);
		
		String[] s9_1 = sc9.nextLine().split(" ");
		
		int[] i9_2 = new int[s9_1.length];
		
		for (int i = 0; i < s9_1.length; i++)
			i9_2[i] = Integer.parseInt(s9_1[i]);
		
		int i9_3 = (i9_2[0] > i9_2[1]) ? ((i9_2[0] > i9_2[2]) ? i9_2[0] : i9_2[2])
				: ((i9_2[1] > i9_2[2]) ? i9_2[1] : i9_2[2]);
		
		System.out.println(i9_3 + "\r");

		// 선택 제어문 - 형성평가 1.
		// 두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하여라.
		
		System.out.print("선택제어문-형성평가1.\r2 개의 정수를 입력하여라. ");
		
		Scanner sc10 = new Scanner(System.in);
		
		String[] s10_1 = sc10.nextLine().split(" ");
		
		int[] i10_2 = new int[s10_1.length];
		
		for (int i = 0; i < s10_1.length; i++)
			i10_2[i] = Integer.parseInt(s10_1[i]);
		
		if (i10_2[0] >= i10_2[1])
			System.out.println(i10_2[0] - i10_2[1] + "\r");
		else
			System.out.println(i10_2[1] - i10_2[0] + "\r");

		// 선택 제어문 - 형성평가 2.
		// 정수를 입력받아 0이면 zero, 양수이면 plus, 음수이면 minus라고 출력하여라.
		
		System.out.print("선택제어문-형성평가2\r1개의 정수를 입력하여라. ");
		
		Scanner sc11 = new Scanner(System.in);
		
		int i11_1 = sc11.nextInt();
		
		if (i11_1 == 0)
			System.out.println("zero\r");
		else if (i11_1 > 0)
			System.out.println("plus\r");
		else
			System.out.println("minus\r");

		// 선택 제어문 - 형성평가 3.
		// 년도를 입력받아 윤년인지 평년인지 판단하는 프로그램을 작성하여라.
		// +윤년은 4년에 한번씩 있으며, 그 중에 100으로 나누어 떨어지는 해는 평년이라 한다.
		// 다만 400으로 나누어 떨어지는 해는 다시 윤년이다.
		
		System.out.print("선택제어문-형성평가3.\r년도를 입력하여라. ");
		
		Scanner sc12 = new Scanner(System.in);
		
		int i12_1 = sc12.nextInt();
		
		if (i12_1 % 4 != 0) {
			System.out.println("common year\r");
		} else if (i12_1 % 400 == 0) {
			System.out.println("leap year\r");
		} else if (i12_1 % 4 == 0 && i12_1 % 100 == 0) {
			System.out.println("common year\r");
		} else if (i12_1 % 4 == 0) {
			System.out.println("leap year\r");
		}

		// 선택 제어문 - 형성평가 4.
		// 1번은 개, 2번은 고양이, 3번은 병아리로 정하고 번호를 입력하면
		// 번호에 해당하는 동물을 출력하고, 없으면 I don't know를 출력하여라.
		
		System.out.println("선택제어문-형성평가4.\r1번 : 개, 2번 : 고양이, 3번 : 병아리");
		
		Scanner sc13 = new Scanner(System.in);
		
		int i13_1 = sc13.nextInt();
		
		if (i13_1 == 1)
			System.out.println("dog\r");
		else if (i13_1 == 2)
			System.out.println("cat\r");
		else if (i13_1 == 3)
			System.out.println("chick\r");
		else
			System.out.println("I don't know\r");

		// 선택 제어문 - 형성평가 5.
		// 1~12 사이의 정수를 입력받아 해당 월의 날수를 출력하는 프로그램을 만들어라.
		// 평년이라 생각하고 만들어라.
		
		System.out.print("선택제어문-형성평가5.\r월을 입력하여라. ");
		
		Scanner sc14 = new Scanner(System.in);
		
		int i14_1 = sc14.nextInt();
		
		switch (i14_1) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 11:
			System.out.println("31\r");
			break;
		case 4:
		case 6:
		case 9:
		case 12:
			System.out.println("30\r");
			break;
		case 2:
			System.out.println("28\r");
			break;
		default:
			System.out.println("월을 입력하시오.\r");
		}
	}

}
