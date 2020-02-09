package PolyEx01;

public class PolyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		Child c = new Child();
		
		//부모 <- 자식 : 자동형변환 (부모를 통해 자식불러오기)
		Parent p1 = new Child();
		Parent p2 = c;
		
		//부모 -> 자식 : 자식을 통해 만든 부모는 다시 자식으로 돌려줄 수 있다.
		//강제로 형변환 가능하다.
		//Child c1 = new Parent(); - 불가능
		//Child c1 = (Child)p; - 불가능
		Child c1 = (Child)p1;
	}
}
