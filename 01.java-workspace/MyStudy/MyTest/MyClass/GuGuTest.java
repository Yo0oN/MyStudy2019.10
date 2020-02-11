package MyClass;

public class GuGuTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int start = 3;
		int end = 6;
		int startdan = start;
		// 구구단의 열은 10개의고, 행은 끝단-시작단+1 개이다.
		String[][] gugudan = new String[end-start+1][10];;
		
		for (int i = 0; i < (end-start+1); i++) {
			// 첫번째 열에는 몇단인지를 알려주는값을 넣고,
			gugudan[i][0] = (startdan + "단");
			
			// 두번째 열부터는 값을 넣어준다.
			for (int j = 1; j<10; j++) {
				gugudan[i][j] = (start * j + "");
			}
			startdan++;
			System.out.println(i+1+"번");
		}
		
		for (int i = 0; i < gugudan.length; i++) {
			for (int j = 0; j< gugudan[i].length; j++) {
				System.out.print(gugudan[i][j]);
			}
			System.out.println("단");
		}
	}

}
