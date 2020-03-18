package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JCHeckboxEx01 extends JFrame {

	private JPanel contentPane;
	private JCheckBox bx3;
	private JCheckBox bx2;
	private JCheckBox bx1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCHeckboxEx01 frame = new JCHeckboxEx01();
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
	public JCHeckboxEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bx1 = new JCheckBox("사과");
		bx1.setBounds(8, 6, 115, 23);
		contentPane.add(bx1);
		
		bx2 = new JCheckBox("딸기");
		bx2.setSelected(true);
		bx2.setBounds(8, 31, 115, 23);
		contentPane.add(bx2);
		
		bx3 = new JCheckBox("키위");
		bx3.setBounds(8, 56, 115, 23);
		contentPane.add(bx3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(bx1.isSelected() + bx1.getText());
				System.out.println(bx2.isSelected() + bx2.getText());
				System.out.println(bx3.isSelected() + bx3.getText());
			}
		});
		btnNewButton.setBounds(161, 6, 97, 23);
		contentPane.add(btnNewButton);
	}
}
