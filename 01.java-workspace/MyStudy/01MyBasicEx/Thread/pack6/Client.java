package Thread.pack6;

public class Client implements Runnable {
	private Account account;
	
	public Client(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//balance의 값이 처음엔 1000인데 0이되기전까지 계속 진행한다.
		while(account.getBalance() > 0) {
			//money는 100원부터 300원까지의 값이 랜덤으로 할당된다.
			int money = (int)(Math.random()*3 + 1)*100;
			//withdraw 메소드는 balance에서 money를 계속 빼주는 메소드이다.
			//1000부터 시작해서 100부터 300까지를 랜덤으로 빼준다.
			account.withdraw(money);
			//1000에서 랜덤으로 빼준 값을 출력해준다.
			System.out.println("통장 잔고 : " + account.getBalance());
		}
	}
}
