package Thread.pack2;

public class Come extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i <= 10 ; i++) {
			System.out.println("come : " + i);
		}
	}
}
