package SystemEx;

public class SystemEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//프로그램 종료
		System.out.println("1");
		if (args.length !=1) {
			System.out.println("2");
			//검사 후 잘못되었을 경우 프로그램 종료
			System.exit(0);
		} else {
			//위의 조건에 해당되어서 if구문이 해당된다면 exit를 만나 프로그램이 종료,
			//해당되지않는다면 if는 실행되지 않고 다음으로 넘어온다.
			//그렇기때문에 굳이 else를 쓰지 않고 그냥 밖에 출력해도 상관없다..
			System.out.println("3");
		}
		System.out.println("4");
	}

}
