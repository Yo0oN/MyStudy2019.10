package Thread.pack5;

public class ThreadEx01 {
	//1.멤버에 스레드를 생성법
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2. 일회용으로 한번사용하고 끝나는 스레드 생성법
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0 ; i <= 10 ; i++) {
					System.out.println("go : " + i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0 ; i <=10 ; i++) {
					System.out.println("come : " + i);
				}
			}
		});
		t1.start();
		t2.start();
	}
}
