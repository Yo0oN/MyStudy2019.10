package DateEx;
import java.util.Date;

public class MyDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.toString());
		
		System.out.println(date.getYear()+1900);
		System.out.println(date.getMonth());
		System.out.println(date.getDate());
		System.out.println(date.getDay());
		System.out.println(date.getHours());
		System.out.println(date.getMinutes());
		System.out.println(date.getSeconds());
		
		Date date2 = new Date(2019-1900,10,14);
		System.out.println(date2);
		
		
	}

}
