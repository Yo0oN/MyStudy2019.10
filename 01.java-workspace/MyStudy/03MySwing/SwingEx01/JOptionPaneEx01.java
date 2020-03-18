package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JOptionPaneEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneEx01 frame = new JOptionPaneEx01();
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
	public JOptionPaneEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("New button");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(JOptionFrameEx01.this, "난 메시지");
				JOptionPane.showMessageDialog(JOptionPaneEx01.this,
						"난 메세지", "난 타이틀", JOptionPane.ERROR_MESSAGE);
			}
		});
		btn1.setBounds(12, 10, 97, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				int result = JOptionPane.showConfirmDialog(JOptionPaneEx01.this, "난 메시지");
				int result = JOptionPane.showConfirmDialog(JOptionPaneEx01.this,
						"난 메세지", "난 타이틀", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.out.println("YES");
				} else if (result == JOptionPane.NO_OPTION) {
					System.out.println("NO");
				} else if (result == JOptionPane.CLOSED_OPTION) {
					System.out.println("X");
				}
				System.out.println(result);
			}
		});
		btn2.setBounds(12, 43, 97, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("New button");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msg = JOptionPane.showInputDialog("메세지");
//				System.out.println(msg);
				if (msg != null) {
					System.out.println(msg);
				} else {
					System.out.println("취소");
				}
			}
		});
		btn3.setBounds(12, 76, 97, 23);
		contentPane.add(btn3);
	}

}
