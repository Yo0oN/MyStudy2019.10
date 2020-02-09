package EnumEx;

public class EnumMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//values : Tea enum이 가진 모든 상수값을 배열형태로 리턴받는다.
		Tea[] teaArray = Tea.values();
		for (Tea tea : teaArray) {
			System.out.println(tea.name());
			System.out.println(tea.ordinal());
			
			
			Tea reTea = Tea.valueOf(tea.name());
			System.out.println(reTea.equals(tea));
		}
	}
}
