package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JOpionJuminCheckEx01 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOpionJuminCheckEx01 frame = new JOpionJuminCheckEx01();
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
	public JOpionJuminCheckEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextField jumin1 = new JTextField();
		jumin1.setBounds(12, 10, 137, 21);
		contentPane.add(jumin1);
		jumin1.setColumns(10);

		JTextField jumin2 = new JTextField();
		jumin2.setBounds(167, 10, 137, 21);
		contentPane.add(jumin2);
		jumin2.setColumns(10);

		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String jumin = jumin1.getText() + jumin2.getText();
				try {
					int sepResult = 0;

					for (int i = 0, j = 2; i < 12; i++, j++) {
						// 하나씩 분리한다.
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
					if (checkID == finalID) {
						lbl.setText("확인완료");
					} else {
						lbl.setText("다시 입력하세요");
					}

				} catch (StringIndexOutOfBoundsException a) {
					JOptionPane.showMessageDialog(JOpionJuminCheckEx01.this, "앞자리는 6자리, 뒷자리는 7자리로 입력해주세요.");
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(JOpionJuminCheckEx01.this, "숫자를 입력해주세요!");
				}
			}
		});
		btn.setBounds(316, 9, 97, 23);
		contentPane.add(btn);

		lbl = new JLabel("");
		lbl.setBounds(44, 41, 146, 15);
		contentPane.add(lbl);

		JLabel lbl2 = new JLabel("확인 : ");
		lbl2.setBounds(6, 41, 57, 15);
		contentPane.add(lbl2);
	}
}
