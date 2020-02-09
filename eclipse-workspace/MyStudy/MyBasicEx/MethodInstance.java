
public class MethodInstance {
	static int a = 10;
	int b = 15;
	static int c = 20;
	int d = 25;
	
	void ab1() {
		System.out.println(a+b);
	}
	static void ab2() {
		//System.out.println(a+b); b가 인스턴스변수기 때문에 접근 불가능
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MethodInstance.ab1();	//인스턴스 메소드라 그냥 사용 불가능
		MethodInstance.ab2();
		System.out.println(MethodInstance.a);
		//System.out.println(MethodInstance.b); 인스턴스 변수라 그냥 사용 불가능
		MethodInstance mi = new MethodInstance();
		mi.ab1();
		mi.ab2();
		System.out.println(mi.a);
		System.out.println(mi.b);
	}

}
