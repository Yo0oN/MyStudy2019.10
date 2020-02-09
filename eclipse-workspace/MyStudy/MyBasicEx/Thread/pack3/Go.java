package Thread.pack3;

public class Go implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//작업내용 기술하기.
		for(int i = 0 ; i <= 10 ; i++) {
			System.out.println("go : " + i);
		}
	}

}
