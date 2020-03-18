package DateEx;
import java.util.Date;

public class DateEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Date d = new Date();
		
		//2019-12-15	12-1:12월 25:25번째
		Date d = new Date(2019-1900, 12-1, 25);
		System.out.println(d.toLocaleString());
		System.out.println(d.getDay());
		
		//2019-2-마지막날	월에서 0은 1월이다. 일에서 1은 1일이다. 3-1=2 : 3월, 0:1번의 전()
		d = new Date(2019-1900, 2, 0);
		System.out.println(d.toLocaleString());
	}

}
