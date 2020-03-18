package Thread.pack2;

public class Go extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1 ; i <=10 ; i ++) {
			System.out.println("go : " +i);
		}
	}
	
}
