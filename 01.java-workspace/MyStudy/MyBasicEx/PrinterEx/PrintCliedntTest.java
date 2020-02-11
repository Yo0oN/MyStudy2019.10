package PrinterEx;

public class PrintCliedntTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintClient pc = new PrintClient();
		pc.setPrinter(new DotPrinter());
		pc.printThis("Hello.java");
		
		pc.setPrinter(new LaserPrinter());
		pc.printThis("Hi.java");
	}

}
