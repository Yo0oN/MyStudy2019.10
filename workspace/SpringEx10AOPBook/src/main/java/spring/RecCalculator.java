package spring;

public class RecCalculator implements Calculator {
	// 재귀호출을 이용한 팩토리얼
	@Override
	public long factorial(long num) {
		// TODO Auto-generated method stub
		if (num == 0) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
	}
}
