package ProcessBuilderEx;

public class ProcessBuilderEx01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//실행파일의 위치
		ProcessBuilder pb
		= new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe","www.naver.com");
		//notepad
		ProcessBuilder notepad
		= new ProcessBuilder("C:\\Windows\\System32\\notepad.exe");
		pb.start();
		notepad.start();
	}

}
