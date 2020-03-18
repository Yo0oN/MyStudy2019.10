package Thread.pack6;

public class Account {
	//처음에 정해진 숫자.(통장 잔고)
	private int balance = 1000;
	//balance는 통장잔고로 정해진 수기때문에 private처리해주었다.
	//getter를 이용해 외부에서 접근할 수 있게 해주었다.
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int money) {
		if(balance >= money) {
			//돈이 계속 빠지는 사이사이 1초간 잠시 잠들게 제어한다.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//돈이 빠진다.
			balance -= money;
		} else {
			System.out.println("잔고가 없습니다.");
		}
	}
}
