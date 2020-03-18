import java.util.Scanner;

// 재귀함수를 이용하여 피보나치 수열을 구하여라
public class Q10870 {

	public static int fibonacci (int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return fibonacci(num - 1) + fibonacci(num -2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(fibonacci(num));
	}

}
