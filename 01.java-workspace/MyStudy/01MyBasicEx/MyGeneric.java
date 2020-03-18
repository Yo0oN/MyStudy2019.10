
class Generic01<String>{
	String i1;
}

class Generic02<Integer>{
	int i1;
}

class Generic03<T>{
	T t1;
	int i1;
	String s1;
}

public class MyGeneric {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generic01<String> g01 = new Generic01<String>();
		Generic02 g02 = new Generic02();	//자동형변환되었음
		Generic03<String> g03 = new Generic03<String>();
		//g03.t1 = 5;
		g03.i1 = 5;
		g03.t1 = "String타입입니다.";
		
	}
}
