package Thread.pack5;

import java.time.LocalTime;

public class BookSleepTest1 {

	static class Timer extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i =0 ; i < 3; i++) {
				try {
					//1초(1000밀리초) 동안 잠시 멈춤
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("째깍 : " + LocalTime.now());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.start();
	}

}
