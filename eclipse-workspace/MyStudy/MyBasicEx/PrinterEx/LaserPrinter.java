package PrinterEx;

public class LaserPrinter implements Printer {

	@Override
	public void print(String fileName) {
		// TODO Auto-generated method stub
		System.out.printf("Laser Printer로 출력 중 : %s%n", fileName);
	}
	
}
