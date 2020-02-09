package NestedEx;

public class OuterEx02 {
	private int x1 = 100;
	public int x2 = 100;
	
	//static이 붙으면 다른것들보다 먼저 생성이된다.
	//그렇기때문에 아직 만들어지지않은 x1과 x2를 포함하고있으면 에러가뜨는것.
	
	static class Inner {
		private int y1 = 200;
		public int y2 = 200;
		
		public void viewInner() {
			//System.out.println(x1);
			//System.out.println(x2);
			System.out.println(y1);
			System.out.println(y2);
		}
	}
}
