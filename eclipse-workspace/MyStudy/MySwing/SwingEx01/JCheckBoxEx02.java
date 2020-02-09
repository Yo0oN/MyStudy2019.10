package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JCheckBoxEx02 extends JFrame {

	private JPanel contentPane;
	private JCheckBox chb1;
	private JCheckBox chb2;
	private JCheckBox chb3;
	private JCheckBox chb4;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckBoxEx02 frame = new JCheckBoxEx02();
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
	public JCheckBoxEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		chb1 = new JCheckBox("사과");
		chb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chb1.isSelected()) {
					textArea.append(chb1.getText() + "\n");
				}
				if (chb2.isSelected()) {
					textArea.append(chb2.getText() + "\n");
				}
				if (chb3.isSelected()) {
					textArea.append(chb3.getText() + "\n");
				}
				if (chb4.isSelected()) {
					textArea.append(chb4.getText() + "\n");
				}
			}
		});
		chb1.setBounds(8, 6, 115, 23);
		contentPane.add(chb1);

		chb2 = new JCheckBox("수박");
		chb2.setBounds(8, 39, 115, 23);
		contentPane.add(chb2);

		chb3 = new JCheckBox("딸기");
		chb3.setBounds(8, 76, 115, 23);
		contentPane.add(chb3);

		chb4 = new JCheckBox("키위");
		chb4.setBounds(8, 112, 115, 23);
		contentPane.add(chb4);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 클릭하면, 어떤것이 클릭되었는지 글상자에 보이게 하여라
//				textArea.setText("");
//				if (chb1.isSelected()) {
//					textArea.append(chb1.getText() + "\n");
//				}
//				if (chb2.isSelected()) {
//					textArea.append(chb2.getText() + "\n");
//				}
//				if (chb3.isSelected()) {
//					textArea.append(chb3.getText() + "\n");
//				}
//				if (chb4.isSelected()) {
//					textArea.append(chb4.getText() + "\n");
//				}
			}
		});
		btnNewButton.setBounds(155, 6, 97, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(8, 141, 244, 281);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
