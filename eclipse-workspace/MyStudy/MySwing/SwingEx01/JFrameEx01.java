package SwingEx01;
import javax.swing.JFrame;

public class JFrameEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 프레임 만들었음
		JFrame frame = new JFrame();

		// 프레임의 제목을 보여준다.
		frame.setTitle("나는 제목");
		// 프레임의 크기 설정
		// 크기는 출력되는 기본크기일 뿐, 내가 마우스로 드래그하여 크기변경가능하다. 
		frame.setSize(1024, 768);
		// 실행시 프레임이 화면이 뜨는 위치
		frame.setLocation(100, 100);
		// boolean값을 받아 화면에 보여주게한다.(false면 안보여주겠지..)
		frame.setVisible(true);
		//주의할 점은 내가 x표시를 눌러 종료시켰다 하여도, 종료된것은 아니다.
		// Terminal을 닫아주어야 완전히 종료된것임.
		
	}

}
