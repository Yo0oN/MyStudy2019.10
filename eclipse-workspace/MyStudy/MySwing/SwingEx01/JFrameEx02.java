package SwingEx01;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameEx02 extends JFrame {

//	public JFrameEx02() {
//		// 프레임 설정하기
////		this.setSize(1024, 768);
////		this.setLocation(100, 100);
//
//		this.setBounds(100, 100, 1024, 768);
//		this.setTitle("나는 제목2");
//		// x버튼을 클릭함면 프로그램 완전 종료
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JFrameEx02 frame = new JFrameEx02();
//		frame.setVisible(true);
		JFrame f = new JFrame("Login");
		f.setSize(300, 200);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		f.setLocation(screenSize.width/2 -150, screenSize.height/2-100);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
