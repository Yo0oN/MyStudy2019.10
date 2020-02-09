package MyClass;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuminCheckEx03Jframe extends JFrame {

	// 주민등록번호 검사기를 어떻게든 만들긴했는데 좀더 깔끔하게 만들어보자.
	
	private JPanel contentPane;
	private JTextField jumin1;
	private JTextField jumin2;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuminCheckEx03Jframe frame = new JuminCheckEx03Jframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JuminCheckEx03Jframe() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 117);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jumin1 = new JTextField();
		jumin1.setBounds(5, 5, 162, 21);
		contentPane.add(jumin1);
		jumin1.setColumns(10);

		jumin2 = new JTextField();
		jumin2.setColumns(10);
		jumin2.setBounds(186, 5, 162, 21);
		contentPane.add(jumin2);

		JButton btnNewButton = new JButton("주민등록번호");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 주민번호를 받아왔다.
				String jumin = jumin1.getText() + jumin2.getText();
				// System.out.println(jumin);
				int sepResult = 0;

				for (int i = 0, j = 2; i < 12; i++, j++) {
					// 받아온 주민번호를 하나씩 분리한다.
					String sepString = jumin.substring(i, i + 1);

					// 분리한것을 정수형으로 변경한다.
					int sepID = Integer.parseInt(sepString);
					// 곱할값이 2에서부터 쭉커지다가 x10이되었을때 10대신2를 곱할수있게 바꿔준다.
					if (j == 10) {
						j = 2;
					}
					// 각숫자에 순서대로 곱한 후 더한다.
					sepResult += sepID * j;
				}
				// 계산해주기
				int checkID = ((11 - (sepResult % 11)) % 10);
				// 마지막숫자빼주기
				int finalID = Integer.parseInt(jumin.substring(12));
				boolean right = (checkID == finalID);
				if (right) {
					lbl.setText("맞습니다");
				} else {
					lbl.setText("아닙니다");
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(358, 4, 108, 23);
		contentPane.add(btnNewButton);

		lbl = new JLabel("확인");
		lbl.setBounds(5, 36, 57, 15);
		contentPane.add(lbl);
	}

}
