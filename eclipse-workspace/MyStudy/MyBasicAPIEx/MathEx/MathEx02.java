package MathEx;

public class MathEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//난수 (random/lotto)
		//0 <= double <1
		System.out.println(Math.random());
		System.out.println(Math.random());
		
		//random을 이용하여 0 <= x <10 까지의 정수를 뽑자!
		System.out.println((int)(Math.random() * 10));
		System.out.println((int)(Math.random() * 10));
		
		//로또? 1<= x < 45 -> 0*45+1 <= x < 1*45+1
		System.out.println((int)(Math.random() * 45)+1);
		System.out.println((int)(Math.random() * 45)+1);
		System.out.println((int)(Math.random() * 45)+1);
	}

}
