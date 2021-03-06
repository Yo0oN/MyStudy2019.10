package StringEx;

public class StringEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello World";
		System.out.println(str1.length());
		//변수에 넣지 않고 직접 써도 나온다.
		System.out.println("Hello World".length());
		
		//문자열 => 문자(char)
		char ch1 = str1.charAt(0);
		System.out.println(ch1);
		char ch2 = str1.charAt(str1.length() - 1);
		System.out.println(ch2);
		
		//문자열 => 문자열
		String pstr1 = str1.substring(2);
		System.out.println(pstr1);
		String pstr2 = str1.substring(2,4);
		System.out.println(pstr2);
		
		//문자열 검색(어느위치에 있을까?)	indexof(앞부터 찾기) / lastIndexof(뒤부터 찾기) ctrl+f의 기능..
		int idx1 = str1.indexOf("ll");
		System.out.println(idx1);
		int idx2 = str1.indexOf("o", 5);
		System.out.println(idx2);
		//찾는 문자열이 없으면? -1출력	
		int idx3 = str1.indexOf("k", 5);
		System.out.println(idx3);
		
		//문자열의 존재?정말 그문자열이 있는가?(true/false) ->대소문자를 구분하여 찾아준다.
		//startsWith(~로 시작하는가?) endsWith(~로 끝나는가?) contains(~를 포함하고있는가?)
		boolean b1 = str1.contains("He");
		System.out.println(b1);
		
		//문자열 치환 -> 대소문자를 구분한다. 바꾸려는 값이 없으면 원래의 문자 그대로 출력한다.
		String rStr = str1.replaceAll("World", "세상");
		System.out.println(rStr);
		
		//문자열의 결합(+)
		String jStr1 = str1+ "안녕";
		System.out.println(jStr1);
		String jStr2 = str1.concat("안녕");
		System.out.println(jStr2);
		
		//대소문자의 변환
		String uStr = "hello".toUpperCase();
		System.out.println(uStr);
		String lStr = "HELLO".toLowerCase();
		System.out.println(lStr);
		
		//공백 제거(문장 앞뒤로 있는 공백만 제거)
		String oStr1 = "            Hello World       ";
		String oStr2 = oStr1.trim();
		System.out.println(oStr1);
		System.out.println(oStr2);
		System.out.println("    o    ".trim());
		
		//구분자 단위로 문자열 분리
		String str4 = "apple,banana,pineapple,kiwi";
		String[] strArray = str4.split(",");
		System.out.println(str4.split(","));
		for(String str : strArray ) {
			System.out.println(str);
		}
		//문자열 결함
		String fStr1 = String.join("apple", "banana", "pineapple", "kiwe");
		System.out.println(fStr1);
		String fStr2 = String.join(":", strArray);
		System.out.println(fStr2);
		//format(printf처럼 쓰는듯?)
		String fstr2 = String.format("%s,%s,%s", strArray[0], strArray[1], strArray[2]);
		System.out.println(fstr2);
		
		String tStr1 = new String("Hello");
		String tStr2 = new String("Hello");
		
		if (tStr1 == tStr2) {
			System.out.println("같다");
		} else {
			System.out.println("참조주소가 다르다");
		}
		
		if (tStr1.equals(tStr2)) {
			System.out.println("데이터가 같다같다");
		} else {
			System.out.println("데이터가 다르다");
		}
	}
}
