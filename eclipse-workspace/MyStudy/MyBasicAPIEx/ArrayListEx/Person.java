package ArrayListEx;

public class Person {
	private String hakbun;
	private String name;
	
	//getter,setter를 두개다 안만들고,
	//constructor가 setter의 역할을 해주고 있다.
	public Person(String hakbun, String name) {
		this.hakbun = hakbun;
		this.name = name;
		}

	public String getHakbun() {
		return hakbun;
	}

	public String getName() {
		return name;
	}
	//Source에서 toString -> getter대신 toString으로 한번에 볼 수도 있다.
	@Override
	public String toString() {
		return "Person [hakbun=" + hakbun + ", name=" + name + "]";
	}	
	
}
