package DateEx;
import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		System.out.println(c.toString());
		
		System.out.println(c.YEAR);
		//Calendar에서는 1월이 0, 12월이 11이다. +1을 해서사용하자.
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DATE));
		
		//Calendar에서는 일요일이 1부터 토요일이 6까지이다.
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		
		//요일을 숫자말고 문자로 표현하자.
		String[] dayArray = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println(dayArray[c.get(Calendar.DAY_OF_WEEK)-1] + "요일");
		
		//이번달 날짜의 최대.최소값, 1년의 달의 최대,최소값
		System.out.println(c.getActualMaximum(Calendar.DATE));
		System.out.println(c.getActualMinimum(Calendar.DATE));
		System.out.println(c.getActualMaximum(Calendar.MONTH)+1);
		System.out.println(c.getActualMinimum(Calendar.MONTH)+1);
	}

}
