package EnumEx;

public class MyEnum {
	enum Fruit {
		사과, 배, 딸기, 수박, 망고
	}

	enum Company {
		애플, 구글, 네이버
	}
	enum Al {
		A, B, C, F, E, D
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyEnum01 e1 = MyEnum01.일;
		System.out.println(e1);
		System.out.println(e1 instanceof Enum);

		Fruit f1 = MyEnum.Fruit.배;
		System.out.println(f1);

		Fruit fruit = Fruit.딸기;
		System.out.println(Fruit.딸기 == fruit);
		System.out.println(fruit.compareTo(Fruit.배));
		System.out.println(fruit.compareTo(Fruit.망고));
		System.out.println(fruit.compareTo(Fruit.딸기));
		System.out.println(fruit.valueOf("수박"));
		
		System.out.println("=============");
		Al al = Al.F;
		System.out.println(al.compareTo(Al.A));
		System.out.println(al.compareTo(Al.E));
		
		Fruit[] fruit2 = Fruit.values();
		for (Fruit f : fruit2) {
			System.out.println("상수 : " + f.name() + ", 순서 : " + f.ordinal());
		}
		
	}
}
