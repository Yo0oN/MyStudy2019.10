package MyJungol;

import java.util.Scanner;

public class Jungol03Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//연산자 자가진단 1
		//세 개의 정수를 입력받아 합계와 평균을 출력하시오.(소수 이하를 버리고 정수부분만 출력)
		System.out.println("연산자 자가진단1 : 세 개의 정수를 입력하세요.");
		Scanner sc1 = new Scanner(System.in);
		String s1_1 = "1";
		s1_1= sc1.nextLine();
		String[] i1_1 = s1_1.split(" ");
		int i1_2 = Integer.valueOf(i1_1[0]);
		int i1_3 = Integer.valueOf(i1_1[1]);
		int i1_4 = Integer.valueOf(i1_1[2]);
		
		System.out.printf("sum : %d%navg : %d%n%n",
				(i1_2+i1_3+i1_4), (i1_2+i1_3+i1_4)/3);

		//연산자 자가진단2
		//정수 2개를 입력받아서 첫 번째 수에는 100을 증가시키고, 두번째 수는 10으로 나눈 나머지를 저장하고 출력하시오.
		Scanner sc2 = new Scanner(System.in);
		System.out.println("연산자 자가진단2 : 두 개의 정수를 입력하세요.");
		String s2 = sc2.nextLine();
		String[] i2_1 = s2.split(" ");
		System.out.println(Integer.valueOf(i2_1[0])+100 
				+ " "+Integer.valueOf(i2_1[1])%10 +"\r");

		//연산자 자가진단3
		//한 개의 정수를 입력 받아서 후치 증가 연산자를 사용하여 출력, 전치 증가 연산자를 사용하여 출력하시오.
		Scanner sc3 = new Scanner(System.in);
		System.out.println("연산자 자가진단3 : 한 개의 정수를 입력하세요.");
		int i3_1 = sc3.nextInt();
		System.out.println(i3_1++ + "\r" + ++i3_1 +"\r");

		//연산자 자가진단4
		//두 개의 정수를 입력받아 후치증가, 전치감소 연산자를 각각 한 후 두 수의 곱을 구하시오.
		System.out.println("연산자 자가진단4 : 두 개의 정수를 입력하세요.");
		Scanner sc4 = new Scanner(System.in);
		String s4_1 = "1";
		s4_1= sc4.nextLine();
		String[] s4_2 = s4_1.split(" ");
		int[] i4_3 = new int[s4_2.length];
		for(int i = 0; i< s4_2.length; i++) i4_3[i] = Integer.valueOf(s4_2[i]);
		int i4_4 = (i4_3[0]++)*(--i4_3[1]);
		System.out.println(i4_3[0] + " " + i4_3[1] + " " + i4_4 +"\r");

		//연산자 자가진단5
		//두 개의 정수를 입력받아 첫줄에는 정수의 값이 같으면 true, 다르면 false를 출력하시오.
		System.out.println("연산자 자가진단5 : 두개의 정수를 입력하세요");
		Scanner sc5 = new Scanner(System.in);
		String s5_1 = sc5.nextLine();
		String[] s5_2 = s5_1.split(" ");
		int[] i5_3 = new int[s5_2.length];
		for(int i = 0; i< s5_2.length; i++) i5_3[i] = Integer.valueOf(s5_2[i]);
		System.out.println((i5_3[0] == i5_3[1]) + "\r");
		sc5.close();

		//연산자 자가진단6
		//두 개의 정수를 입력받아 4가지 관계연산자의 결과를 출력하시오.
		System.out.println("연산자 자가진단6 : 두개의 정수를 입력하세요");
		Scanner sc6 = new Scanner(System.in);
		String s6_1 = sc6.nextLine();
		String[] s6_2 = s6_1.split(" ");
		int[] i6_3 = new int[s6_2.length];
		for(int i = 0; i < s6_2.length ; i++) i6_3[i] = Integer.valueOf(s6_2[i]);
		System.out.printf("%d > %d --- %b%n%d < %d --- %b%n%d >= %d --- %b%n%d <= %d --- %b%n%n",
				i6_3[0], i6_3[1], i6_3[0]>i6_3[1], i6_3[0], i6_3[1], i6_3[0] < i6_3[1],
				i6_3[0], i6_3[1], i6_3[0] >= i6_3[1], i6_3[0], i6_3[1], i6_3[0] <= i6_3[1]);

		//연산자 자가진단7.
		//2개의 정수를 입력받아 0이 아니면 참, 0이면 거짓으로 처리하고,
		//두값의 논리곱과 논리합의 결과를 출력하는 프로그램을 작성하시오.
		System.out.println("연산자 자가진단7 : 두개의 정수를 입력하세요");
		Scanner sc7 = new Scanner(System.in);
		String s7_1 = sc7.nextLine();
		String[] s7_2 = s7_1.split(" ");
		int[] i7_3 = new int[s7_2.length];
		for (int i = 0 ; i < s7_2.length ; i++) i7_3[i] = Integer.valueOf(s7_2[i]);
		System.out.printf("%b %b%n%n", i7_3[0] == 0, i7_3[1] == 0);

		//연산자 자가진단8.
		//3개의 정수를 입력받아 첫번째 수가 가장 크거나,세개의수가 모두같으면 true, 아닌경우 false를 출력해라.
		System.out.println("연산자 자가진단8 : 세개의 정수를 입력하세요");
		Scanner sc8 = new Scanner(System.in);
		String s8_1 = sc8.nextLine();
		String[] s8_2 = s8_1.split(" ");
		int[] i8_3 = new int[s8_2.length];
		for (int i = 0 ; i < s8_2.length ; i++) i8_3[i] = Integer.valueOf(s8_2[i]);
		System.out.printf("%b %b%n%n", i8_3[0] > i8_3[1] && i8_3[0] > i8_3[2],
				i8_3[0] == i8_3[1] && i8_3[1]==i8_3[2]);

		//연산자 형성평가1.
		//국어 영어 수학 컴퓨터 과목의 점수를 정수로 입력받아 총점과 평균을 구하여라.(소수점 이하는 버린다.)
		System.out.println("연산자 형성평가1 : 네 개의 정수를 입력하시오.");
		Scanner sc9 = new Scanner(System.in);
		String[] s9_1 = sc9.nextLine().split(" ");
		int[] i9_2 = new int[s9_1.length];
		for(int i =0 ; i < s9_1.length ; i++) i9_2[i] = Integer.parseInt(s9_1[i]);
		System.out.println("sum " + (i9_2[0]+i9_2[1]+i9_2[2]+i9_2[3]) 
				+ "\ravg " + (i9_2[0]+i9_2[1]+i9_2[2]+i9_2[3])/3 +"\r");

		//연산자 형성평가2.
		//두 정수를 입력받아 나눈 몫과 나머지를 형식에 맞춰 출력하여라.
		System.out.println("연산자 형성평가 2 : 두개의 정수를 입력하시오.");
		Scanner sc10 = new Scanner(System.in);
		String[] s10_1 = sc10.nextLine().split(" ");
		int[] i10_2 = new int[s10_1.length];
		for(int i = 0; i < s10_1.length ; i++) i10_2[i] = Integer.parseInt(s10_1[i]);
		System.out.printf("%d / %d = %d...%d%n%n",
				i10_2[0], i10_2[1], i10_2[0]/i10_2[1], i10_2[0]%i10_2[1]);

		//연선자 형성평가3.
		//직사각형의 가로와 세로의 길이를 정수형 값으로 입력받은 후 
		//가로의 길이는 5 증가, 세로의 길이는 2배하여 가로,세로, 넓이를구하여라.
		System.out.println("연산자 형성평가 3번 : 두 개의 정수를 입력하시오.(가로,세로순)");
		Scanner sc11 = new Scanner(System.in);
		String[] s11_1 = sc11.nextLine().split(" ");
		int[] i11_2 = new int[s11_1.length];
		i11_2[0] = (Integer.parseInt(s11_1[0]))+5;
		i11_2[1] = (Integer.parseInt(s11_1[1]))*2;
		System.out.printf("width = %d%nlength = %d%narea = %d%n%n",
				i11_2[0], i11_2[1], i11_2[0]*i11_2[1]);		

		//연산자 형성평가4.
		//두 정수를 입력받아 각각 정치증가,후치감소 연산자를 사용 후, 출력하고, 다시 바뀐값을 출력하여라.
		System.out.println("연산자 형성평가 4번 : 두 개의 정수를 입력하시오.");
		Scanner sc12 = new Scanner(System.in);
		String[] s12_1 = sc12.nextLine().split(" ");
		int[] i12_2 = new int[s12_1.length];
		for(int i = 0 ; i < s12_1.length ; i++) i12_2[i] = Integer.parseInt(s12_1[i]);
		System.out.println(++i12_2[0] + " " + i12_2[1]-- + "\n" + i12_2[0] + " " + i12_2[1] + "\n");

		//연산자 형성평가5.
		//두 사람의 키와 몸무게를 차례로 입력받아, 첫번쨰 사람이 키도,몸무게도 크면 true, 아니면 false를 출력하여라.
		System.out.print("연산자 형성평가 5번\n1번의 키와 몸무게를 입력하시오.");
		Scanner sc13 = new Scanner(System.in);
		String[] s13_1 = sc13.nextLine().split(" ");
		System.out.print("2번의 키와 몸무게를 입력하시오.");
		String[] s13_2 = sc13.nextLine().split(" ");
		int[] i13_3 = new int[s13_1.length];
		int[] i13_4 = new int[s13_2.length];
		for (int i=0; i< s13_1.length;i++) {
			i13_3[i] = Integer.parseInt(s13_1[i]);
			i13_4[i] = Integer.parseInt(s13_2[i]);
		}
		System.out.println(i13_3[0] > i13_4[0] && i13_3[1] > i13_4[1]);
	}
}
