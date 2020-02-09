package PolyEx03;

public class PolyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employee e = new Employee();	->추상클래스라 바로 못부른다.
		//다형성
		Employee e = new Worker(); //자식을 통해 부모 호출
		e.salary();				//호출해서 써먹기
		
		System.out.println(e instanceof Employee);
		System.out.println(e instanceof Worker);
		
		e = new Executive();	//호출한것을 다시 다른자식과 연결
		e.salary();
		
		System.out.println(e instanceof Employee);
		System.out.println(e instanceof Executive);
		
		System.out.println(e instanceof Worker);	
		
		System.out.println(e instanceof Object);
	}
}
