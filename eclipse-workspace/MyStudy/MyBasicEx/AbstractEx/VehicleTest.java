package AbstractEx;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle[] vehicles = {new DieselSULV(), new ElectricCar()};
		for (Vehicle v : vehicles) {
			v.addFuel();
			v.reportPsition();			
		}
	}
}
