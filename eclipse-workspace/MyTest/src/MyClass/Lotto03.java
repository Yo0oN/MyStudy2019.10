package MyClass;
import java.util.TreeSet;
import java.util.Iterator;

public class Lotto03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자 6개씩 5줄이 나오는 로또를 만들어보자
		//이번에는 중복 없이 만들어보자.
		//+오름차순으로
		
		//아래의 일을 5번 반복한다 - 4번
		for(Integer i = 1 ; i <= 5 ; i++) {
			
			//TreeSet에 Integer만 들어가는 lotto방을 만들어준다. - 1번
			TreeSet<Integer> lotto = new TreeSet<Integer>();
			
			//lotto방에 숫자를 6개만 넣는다. - 2번
			label : while(true) {
				//1~45까지 랜덤의 수를 lotto에 넣어준다. - 2-1번
				lotto.add((int)((Math.random()*45)+1));
				//숫자 6개가 들어가면 lotto방에 숫자넣는걸 정지한다. - 2-2번
				if(lotto.size() == 6) {
					break label;
				}
			}
			
			//로또를 Iterator를 이용하여 출력해준다. - 3번
			Iterator lottoresult = lotto.iterator();
			while(lottoresult.hasNext()) {
				System.out.print(lottoresult.next());
				System.out.printf("\t");
			}
				//위의방법으로 출력해도괜찮고,아래처럼 그냥 Strinh으로 쭉 뽑아도된다..
				//System.out.println(lotto.toString());
			//다음줄을 위하여 한줄 띄어준다.
			//System.out.println();
		}
	}
}
