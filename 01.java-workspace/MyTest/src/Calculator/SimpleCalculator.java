package Calculator;

public class SimpleCalculator {
	private double d1;
	private double d2;

	public double plus(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;

		double plus = d1 + d2;

		return plus;
	}

	public double minus(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;

		double minus = d1 - d2;

		return minus;
	}

	public double multiple(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;

		double multiple = d1 * d2;

		return multiple;
	}

	public double devide(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;

		double devide = d1 / d2;

		return devide;
	}

	public static void main(String[] args) {
	}
}
