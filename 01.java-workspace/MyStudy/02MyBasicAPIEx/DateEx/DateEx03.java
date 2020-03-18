package DateEx;
import java.util.Date;

public class DateEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date() ;
		System.out.println(d.toLocaleString());
		//time stamp
		System.out.println(d.getTime());
		//getTime과 비슷하게 System 클래스에는 currentTimeMillis메서드가
		//밀리초를 뽑아준다.
		System.out.println(System.currentTimeMillis());
		
		d = new Date(System.currentTimeMillis());
		System.out.println(d.toLocaleString());
		Date d2 = new Date(d.getTime());
		System.out.println(d);
		System.out.println(d2.toLocaleString());
		System.out.println(d2.getMonth());
	}

}
