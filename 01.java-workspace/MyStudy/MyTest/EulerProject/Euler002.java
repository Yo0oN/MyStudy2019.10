package EulerProject;

public class Euler002 {

	public static void main(String[] args) {
		// 피보나치 수열에서 4백만 이하이면서 짝수인 항의 합 4613732
		// 피보나치 수열 먼저 만들기 -> 짝수인값 빼기 -> 4백만아래로 범위 제한하기 -> 더하기

		// 더하는값이랑 받는값을 따로설정해보자,,?
		int resulti = 0;
		int resultj = 0;
		// 피보나치수열
		for (int i = 1, j = 2; i <= 4000000 || j <= 4000000; i = i + j, j = i + j) {
			// System.out.print(i + " " + j +" ");
			// 짝수만 뽑아보자
			if (i % 2 == 0) {
				resulti += i;
			}
			if (j % 2 == 0) {
				resultj += j;
			}
		}
		System.out.println(resulti + resultj);
	}

}
