package Thread.pack4;

public class ThreadEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StatePrintThread statePrintThread
		= new StatePrintThread(new TargetThread());
		
		statePrintThread.start();
	}
}
