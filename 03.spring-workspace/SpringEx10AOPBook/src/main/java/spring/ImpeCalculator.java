package spring;

public class ImpeCalculator implements Calculator {
	// 반복문을 이용한 팩토리얼
	@Override
	public long factorial(long num) {
		long result = 1;
		
		// result에 1부터 num까지 곱한값이 들어간다. = num!
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		
		return result;
	}
}
