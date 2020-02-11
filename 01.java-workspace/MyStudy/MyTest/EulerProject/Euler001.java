package EulerProject;

public class Euler001 {

	public static void main(String[] args) {
		// 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면? 233168
		// 1000보다 작은 자연수로 범위 조절 -> 3의배수, 5의배수 뽑기
		int i = 0;
		int result = 0; // 1000보다 작은 자연수
		while (i < 1000) {

			// 자연수가 만약 3또는 5의배수라면
			if (i % 3 == 0 || i % 5 == 0) {
				// 배수인것들 더해주기.
				result += i;
			}
			// i++이 처음에 오게된다면,
			// i=999일 때 while식이 시작되면서 5의 배수인 1000도 더해지게된다.
			i++;
		}
		System.out.println(result);
	}

}
