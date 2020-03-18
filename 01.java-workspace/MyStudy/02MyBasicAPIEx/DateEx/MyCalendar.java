package DateEx;
import java.util.Calendar;

public class MyCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
//		System.out.println(c.);
		//System.out.println(c.toString());
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));	
		

		System.out.println(c.getActualMaximum(Calendar.DATE));
		System.out.println(c.getActualMinimum(Calendar.DATE));
		System.out.println(c.getActualMaximum(Calendar.MONTH)+1);
		System.out.println(c.getActualMinimum(Calendar.MONTH)+1);
		System.out.println(c.getActualMaximum(Calendar.YEAR));
		System.out.println(c.getActualMinimum(Calendar.YEAR));
		System.out.println(c.getActualMaximum(Calendar.HOUR));
		System.out.println(c.getActualMinimum(Calendar.HOUR));
		c.set(2018, 2, 1);
		System.out.println(c.get(Calendar.YEAR));
	}

}
