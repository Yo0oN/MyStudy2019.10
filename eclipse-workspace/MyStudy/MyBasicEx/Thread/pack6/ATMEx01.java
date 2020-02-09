package Thread.pack6;

public class ATMEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account = new Account();

		//Account를 공유하는 Client를 2개만듬
		Client client1 = new Client(account);
		Client client2 = new Client(account);

		Thread t1 = new Thread(client1);
		Thread t2 = new Thread(client2);

		synchronized (account) {
			System.out.println("출력");
		}
		//스레드기때문에 둘이 순서 상관없이 동시에 진행한다.
		//스레드 안에 들어있는 withdraw 메소드에는 1초동안 잠들게하는 sleep이 들어있다.
		//하나가 스레드를 실행해서 행동을 한번 한 후 잠깐 멈춘 사이에
		//나머지가 스레드를 실행해서 행동을 하기 때문에
		//balance의 값이 순차적으로 주는것이아니라 겹쳐서 줄게된다.
		t1.start();
		t2.start();
	}
}
