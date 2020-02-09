package StringEx;

public class FirstUpperA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력을 받아들인다.->받은 문자열을 띄어쓰기로 나눠서 문자하나씩 나눈다
		//->단어의 인덱스가 0번인 것을 대문자화한다.
		
		if(args.length != 1) {
			System.out.println("\"\" 안에 이름 하나를 입력하셔야 합니다.");
		} else {
			//입력된 이름을 받음
			//System.out.println(args[0]);
			//입력된 이름을 띄어쓰기를 기준으로 분리하여 단어 하나씩 names 변수에 넣었음
			String[] names = args[0].split(" ");
			
			String result = "";
			//나눈이름을 단어 하나씩 나열함
			for(String name : names) {
				//substring을 이용하여 0번째인덱스,단어의 제일 첫글자만 잘라온 후 대문자로 만듬
				//substring을 다시 이용하여 이름의 뒷부분부터 다시 잘라온 후 첫글자와 다시 합침
				//System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1) + " ");
				result += name.substring(0, 1).toUpperCase() + name.substring(1) + " ";
			}
			//출력
			System.out.println(result);
		}
	}
}
