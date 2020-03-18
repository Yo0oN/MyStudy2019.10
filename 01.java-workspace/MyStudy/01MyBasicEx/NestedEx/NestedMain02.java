package NestedEx;

public class NestedMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterEx02.Inner oi = new OuterEx02.Inner(); //inner에 static이 붙어 이렇게 사용 가능.
		//System.out.println(oi.y1);	private이기 때문
		System.out.println(oi.y2);
	}

}
