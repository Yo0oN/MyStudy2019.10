package MyQueue_Stack_Array;

public class Recursion02 {

	static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return gcd(y, x % y);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 150;
		int y = 80;
		int gcd = gcd(x, y);
		System.out.println(gcd);
	}
}
