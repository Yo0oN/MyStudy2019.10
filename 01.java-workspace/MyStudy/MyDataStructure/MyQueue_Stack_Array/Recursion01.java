package MyQueue_Stack_Array;

import java.util.Scanner;

public class Recursion01 {

	public static int myFactorial01(int n) {
		// TODO Auto-generated constructor stub
		if (n > 1) {
			System.out.println(n);
			return n * myFactorial01(n - 1);
		} else {
			//System.out.println(n * myFactorial01(n - 1) + "else");
			return 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("숫자를 입력해주세요. ");
		int n = new Scanner(System.in).nextInt();
		int fac = myFactorial01(n);
		System.out.println(n + "의 팩토리얼은 " + fac + "입니다.");
	}
}
