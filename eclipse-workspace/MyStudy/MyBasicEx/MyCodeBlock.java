class MyCodeBlockTest{
	static {
		System.out.println("hello static block");
	}
	{
		System.out.println("hello instance block");
	}
	public MyCodeBlockTest() {
		System.out.println("hello constructor");
	}
	static void MCBT(){
		System.out.println("hello static method");
	}
	void MTBC() {
		System.out.println("hello instance method");
	}
}
public class MyCodeBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCodeBlockTest mc = new MyCodeBlockTest();
		mc.MTBC();
		MyCodeBlockTest.MCBT();
	}
}
