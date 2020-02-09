package StringEx;

public class FirstUpper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력을 받아들인다.->받은 문자열을 띄어쓰기로 나눠서 문자하나씩 나눈다
		//->배열에 넣는다 -> 첫글자를 대문자로 바꾼다 ->다시합친다.
		for(String arg : args) {
			//받은 이름을 띄어쓰기로 일단 나눈다
			String nameSep = arg;
			String[] nameArray = nameSep.split(" ");
			
			for (int i = 0; i< nameArray.length; i++) {	
			String nameUpper = nameArray[i].toUpperCase();
			System.out.println(nameUpper);
			}
		}
		
	}

}
