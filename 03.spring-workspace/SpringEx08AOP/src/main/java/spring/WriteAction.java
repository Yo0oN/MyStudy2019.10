package spring;

public class WriteAction implements Action {
	private String writer;

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public void execute() {
		System.out.println("execute() 호출");
		System.out.println("Hello " + writer);
	}

	@Override
	public void execute1() {
		for (int i = 0; i < 1000000000; i++) {

		}
		System.out.println("execute1() 호출");
	}

	@Override
	public void execute2() {
		System.out.println("execute2() 호출");
	}
}
