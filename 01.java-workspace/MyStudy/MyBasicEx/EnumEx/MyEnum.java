package EnumEx;

public class MyEnum {
enum Fruit {사과, 배, 딸기, 수박, 망고}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyEnum01 e1 = MyEnum01.일;
		System.out.println(e1);
		System.out.println(e1 instanceof Enum);
		
		Fruit f1 = MyEnum.Fruit.배;
		System.out.println(f1);
		
	}
	enum Company{애플, 구글, 네이버}

}
