package EnumEx;

public class EnumMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grade grade = Grade.SALES;
				
		System.out.println(grade);
		
		System.out.println(grade instanceof Enum);
		System.out.println(grade instanceof Object);
	}

}
