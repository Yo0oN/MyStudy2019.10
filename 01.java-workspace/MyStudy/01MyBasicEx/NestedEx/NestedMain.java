package NestedEx;

public class NestedMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterEx01 oe= new OuterEx01();
		//System.out.println(oe.x1); private이기 때문
		System.out.println(oe.x2);
		
		OuterEx01.Inner oi = oe.new Inner();
		//OuterEx01.Inner oii = new OuterEx01.Inner(); Inner에 static이 없어 이렇게는 못한다.
		//System.out.println(oi.y1); private이기 때문
		System.out.println(oi.y2);
		
		oi.viewInner();
	}

}
