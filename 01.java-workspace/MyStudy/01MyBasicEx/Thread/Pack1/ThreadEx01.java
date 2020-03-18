package Thread.Pack1;

public class ThreadEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Go go = new Go();
		Come come = new Come();
		
		//순차 처리
		go.go();
		come.come();
		
	}

}
