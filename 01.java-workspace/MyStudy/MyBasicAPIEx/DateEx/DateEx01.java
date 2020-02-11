package DateEx;
import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//현재 날짜와 시간이 저장된 클래스
		Date d = new Date();
		
		//toString을 쓰면 참조주소값이 나와야하는데 날짜가 그대로나왔다.
		//저절로 오버라이딩되었다는뜻..?
		System.out.println(d);
		//Object의 toString을 오버라이딩하여 재정의하였음.
		System.out.println(d.toString());
		//toLocaleString() 사용하는 os에 따라 국가가 달라진다. 
		System.out.println(d.toLocaleString());
		System.out.println(d.toGMTString());
		//1900년부터 연도가 새로 시작한다. +1900해서 사용하자.
		System.out.println("년 : " + (d.getYear()+1900));
		//getMonth에는 0부터 11까지가 들어있다. +1을 해서 사용하자.
		System.out.println("월 : "+(d.getMonth()+1));
		System.out.println("일 : "+(d.getDate()));
		//일요일을 0부터 시작하여 토요일 6까지 숫자로 출력된다.
		System.out.println("요일 : "+(d.getDay()));
		System.out.println("시간 : "+d.getHours());
		System.out.println("분 : "+d.getMinutes());
		System.out.println("초 : "+d.getSeconds());
	}

}
