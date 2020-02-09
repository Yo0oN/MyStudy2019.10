package MyJungol;

import java.util.Scanner;

public class Jungol02Input {

	public static void main(String[] args) {
		// 입력2,3,4,5는 Scanner를 2개 이용하여 추가로 해보자.
		// 입력-자가진단1
		// 정수형 변수를 선언하고 -100을 대입하여 출력하는 프로그램을 작성하여라.

		System.out.println("1번.");

		int i1 = -100;

		System.out.println(i1 + "\r");

		// 입력-자가진단2
		// 정수형 변수 2개를 선언하여 -1, 100을 대입한 후 출력하여라.

		System.out.println("2번.");

		int i2_1 = -1;
		int i2_2 = 100;

		System.out.println(i2_1 + "\r" + i2_2 + "\r");

		System.out.println("2번. + ");

		Scanner scp2_1 = new Scanner(System.in);

		System.out.print("하나의 정수를 입력하시오. ");

		int ip2_1 = scp2_1.nextInt();

		Scanner scp2_2 = new Scanner(System.in);

		System.out.print("다른 하나의 정수를 입력하시오. ");

		int ip2_2 = scp2_2.nextInt();

		System.out.println(ip2_1 + "\r" + ip2_2 + "\r");

		// 입력-자가진단3
		// 두개의 정수형 변수를 선언하고 값을 대입하여 아래와 같이 출력되는 프로그램을 작성하여라.

		System.out.println("3번.");

		int i3_1 = 55;
		int i3_2 = 10;
		int i3_3 = 2008;
		int i3_4 = 1999;

		System.out.println(i3_1 + " - " + i3_2 + " = " + (i3_1 - i3_2) + "\r" + i3_3 + " - " + i3_4 + " = "
				+ (i3_3 - i3_4) + "\r");

		System.out.println("3번. + ");

		Scanner scp3_1 = new Scanner(System.in);

		System.out.print("하나의 정수를 입력하시오. ");

		int ip3_1 = scp3_1.nextInt();

		Scanner scp3_2 = new Scanner(System.in);

		System.out.print("다른 하나의 정수를 입력하시오. ");

		int ip3_2 = scp3_2.nextInt();

		System.out.println(ip3_1 + " - " + ip3_2 + " = " + (ip3_1 - ip3_2) + "\r");

		// 입력-자가진단4
		// 추의무게=49, 중력의 비율 = 0.2683을 변수에 저장하고, 곱셈 계산식을 출력하여라.

		System.out.println("4번.");

		int i4_1 = 49;
		double i4_2 = 0.2683;

		System.out.printf("%d * %f = %f%n%n", i4_1, i4_2, (i4_1 * i4_2));

		// 입력-자가진단5
		// 2.1야드와 10.5인치를 각각 cm로 변환하여 소수 첫째짜리까지 출력하여라.

		System.out.println("5번.");

		double i5_1 = 91.44;
		double i5_2 = 2.54;

		System.out.printf("%4.1fyd = %5.1fcm%n%4.1fin = %5.1fcm%n%n", 2.1, (2.1 * i5_1), 10.5, (10.5 * i5_2));

		System.out.println("5번. + ");

		Scanner scp5_1 = new Scanner(System.in);

		System.out.print("yd? ");

		double ip5_1 = scp5_1.nextDouble();

		Scanner scp5_2 = new Scanner(System.in);

		System.out.println("inch? ");

		double ip5_2 = scp5_2.nextDouble();

		System.out.printf("%4.1fyd = %5.1fcm%n%4.1fin = %5.1fcm%n%n", ip5_1, (ip5_1 * 91.44), ip5_2, (ip5_2 * 2.54));

		// 입력-자가진단6
		// 키를 입력받아 출력하여라.

		System.out.print("6번 : 키를 입력하세요.\rheight = ");

		Scanner sc6 = new Scanner(System.in);

		String i6_1 = sc6.nextLine();

		System.out.println("Your height is " + i6_1 + "cm\r");

		// 입력-자가진단7
		// 두개의 정수를 입력 받아, 곱과 몫을 출력하시오.

		System.out.println("7번 : 두 개의 정수를 입력하세요.");

		Scanner sc7 = new Scanner(System.in);

		String i7_1 = sc7.nextLine();

		String[] i7_2 = i7_1.split(" ");

		System.out.println(i7_2[0] + " * " + i7_2[1] + " = " + Integer.parseInt(i7_2[0]) * Integer.parseInt(i7_2[1])
				+ "\r" + i7_2[0] + " / " + i7_2[1] + " = " + Integer.parseInt(i7_2[0]) / Integer.parseInt(i7_2[1])
				+ "\r");

		// 입력-자가진단8
		// 실수 2개와 문자 한개를 입력받아 출력하되 소수 둘째짜리까지 반올림하여 출력하시오

		System.out.print("8번 : 실수 한 개를 입력하시오.");

		Scanner sc8 = new Scanner(System.in);

		double i8_1 = sc8.nextDouble();

		System.out.println((double) Math.round(i8_1 * 100) / 100);

		System.out.print("실수 한 개를 입력하시오. : ");

		double i8_2 = sc8.nextDouble();

		System.out.println((double) Math.round(i8_2 * 100) / 100);

		System.out.print("문자 한 개를 입력하시오. : ");

		String i8_3 = sc8.next();

		System.out.println(i8_3);

		// 입력-자가진단 9
		// 세 개의 실수를 입력받아 반올림하여 소수 셋째 자리까지 출력하시오.

		System.out.print("9번 : 실수 한 개를 입력하시오.");

		Scanner sc9 = new Scanner(System.in);

		Double i9_1 = sc9.nextDouble();

		System.out.println((double) Math.round(i9_1 * 1000) / 1000);

		System.out.print("실수 한 개를 입력하시오. : ");

		Double i9_2 = sc9.nextDouble();

		System.out.println((double) Math.round(i9_2 * 1000) / 1000);

		System.out.print("실수 한 개를 입력하시오. : ");

		Double i9_3 = sc9.nextDouble();

		System.out.println((double) Math.round(i9_3 * 1000) / 1000 + "\r");

		// 입력-형성평가 1
		// 세 개의 정수형 변수를 선언하고 각 변수에 10 20 30 을 대입한 후 형식에 맞춰 출력하여라.

		System.out.println("형성평가1번");

		int i10_1 = 10;

		int i10_2 = 20;

		int i10_3 = 30;

		System.out.println(i10_1 + " + " + i10_2 + " = " + i10_3 + "\r");

		// 입력-형성평가2
		// 실수형 변수 2개를 선언 후 값을 대입하여, 두 수의 합을 구하여 형식에 맞춰 출력하여라.

		System.out.println("형성평가2번");

		double i11_1 = 80.5;

		double i11_2 = 22.34;

		System.out.printf("%10.2f%10.2f%10.2f%n%n", i11_1, i11_2, (i11_1 + i11_2));

		// 입력-형성평가3
		// 정수형 변수와 실수형 변수 한 개씩을 선언하여 형식에 맞춰 출력하여라.
		System.out.println("형성평가3번");

		int i12_1 = 50;

		Double i12_2 = 100.12;

		System.out.println(i12_2 + " * " + i12_1 + " = " + Math.round(i12_1 * i12_2) + "\r");

		// 입력-형성평가4
		// 세 개의 정수를 입력받아 합과 평균을 출력하여라.(소수 이하는 버린다.)

		System.out.println("형성평가4번 : 세 개의 정수를 입력하시오.");

		Scanner sc1_4 = new Scanner(System.in);

		String[] s13_1 = sc1_4.nextLine().split(" ");

		System.out.printf("sum = %d%navg = %d%n%n",
				(Integer.parseInt(s13_1[0]) + Integer.parseInt(s13_1[1]) + Integer.parseInt(s13_1[2])),
				(Integer.parseInt(s13_1[0]) + Integer.parseInt(s13_1[1]) + Integer.parseInt(s13_1[2])) / 3);

		// 입력 형성평가5
		// 야드를 입력받아 cm로 환산하여 소수 둘째자리에서 반올림하여 출력하여라.

		System.out.println("형성평가5번 : 수를 입력하시오");
		
		Scanner sc1_5 = new Scanner(System.in);
		
		System.out.print("yard? ");
		
		double i14_1 = sc1_5.nextDouble();
		
		System.out.printf("%.1fyard = %.1fcm", i14_1, (double) Math.round((91.44 * i14_1) * 10) / 10);
	}
	
}
