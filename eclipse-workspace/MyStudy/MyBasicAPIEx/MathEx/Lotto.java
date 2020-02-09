package MathEx;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자 6개씩 5줄이 나오는 식을 만들어보자
		//숫자6개 먼저 뽑아보자
		for (int j=1; j <=5 ; j++) {
			for (int i =1; i<=6 ; i++) {
				int k = (int)((Math.random()*45)+1);
				System.out.printf("%d\t", k);
			}
			System.out.println();
		}
	}

}
