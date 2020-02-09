package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;

public class JFrameEx05 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx05 frame = new JFrameEx05();
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
	public JFrameEx05() {
		setResizable(false);
		setTitle("제목글");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//줄바꿈을 할 수 없다.
		lbl1 = new JLabel("나는 라벨!\n나는 라벨!");
		lbl1.setFont(new Font("휴먼매직체", Font.ITALIC, 14));
		lbl1.setForeground(Color.PINK);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(12, 10, 203, 53);
		contentPane.add(lbl1);
		
		lbl1.setText("새로운 라벨!");
		// html에서는 줄바꿈가능함, 
		JLabel lbl2 = new JLabel("<html><font color='red'>Hello!</font><br/><font color='green'>Hello!</font></html>");
		lbl2.setBounds(12, 76, 195, 111);
		contentPane.add(lbl2);
		System.out.println(lbl1.getText());
	}
}
