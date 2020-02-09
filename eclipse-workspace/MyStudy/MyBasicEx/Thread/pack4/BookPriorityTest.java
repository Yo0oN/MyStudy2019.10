package Thread.pack4;

public class BookPriorityTest {
	static class MessengerThread extends Thread{
		public MessengerThread(String name) {
			super(name);
		}
		public void run() {
			for(int i = 0 ; i < 30 ; i++) {
				System.out.println(this.getName());
			}
		}
	}

	public static void main(String[] args) {
		Thread fThread = new MessengerThread("F");
		Thread tThread = new MessengerThread("T");
		fThread.setPriority(Thread.MIN_PRIORITY);
		tThread.setPriority(Thread.MAX_PRIORITY);
		fThread.start();
		tThread.start();
	}
}
