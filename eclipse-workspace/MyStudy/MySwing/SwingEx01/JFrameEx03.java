package SwingEx01;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameEx03 extends JFrame {
	private JPanel contentPane;

	public JFrameEx03() {

		this.setBounds(100, 100, 300, 300);
		this.setTitle("나는 제목");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임 위에 pane을 하나 놓았음.
		contentPane = new JPanel();
		// pane 사이에 공간주기
		contentPane.setLayout(new BorderLayout(10, 10));
		// 배경색 바꾸기
		contentPane.setBackground(Color.GREEN);
		setContentPane(contentPane);

		// 버튼1이라는 버튼을 만든다.
		JButton btn1 = new JButton("버튼 1");
		JButton btn2 = new JButton("버튼 2");
		JButton btn3 = new JButton("버튼 3");
		JButton btn4 = new JButton("버튼 4");
		JButton btn5 = new JButton("버튼 5");
		// 버튼 색 바꾸기
		btn5.setBackground(Color.BLUE);

		// 버튼을 컨테이너에 넣고, 위치를 지정한다.
		contentPane.add(btn1, "North");
		contentPane.add(btn2, "South");
		contentPane.add(btn3, "West");
		contentPane.add(btn4, "East");
		contentPane.add(btn5, "Center");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrameEx03 frame = new JFrameEx03();
		frame.setVisible(true);

	}

}
