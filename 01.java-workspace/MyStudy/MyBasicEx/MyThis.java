class MyThisTest{
	int i = 0;
	static int j = 8;
	String h = "hello";
	String k = "java";
	MyThisTest() {
		//this(5);
		
		System.out.println("Hello, constructor");
	}
	MyThisTest(int i){
		this.i = i;
		int j = 9;
		System.out.println("Hello, constructor and i");
		System.out.println(j);
		System.out.println(this.j);
		System.out.println(MyThisTest.j);
	}
	MyThisTest(String s){
		this(5);
	}
	int Hello(){
		//this("g");
		System.out.println("Hello");
		int i =8;
		this.i = i;
		int j = 9;
		this.j=j;
		System.out.println(i);
		System.out.println(j);
		return 3;
	}
}
public class MyThis {

	public static void main(String[] args) {
		MyThisTest mtt = new MyThisTest(2);
		mtt.Hello();
	}

}
