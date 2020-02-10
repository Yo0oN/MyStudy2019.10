package model1;

public class WriteAction {
	public WriteAction() {
		System.out.println("WriteAction 기본 생성자");
	}

	public WriteAction(BoardTO to) {
		System.out.println("WriteAction(BoardTO) 호출");
	}
	
	public WriteAction(BoardTO to, String name) {
		System.out.println("WriteAction(BoardTO to, String name) 호출");
	}
	
	public void execute() {
		System.out.println("실행 메서드 호출");
	}
}
