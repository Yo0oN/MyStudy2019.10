package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JRadioEx01 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea;
	private JRadioButton rdbtn3;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioEx01 frame = new JRadioEx01();
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
	public JRadioEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rdbtn1 = new JRadioButton("사과");
		rdbtn1.setSelected(true);
		buttonGroup.add(rdbtn1);
		rdbtn1.setBounds(8, 6, 121, 23);
		contentPane.add(rdbtn1);

		rdbtn2 = new JRadioButton("수박");
		buttonGroup.add(rdbtn2);
		rdbtn2.setBounds(8, 31, 121, 23);
		contentPane.add(rdbtn2);

		rdbtn3 = new JRadioButton("딸기");
		buttonGroup.add(rdbtn3);
		rdbtn3.setBounds(8, 56, 121, 23);
		contentPane.add(rdbtn3);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(" ");
				if (rdbtn1.isSelected()) {
					textArea.setText(rdbtn1.getText());
				} else if (rdbtn2.isSelected()) {
					textArea.setText(rdbtn2.getText());
				} else if (rdbtn3.isSelected()) {
					textArea.setText(rdbtn3.getText());
				}
			}
		});
		btnNewButton.setBounds(137, 6, 121, 23);
		contentPane.add(btnNewButton);

		textArea = new JTextArea();
		textArea.setBounds(8, 85, 251, 152);
		contentPane.add(textArea);
	}
}
