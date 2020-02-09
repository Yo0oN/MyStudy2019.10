package MyClass;
import java.util.TreeSet;

public class Lotto01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//한줄에 6개의 숫자가 나오는데, 그것이 5줄 있다.
		//한줄에 있는 숫자들은 중복없이, 오름차순으로 출력해보자.
		
		for(int i = 0 ; i < 5 ; i++) {
			//반복문안에 TreeSet호출까지 같이 넣는 이유는,
			//while에서 lotto의 길이를 6개로 제한해놨는데
			//호출이 밖에 있으면 lotto에만 값이 계속 쌓이는데 길이가6이니까 
			//6개가 입력됐다가 다음거들어올자리가없으니 그냥 그대로 멈추고
			//다른줄이 5줄 생기는게 아닌 같은줄만 5개 출력된다.
			//안에 입력하면 한번 호출해서 그 lotto를 출력하고,
			//다시 새로 호출해서 그 lotto를 출력하고를 반복할 수 있는거다.
			TreeSet<Integer> lotto = new TreeSet<Integer>();
			//6개를 출력한다.TreeSet은 어차피 중복허용이 안되니 6개가만들어지기전까진 안멈출거다.
			while (lotto.size() != 6) {
				//랜덤으로 수를 출력한다.
				//사실 int로 해도 오토박싱되어서 Integer타입으로 lotto에 들어가지긴 한다..
				Integer a = ((Integer)(int)(Math.random()*45)+1);
				//출력한 수를 더해준다.
				lotto.add(a);
			}
			System.out.println(lotto);
		}
	}
}
