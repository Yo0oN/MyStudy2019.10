package Thread.pack4;

public class TargetThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(long i = 0 ; i<1000000000 ; i++) {
			
		}
		
		//1500ms 동안 잠시 멈춤
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(long i = 0 ; i<1000000000 ; i++) {
			
		}
	}
}
