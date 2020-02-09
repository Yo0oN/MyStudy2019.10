package Thread.pack3;

public class ThreadEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Go go = new Go();
		Come come = new Come();
		
		Thread t1 = new Thread(go);
		Thread t2 = new Thread(come);
		
		t1.start();
		t2.start();
	}
}
