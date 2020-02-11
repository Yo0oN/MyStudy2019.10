package HashSetEx;
import java.util.HashSet;

public class LottoEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i <5 ; i++) {
		HashSet<Integer> lottos = new HashSet<Integer>();
		while(true) {
			lottos.add((int)(Math.random()*45)+1);
			if (lottos.size() ==6) {
				break;
			}
		}
		System.out.println(lottos.toString());
		}
	}
}
