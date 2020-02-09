package EulerProject;

public class Euler003 {

	public static void main(String[] args) {
		// 어떤 수를 소수의 곱으로만 나타내는것을 소인수분해라 하고, 이 소수들을 그의 소인수라고 한다.
		// 600851475143의 소인수 중에서 가장 큰 수를 구해라.6857

		long i = 600851475143l;
		for (long l = 2; l < i / 2; l++) {
			if (i % l == 0) {
				i = i / l;
			}
		}

		System.out.println(i);
	}

}
