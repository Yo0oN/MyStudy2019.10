package DateEx;
import java.util.Date;
import java.util.Calendar;

public class CalendarEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		
		c.set(2019, 12-1, 1);
		System.out.println(c.get(Calendar.YEAR));
		//0이 1월임.(12월은 11) 그래서 1-1=0이므로 1월을 뜻하고,
		//1-1=0이므로 1일의 전인 전달 마지막날 뜻한다.
		c.set(2020, 1-1, 1-1);
		Date d = c.getTime();
		System.out.println(d.toLocaleString());
	}

}
