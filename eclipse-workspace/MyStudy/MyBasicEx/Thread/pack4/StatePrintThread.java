package Thread.pack4;

public class StatePrintThread extends Thread {
	private Thread targetThread;
	
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Thread.State state = targetThread.getState();
			
			//출력
			System.out.println("현재 상태 : "+ state );
			
			if(state == Thread.State.NEW) {
				targetThread.start();
			}
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
