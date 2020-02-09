package MyClass;

public class JuminCheckOEx01 {
	public static void main(String[] args) {
		if(args.length !=1 ) {
			System.out.println("java 클래스명 xxxxxx-xxxxxxx 형식으로 입력해 주세요.");
			System.exit(0);
		}
		
		//System.out.println("정상");
		//중간에 -를 빼주기
		String strJumin = args[0].replaceAll("-", "");
		
		//System.out.println(strJumin);
		
		//String str1 = strJumin.substring(0, 1);
		//String str2 = strJumin.substring(1, 2);
		int[] bits = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int sum = 0;
		for(int i=0 ; i<bits.length ; i++) {
			sum += Integer.parseInt(strJumin.substring(i, i+1))+bits[i];
			
		}
		int lastNum = Integer.parseInt(strJumin.substring(12, 13));
		
		int resultNum = (11-(sum%11))%10;
		
		//System.out.println(lastNum);
		//System.out.println(resultNum);
		
		if (lastNum == resultNum) {
			System.out.println("정확");
		} else { System.out.println("부정확"); }
		
	}
}
