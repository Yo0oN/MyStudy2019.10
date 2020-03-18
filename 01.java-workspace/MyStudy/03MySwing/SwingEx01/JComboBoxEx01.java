package SwingEx01;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JComboBoxEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboBoxEx01 frame = new JComboBoxEx01();
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
	public JComboBoxEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					System.out.println(comboBox.getSelectedItem());
			}
		});
//		comboBox.setModel(model);
		comboBox.setBounds(12, 10, 78, 39);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// String[] items = new String[] { "사과", "딸기", "수박", "키위" };
				// DefaultComboBoxModel model = new DefaultComboBoxModel(items);
				// comboBox.setModel(model);
				
				// comboBox.setModel(new CustomComboBoxModel());
				comboBox.setModel(new CustomComboBoxModel02());
			}
		});
		btnNewButton.setBounds(112, 18, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼을 누르면 콤보박스에서 무엇을 선택했는지 알 수 있게 해주자.
				System.out.println((String) comboBox.getSelectedItem());
			}
		});
		btnNewButton_1.setBounds(112, 51, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(46, 171, 78, 23);
		contentPane.add(comboBox_1);

	}
}
