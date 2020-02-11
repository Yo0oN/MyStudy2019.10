package AbstractEx;

public abstract class Vehicle {
	private int curX, curY;
	
	public void reportPsition() {
		System.out.printf("현재위치 : (%d, %d)%n", curX, curY);
	}
	public abstract void addFuel();
}
