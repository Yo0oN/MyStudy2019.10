package Thread.pack5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookJoinTest {
	static class GuguThread extends Thread{
		private int dan;
		//1단부터 9단까지 각각 배열에 넣어줌
		String[] result = new String[9];
		
		public GuguThread(int dan) {
			this.dan = dan;
		}
		
		public void run() {
			for(int i = 1; i < 10 ; i++) {
				//1단부터 9단까지 각각 방에 넣어줌. 방에 String으로 들어감
				result[i-1] = dan + "*" + i + "=" + (dan*i);
				try {
					//1초 잠깐 멈춤
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		System.out.println(dan + "단 완료\t");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//위에서 계산식이있는 GuguThread 객체가 들어가는 리스트를 만들어줌.
		List<GuguThread> gugus = new ArrayList<>();
		
		for (int i = 1; i < 10 ; i++) {
			GuguThread gugu = new GuguThread(i);
			gugus.add(gugu);
			gugu.start();
		}
//		for (GuguThread gugu : gugus) {
//			try {
//				gugu.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.out.println("\n 구구단 출력");
		for(GuguThread gugu : gugus ) {
			System.out.println(Arrays.toString(gugu.result));
		}
	}
}
